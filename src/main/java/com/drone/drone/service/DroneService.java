package com.drone.drone.service;

import com.drone.drone.controller.Utilities.CustomResponse;
import com.drone.drone.controller.Utilities.Response;
import com.drone.drone.dto.DroneDto;
import com.drone.drone.Entity.DroneModel;
import com.drone.drone.repository.DroneRepository;
import com.drone.drone.repository.DroneLoadedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DroneService {
    @Autowired
    DroneRepository droneRepository;
    @Autowired
    DroneLoadedRepository medicineRepository;
    CustomResponse response=new CustomResponse();
    public CustomResponse saveDrone(DroneDto droneDto){
        DroneModel drone=new DroneModel();
        Response response1=new Response();
        drone.setModel(droneDto.getModel());
        drone.setSerial(droneDto.getSerial());
        drone.setWeightLimit(droneDto.getWeightLimit());
        drone.setState(droneDto.getState());
        drone.setBatteryCapacity(droneDto.getBatteryCapacity());
       DroneModel droneModel= droneRepository.findBySerial(droneDto.getSerial());
       if(droneModel==null){
           droneRepository.save(drone);
           response.setMessage("Drone Added successfully");
       }
       else{
           response.setMessage("Drone Already exist");
       }

        return response;

    }

    public  List<DroneModel> getDroneBatteryLevel(Integer id){

        List<DroneModel>drones= droneRepository.findAllById(Collections.singleton(id));

        System.out.println("Drones"+drones);
        return drones;

    }
    public  List<DroneModel> getAvailableDrones(){

        List<DroneModel>drones= droneRepository.findAvailableDrones();

        System.out.println("Drones"+drones);
        return drones;

    }
}
