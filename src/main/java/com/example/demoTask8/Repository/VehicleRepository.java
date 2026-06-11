package com.example.demoTask8.Repository;

import com.example.demoTask8.Entity.Employee;
import com.example.demoTask8.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
    @Query("Select v from Vehicle v where v.isActive=true")
    List<Vehicle> getAllActiveVehicle();

    @Query("Select v from Vehicle v where v.isActive=true AND v.vehicleId=:id")
    Vehicle getVehicleById(@Param("id") Integer id);

    @Query("Select v from Vehicle v where v.isActive=true AND v.vehicleModel=:nm")
    Vehicle getVehicleByModel(@Param("nm") String name);
}
