package com.example.thymeleaf.service;

import com.example.thymeleaf.intersection_table.LightBulbsRoomInt;

import java.util.List;
import java.util.Optional;

public interface LightBulbRoomIntService {

    public LightBulbsRoomInt saveLightBulbsRoomInt(LightBulbsRoomInt lightBulbsRoomInt);

    public List<LightBulbsRoomInt> findAll();

    public Optional<LightBulbsRoomInt> findById(Long id);

    public LightBulbsRoomInt assignLightBulbsToRoom(Long lightBulbId, Long roomId);

    public LightBulbsRoomInt setLightBulbValueToRoom(Long lightBulbsId, Integer intensity, Boolean onOff);

    public void timer(Long lightBulbId, String hourIn, String minIn);
}
