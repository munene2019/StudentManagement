package com.drone.drone.service;

import com.drone.drone.Entity.DroneModel;
import com.drone.drone.controller.Utilities.CustomResponse;
import com.drone.drone.dto.LoadDroneDto;
import com.drone.drone.Entity.DroneLoadedModel;
import com.drone.drone.repository.DroneRepository;
import com.drone.drone.repository.DroneLoadedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneLoadedService {
    @Autowired
    DroneLoadedRepository droneLoadedRepository;
    @Autowired
    DroneRepository droneRepository;

    public CustomResponse loadDrone(LoadDroneDto loadDroneDto) {
        DroneLoadedModel droneLoadedModel = new DroneLoadedModel();
        CustomResponse response = new CustomResponse();
        DroneModel droneModel = droneRepository.findById(loadDroneDto.getDroneId()).orElse(null);
        if (droneModel != null) {
            droneLoadedModel.setName(loadDroneDto.getName());
            droneLoadedModel.setDrone(new DroneModel(loadDroneDto.getDroneId()));
            droneLoadedModel.setCode(loadDroneDto.getCode());
            droneLoadedModel.setImage(loadDroneDto.getImage());
            droneLoadedModel.setWeight(loadDroneDto.getWeight());
            response.setMessage("Drone Loaded successfully");
            droneLoadedRepository.save(droneLoadedModel);
            droneRepository.updateDroneStatus(loadDroneDto.getDroneId());
        } else {
            response.setMessage(" Drone Does not Already exist");
        }

        return response;

    }
    public List<DroneLoadedModel> getAllDroneMedication(Integer id){
        DroneModel droneModel = droneRepository.findById(id).orElse(null);
        if(droneModel !=null){}
        List<DroneLoadedModel> droneMedication= droneLoadedRepository.findDroneMed(id);
        System.out.println("Drones"+droneMedication);
        return droneMedication;

    }
}
