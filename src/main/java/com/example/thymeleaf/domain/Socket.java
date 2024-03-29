package com.example.thymeleaf.domain;

import com.example.thymeleaf.intersection_table.SocketRoomInt;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Sockets")
public class Socket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@OneToMany(mappedBy = "socketId")
    private Set<SocketRoomInt> addedRoom = new HashSet<>();
    private String brand;
    private String color;
    private Integer wattsPower;
    private Boolean onOff;


    public Socket(String brand, String color,Integer wattsPower, Set<SocketRoomInt> addedRoom, Boolean onOff) {
        this.brand = brand;
        this.color = color;
        this.wattsPower = wattsPower;
        this.addedRoom = addedRoom;
        this.onOff = onOff;
    }

    public Socket() {

    }

    public Boolean getOnOff() {
        return onOff;
    }

    public void setOnOff(Boolean onOff) {
        this.onOff = onOff;
    }

   public Set<SocketRoomInt> getAddedRoom() {
        return addedRoom;
    }

    public void setAddedRoom(Set<SocketRoomInt> addedRoom) {
        this.addedRoom = addedRoom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWattsPower() {
        return wattsPower;
    }

    public void setWattsPower(Integer wattsPower) {
        this.wattsPower = wattsPower;
    }

}
