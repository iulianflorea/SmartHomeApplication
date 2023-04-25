package com.example.thymeleaf.service;

import com.example.thymeleaf.intersection_table.SocketRoomInt;

import java.util.List;
import java.util.Optional;

public interface SocketRoomIntService {

    public SocketRoomInt saveSocketRoomInt(SocketRoomInt socketRoomInt);

    public List<SocketRoomInt> findAll();

    public Optional<SocketRoomInt> findById(Long id);

    public SocketRoomInt assignSocketToRoom(Long socketId, Long roomId);

    public SocketRoomInt setSocketValueToRoom(Long socketId, Boolean onOff);

    public void timer(Long socketId, String hourIn, String minIn);


}
