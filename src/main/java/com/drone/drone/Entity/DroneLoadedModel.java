package com.drone.drone.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name="DRONE_LOADED")
@AllArgsConstructor
@NoArgsConstructor
public class DroneLoadedModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer  id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "DRONE_ID", referencedColumnName = "ID")
    @JsonIgnore
    private DroneModel drone;
    @Column(name="NAME")
    private String name;
    @Column(name="WEIGHT")
    private String weight;
    @Column(name="CODE")
    private String code;
    @Column(name="IMAGE")
    private String image;

}
