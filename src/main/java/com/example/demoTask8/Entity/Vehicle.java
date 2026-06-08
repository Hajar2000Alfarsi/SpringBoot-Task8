package com.example.demoTask8.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehicle {
    private String vehicleId;
    private String vehicleModel;
    private Double rentalPricePerDay;
}
