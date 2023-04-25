package com.example.thymeleaf.service;

import com.example.thymeleaf.domain.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    public Room saveRoom(Room room);

    public List<Room> findAll();

    public Optional<Room> findById(Long id);

    public Room insertRoom(Integer numberOfSockets, Integer numberOfLightBulbs,Integer numberOfWindows,Long houseId);

    public void delete(Long id);
}
