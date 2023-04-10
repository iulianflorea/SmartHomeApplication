package com.example.thymeleaf.intersection_table;

import com.example.thymeleaf.domain.Room;
import com.example.thymeleaf.domain.WindowBlind;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
@Entity
public class WindowBlindRoomInt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "windowBlind_id")
    private WindowBlind windowBlindId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room roomId;
    private String brand;
    private Integer opened;
    private String timer;

    public WindowBlindRoomInt(){}

    public WindowBlindRoomInt(WindowBlind windowBlindId, Room roomId, String brand, Integer opened, String timer) {
        this.windowBlindId = windowBlindId;
        this.roomId = roomId;
        this.brand = brand;
        this.opened = opened;
        this.timer = timer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WindowBlind getWindowBlindId() {
        return windowBlindId;
    }

    public void setWindowBlindId(WindowBlind windowBlindId) {
        this.windowBlindId = windowBlindId;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
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

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }
}
