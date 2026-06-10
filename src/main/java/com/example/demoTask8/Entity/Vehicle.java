package com.example.demoTask8.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer vehicleId;
    @NonNull
    private String vehicleModel;
    private Double rentalPricePerDay;
    private Boolean isActive;
}
