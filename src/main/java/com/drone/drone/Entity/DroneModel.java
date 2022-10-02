package com.drone.drone.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name="DRONE")
@AllArgsConstructor
@NoArgsConstructor
public class DroneModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer  id;
    @Column(name="SERIAL", length=100 )
    private Integer serial;
    @Column(name="MODEL")
    private String model;
    @Column(name="WEIGHT_LIMIT")
    private String weightLimit;
    @Column(name="BATTERY_CAPACITY")
    private String batteryCapacity;
    @Column(name="STATE")
    private String state;
    public DroneModel(Integer id) {
        this.id = id;
    }
}
