package com.example.thymeleaf.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "light_bulbs")
public class LightBulb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   @OneToMany(mappedBy = "lightBulbId")
    private Set<LightBulbsRoomInt> addedRoom = new HashSet<>();
    private String brand;
    private Integer intensity;
    private Integer wattsPower;
    private Boolean onOff;

    public LightBulb(Integer intensity, String brand, Integer wattsPower, Boolean onOff, Set<LightBulbsRoomInt> addedRoom) {
        this.brand = brand;
        this.intensity = intensity;
        this.wattsPower = wattsPower;
        this.onOff = onOff;
        this.addedRoom = addedRoom;
    }


    public Set<LightBulbsRoomInt> getAddedRoom() {
        return addedRoom;
    }

    public void setAddedRoom(Set<LightBulbsRoomInt> addedRoom) {
        this.addedRoom = addedRoom;
    }

    public LightBulb(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getIntensity() {
        return intensity;
    }

    public void setIntensity(Integer intesity) {
        this.intensity = intesity;
    }

    public Integer getWattsPower() {
        return wattsPower;
    }

    public void setWattsPower(Integer wattsPower) {
        this.wattsPower = wattsPower;
    }

    public Boolean getOnOff() {
        return onOff;
    }

    public void setOnOff(Boolean onOff) {
        this.onOff = onOff;
    }
}
