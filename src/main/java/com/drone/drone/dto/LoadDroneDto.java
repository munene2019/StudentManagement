package com.drone.drone.dto;

import lombok.Data;

@Data
public class LoadDroneDto {
    private Integer droneId;
    private String weight;
    private String code;
    private String image;
    private String name;
}
