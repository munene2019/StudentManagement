package com.drone.drone.repository;


import com.drone.drone.Entity.DroneLoadedModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DroneLoadedRepository extends JpaRepository<DroneLoadedModel,Integer> {
   @Query("FROM  DroneLoadedModel where drone_id=:id")
    List<DroneLoadedModel> findDroneMed(Integer id);

}
