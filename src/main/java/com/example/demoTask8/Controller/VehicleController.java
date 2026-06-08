package com.example.demoTask8.Controller;

import com.example.demoTask8.Entity.Vehicle;
import com.example.demoTask8.Service.VehicleManager;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    VehicleManager vehicleManager;

    @PutMapping("addVehicle")
    public String addVehicle(@RequestParam String vehicleId,
                             @RequestParam String vehicleModel,
                             @RequestParam Double rentalPricePerDay) {
        Vehicle newVehicle = new Vehicle(vehicleId, vehicleModel, rentalPricePerDay);

        return vehicleManager.AddVehicle(newVehicle);
    }

    @GetMapping("displayVehicle")
    public List<Vehicle> displayVehicle() {
        return vehicleManager.displayVehicle();
    }
}
