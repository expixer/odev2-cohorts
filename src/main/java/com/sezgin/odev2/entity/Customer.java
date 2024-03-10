package com.sezgin.odev2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
    private String name;
    private LocalDate registrationDate;
    private final List<Invoice> invoices = new ArrayList<>();

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }
}