package com.sezgin.odev2;

import com.sezgin.odev2.entity.Company;
import com.sezgin.odev2.entity.Customer;
import com.sezgin.odev2.entity.Invoice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyData {

    public static final Map<String, Company> companies = new HashMap<>();
    public static final List<Customer> customers = new ArrayList<>();

    static void initializeData() {
        Company companyA = new Company("Firma A", "Teknoloji");
        Company companyB = new Company("Firma B", "Perakende");
        companies.put("Firma A", companyA);
        companies.put("Firma B", companyB);

        Customer customer1 = new Customer("Ahmet C", LocalDate.of(2023, 6, 15));
        customer1.addInvoice(new Invoice(1000, LocalDate.of(2023, 6, 20)));
        customer1.addInvoice(new Invoice(2000, LocalDate.of(2023, 7, 1)));
        companyA.addCustomer(customer1);
        customers.add(customer1);

        Customer customer2 = new Customer("Mehmet D", LocalDate.of(2023, 5, 10));
        customer2.addInvoice(new Invoice(500, LocalDate.of(2023, 6, 5)));
        customer2.addInvoice(new Invoice(1800, LocalDate.of(2023, 7, 15)));
        companyB.addCustomer(customer2);
        customers.add(customer2);

        Customer customer3 = new Customer("Ali E", LocalDate.of(2023, 6, 25));
        customer3.addInvoice(new Invoice(300, LocalDate.of(2023, 6, 30)));
        customer3.addInvoice(new Invoice(1200, LocalDate.of(2023, 7, 10)));
        companyA.addCustomer(customer3);
        customers.add(customer3);
    }
}
