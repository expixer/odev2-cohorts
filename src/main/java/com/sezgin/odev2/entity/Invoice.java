package com.sezgin.odev2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Invoice {
    private double amount;
    private LocalDate date;
}