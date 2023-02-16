package com.example.thymeleaf.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "light_bulb_room")
public class LightBulbsRoomInt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "lightBulb_id")
    private LightBulb lightBulbId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room roomId;
    private Boolean onOff;
    private Integer intensity;

    public LightBulbsRoomInt(LightBulb lightBulbId, Room roomId, Boolean onOff, Integer intensity) {
        this.lightBulbId = lightBulbId;
        this.roomId = roomId;
        this.onOff = onOff;
        this.intensity = intensity;
    }
    public LightBulbsRoomInt(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LightBulb getLightBulbId() {
        return lightBulbId;
    }

    public void setLightBulbId(LightBulb lightBulbId) {
        this.lightBulbId = lightBulbId;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    public Boolean getOnOff() {
        return onOff;
    }

    public void setOnOff(Boolean onOff) {
        this.onOff = onOff;
    }

    public Integer getIntensity() {
        return intensity;
    }

    public void setIntensity(Integer intensity) {
        this.intensity = intensity;
    }
}
