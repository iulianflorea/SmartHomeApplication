package com.example.thymeleaf.domain;

import com.example.thymeleaf.intersection_table.LightBulbsRoomInt;
import com.example.thymeleaf.intersection_table.SocketRoomInt;
import com.example.thymeleaf.intersection_table.WindowBlindRoomInt;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "roomId")
    private Set<SocketRoomInt> socketsId = new HashSet<>();
    @OneToMany(mappedBy = "roomId")
    private Set<LightBulbsRoomInt> lightBulbsId = new HashSet<>();
    @OneToMany(mappedBy = "roomId")
    private Set<WindowBlindRoomInt> windowBlindsId = new HashSet<>();


    private Integer numberOfSockets;
    private Integer numberOfLightBulbs;
    private Integer numberOfWindows;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

    public Room() {
    }

    public Room(Integer numberOfSockets, Integer numberOfLightBulbs, Integer numberOfWindows, House house, Set<SocketRoomInt> socketsId, Set<LightBulbsRoomInt> lightBulbsId, Set<WindowBlindRoomInt> windowBlindsId) {
        this.numberOfSockets = numberOfSockets;
        this.numberOfLightBulbs = numberOfLightBulbs;
        this.numberOfWindows = numberOfWindows;
        this.house = house;
        this.socketsId = socketsId;
        this.lightBulbsId = lightBulbsId;
        this.windowBlindsId = windowBlindsId;
    }

    public Set<WindowBlindRoomInt> getWindowBlindsId() {
        return windowBlindsId;
    }

    public void setWindowBlindsId(Set<WindowBlindRoomInt> windowBlindsId) {
        this.windowBlindsId = windowBlindsId;
    }

    public Set<LightBulbsRoomInt> getLightBulbsId() {
        return lightBulbsId;
    }

    public void setLightBulbsId(Set<LightBulbsRoomInt> lightBulbsId) {
        this.lightBulbsId = lightBulbsId;
    }

    public Set<SocketRoomInt> getSocketsId() {
        return socketsId;
    }

    public void setSocketsId(Set<SocketRoomInt> socketsId) {
        this.socketsId = socketsId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberOfSockets() {
        return numberOfSockets;
    }

    public void setNumberOfSockets(Integer numberOfSockets) {
        this.numberOfSockets = numberOfSockets;
    }

    public Integer getNumberOfLightBulbs() {
        return numberOfLightBulbs;
    }

    public void setNumberOfLightBulbs(Integer numberOfLightBulbs) {
        this.numberOfLightBulbs = numberOfLightBulbs;
    }

    public Integer getNumberOfWindows() {
        return numberOfWindows;
    }

    public void setNumberOfWindows(Integer numberOfWindows) {
        this.numberOfWindows = numberOfWindows;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
