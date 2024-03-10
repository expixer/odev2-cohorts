package com.sezgin.odev2;


import com.sezgin.odev2.entity.Customer;
import com.sezgin.odev2.entity.Invoice;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;
import java.time.Month;

import static com.sezgin.odev2.DummyData.customers;
import static com.sezgin.odev2.DummyData.companies;
import static com.sezgin.odev2.DummyData.initializeData;

@SpringBootApplication
public class Odev2Application {

	public static void main(String[] args) {
		initializeData();

		// Tüm müşteriler
		System.out.println("Tüm Müşteriler:");
		customers.forEach(customer -> System.out.println(customer.getName()));

		// Yeni Müşteri
		Customer newCustomer = new Customer("Yeni Müşteri", LocalDate.now());
		companies.get("Firma A").addCustomer(newCustomer);
		customers.add(newCustomer);

		// İçerisinde 'C' harfi olan müşteriler
		System.out.println("\nİçerisinde 'C' harfi olan müşteriler:");
		customers.stream()
				.filter(customer -> customer.getName().contains("C"))
				.forEach(customer -> System.out.println(customer.getName()));

		// Haziran ayında kayıt olan müşterilerin faturalarının toplam tutarı
		double totalInvoiceAmountForJuneCustomers = customers.stream()
				.filter(customer -> customer.getRegistrationDate().getMonth() == Month.JUNE)
				.flatMap(customer -> customer.getInvoices().stream())
				.mapToDouble(Invoice::getAmount)
				.sum();
		System.out.println("\nHaziran ayında kayıt olan müşterilerin faturalarının toplam tutarı: " + totalInvoiceAmountForJuneCustomers);

		// Sistemdeki tüm faturalar
		System.out.println("\nSistemdeki tüm faturalar:");
		customers.stream()
				.flatMap(customer -> customer.getInvoices().stream())
				.forEach(invoice -> System.out.println(invoice.getAmount()));

		// Sistemdeki 1500TL üstündeki faturalar
		System.out.println("\nSistemdeki 1500TL üstündeki faturalar:");
		customers.stream()
				.flatMap(customer -> customer.getInvoices().stream())
				.filter(invoice -> invoice.getAmount() > 1500)
				.forEach(invoice -> System.out.println(invoice.getAmount()));

		// Sistemdeki 1500TL üstündeki faturaların ortalaması
		double averageOverExpensiveInvoices = customers.stream()
				.flatMap(customer -> customer.getInvoices().stream())
				.filter(invoice -> invoice.getAmount() > 1500)
				.mapToDouble(Invoice::getAmount)
				.average()
				.orElse(0);
		System.out.println("\nSistemdeki 1500TL üstündeki faturaların ortalaması: " + averageOverExpensiveInvoices);

		// Sistemdeki 500TL altındaki faturalara sahip müşterilerin isimleri
		System.out.println("\nSistemdeki 500TL altındaki faturalara sahip müşteriler:");
		customers.stream()
				.filter(customer -> customer.getInvoices().stream().anyMatch(invoice -> invoice.getAmount() < 500))
				.map(Customer::getName)
				.forEach(System.out::println);

		// Haziran ayını faturalarını ortalaması 750 altı olan firmalarının hangi sektörde olduğunu listeleyen kod
		System.out.println("\nHaziran ayını faturalarını ortalaması 750 altı olan firmalar ve sektörleri:");
		companies.values().stream()
				.filter(company -> company.getCustomers().stream()
						.flatMap(customer -> customer.getInvoices().stream())
						.filter(invoice -> invoice.getDate().getMonth() == Month.JUNE)
						.mapToDouble(Invoice::getAmount)
						.average()
						.orElse(0) < 750)
				.forEach(company -> System.out.println(company.getName() + " - " + company.getSector()));
	}




}
