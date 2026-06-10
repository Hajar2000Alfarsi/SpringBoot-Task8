package com.example.demoTask8.Controller;

import com.example.demoTask8.Entity.Campaign;
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

    @PostMapping("add")
    public Vehicle AddVehicle(@RequestBody Vehicle vehicle) {
        return vehicleManager.addVehicle(vehicle);
    }

    @GetMapping("getAll")
    public List<Vehicle> getAllVehicle(){
        return vehicleManager.getAllVehicle();
    }

    @GetMapping("byId")
    public Vehicle getVehicleById(@RequestParam Integer id) {
        return vehicleManager.getVehicleById(id);
    }

    @GetMapping("byName")
    public Vehicle getVehicleByName(@RequestParam String name) {
        return vehicleManager.getVehicleByName(name);
    }

    @PutMapping("Update")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle) throws Exception{
        return vehicleManager.updateVehicle(vehicle);
    }

    @DeleteMapping("Delete")
    public Boolean deleteVehicle(@RequestParam Integer id) {
        return vehicleManager.deleteVehicleById(id);
    }
}
