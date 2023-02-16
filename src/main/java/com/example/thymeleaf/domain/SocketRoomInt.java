package com.example.thymeleaf.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "socket_room_int")
public class SocketRoomInt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "socket_id")
    private Socket socketId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room roomId;

    private Boolean onOff;

    private String hourOnOff;

    public SocketRoomInt(Socket socketId, Room roomId, Boolean onOff, String hourOnOff) {
        this.socketId = socketId;
        this.roomId = roomId;
        this.onOff = onOff;
        this.hourOnOff = hourOnOff;
    }

    public SocketRoomInt() {
    }

    public String getHourOnOff() {
        return hourOnOff;
    }

    public void setHourOnOff(String hourOnOff) {
        this.hourOnOff = hourOnOff;
    }

    public Boolean getOnOff() {
        return onOff;
    }

    public void setOnOff(Boolean onOff) {
        this.onOff = onOff;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Socket getSocketId() {
        return socketId;
    }

    public void setSocketId(Socket socketId) {
        this.socketId = socketId;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }


}

