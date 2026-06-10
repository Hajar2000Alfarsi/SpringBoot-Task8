package com.example.demoTask8.Service;

import com.example.demoTask8.Entity.Campaign;
import com.example.demoTask8.Entity.Vehicle;
import com.example.demoTask8.Repository.CampaignRepository;
import com.example.demoTask8.Repository.VehicleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleManager {
    @Autowired
    VehicleRepository vehicleRepository;

    public Vehicle addVehicle(Vehicle vehicle) {

        Vehicle newVehicle = new Vehicle();

        newVehicle.setVehicleModel(vehicle.getVehicleModel());
        newVehicle.setRentalPricePerDay(vehicle.getRentalPricePerDay());
        newVehicle.setIsActive(true);

        return vehicleRepository.save(newVehicle);
    }

    public List<Vehicle> getAllVehicle() {
        return vehicleRepository.getAllActiveVehicle();
    }

    public Vehicle getVehicleById(Integer id) {
        return vehicleRepository.getVehicleById(id);
    }

    public Vehicle getVehicleByName(String name) {
        return vehicleRepository.getVehicleByModel(name);
    }

    public Vehicle updateVehicle(Vehicle updateVehicle) throws Exception {
        Vehicle existingVehicle = vehicleRepository.getVehicleById(updateVehicle.getVehicleId());

        if (existingVehicle != null) {
            if (!existingVehicle.getVehicleModel().equals(updateVehicle.getVehicleModel())) {
                existingVehicle.setVehicleModel(updateVehicle.getVehicleModel());
            }
            if (!existingVehicle.getRentalPricePerDay().equals(updateVehicle.getRentalPricePerDay())) {
                existingVehicle.setRentalPricePerDay(updateVehicle.getRentalPricePerDay());
            }
            return vehicleRepository.save(existingVehicle);
        }
        throw new Exception ("Invalid Data");
    }

    public Boolean deleteVehicleById(Integer id) {
        Vehicle VehicleToDelete = vehicleRepository.getVehicleById(id);

        if (VehicleToDelete !=  null) {
            VehicleToDelete.setIsActive(false);
            vehicleRepository.save(VehicleToDelete);
            return true;
        } else {
            return false;
        }
    }

}
