package com.sezgin.odev2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Company {
    private String name;
    private String sector;
    private final Set<Customer> customers = new HashSet<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
}
