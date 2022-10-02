package com.drone.drone.controller;

import com.drone.drone.controller.Utilities.CustomResponse;
import com.drone.drone.dto.DroneDto;
import com.drone.drone.Entity.DroneModel;
import com.drone.drone.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/drone")
public class DroneController {
    @Autowired
    DroneService droneService;

    @PostMapping(path = "/register")
    public CustomResponse saveDrone(@RequestBody DroneDto request) {
        System.out.println("BODY OBJECT "+ request);
        return droneService.saveDrone(request);
    }

    @GetMapping(path="/battery/{id}")
    public List<DroneModel> getDroneBatteryLevel(@PathVariable("id") Integer id){
        return droneService.getDroneBatteryLevel(id);
    }
    @GetMapping(path="/availableDrones")
    public List<DroneModel> getDronesAvailable(){
        return droneService.getAvailableDrones();

    }
}
