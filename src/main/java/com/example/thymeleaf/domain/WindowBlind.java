package com.example.thymeleaf.domain;

import com.example.thymeleaf.intersection_table.WindowBlindRoomInt;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "window_blind")
public class WindowBlind {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "windowBlindId")
    private Set<WindowBlindRoomInt> addedRoom = new HashSet<>();
    private String brand;
    private Integer opened;

    public WindowBlind() {
    }

    public WindowBlind(Long id, String brand, Integer opened, Set<WindowBlindRoomInt> addedRoom) {
        this.id = id;
        this.brand = brand;
        this.opened = opened;
        this.addedRoom = addedRoom;
    }

    public Set<WindowBlindRoomInt> getAddedRoom() {
        return addedRoom;
    }

    public void setAddedRoom(Set<WindowBlindRoomInt> addedRoom) {
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

    public Integer getOpened() {
        return opened;
    }

    public void setOpened(Integer opened) {
        this.opened = opened;
    }

}
