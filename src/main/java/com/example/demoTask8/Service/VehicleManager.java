package com.example.demoTask8.Service;

import com.example.demoTask8.Entity.Vehicle;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleManager {
    List<Vehicle> vehicleList = new ArrayList<>();

    @PostConstruct
    public void AddData(){
        vehicleList.add(new Vehicle(101, "Toyota Corolla", 20.00));
        vehicleList.add(new Vehicle(102, "Nissan Sunny", 18.00));
        vehicleList.add(new Vehicle(103, "Hyundai Elantra", 22.00));
    }

    public String AddVehicle(Vehicle vehicle) {
        for (Vehicle v : vehicleList) {
            if (v.getVehicleId().equals(vehicle.getVehicleId())) {
                return "Vehicle ID already exists \n" +
                        "No vehicle was added";
            }

        }

        vehicleList.add(vehicle);
        return "****************************\n" +
                "Vehicle Added Successfully\n"
                + "Vehicle ID: " + vehicle.getVehicleId() + "\n"
                + "Vehicle Model: " + vehicle.getVehicleModel() + "\n"
                + "Rental Price Per Day: " + vehicle.getRentalPricePerDay() + " OMR\n"
                + "Status: Created\n"+
                "***************************\n";
    }

    public List<Vehicle> displayVehicle(){
        return vehicleList;
    }
}
