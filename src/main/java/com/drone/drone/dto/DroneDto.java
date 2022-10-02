package com.drone.drone.dto;

import lombok.Data;

@Data
public class DroneDto {
    public Integer serial;
    public String model;
    public String weightLimit;
    public String batteryCapacity;
    public String state;
}
