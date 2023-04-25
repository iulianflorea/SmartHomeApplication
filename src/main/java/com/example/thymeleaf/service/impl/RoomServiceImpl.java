package com.example.thymeleaf.service.impl;

import com.example.thymeleaf.domain.House;
import com.example.thymeleaf.domain.Room;
import com.example.thymeleaf.repository.RoomRepository;
import com.example.thymeleaf.repository.SocketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements com.example.thymeleaf.service.RoomService {
    private final RoomRepository roomRepository;
    private final HouseServiceImpl houseService;
    private final SocketRepository socketRepository;

    public RoomServiceImpl(RoomRepository roomRepository, HouseServiceImpl houseService, SocketRepository socketRepository) {
        this.roomRepository = roomRepository;
        this.houseService = houseService;
        this.socketRepository = socketRepository;
    }

    @Override
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> findAll() {
        List<Room> rooms = roomRepository.findAll();
        System.out.println(rooms);
        return roomRepository.findAll();
    }

    @Override
    public Optional<Room> findById(Long id) {
        return roomRepository.findById(id);
    }

    @Override
    public Room insertRoom(Integer numberOfSockets, Integer numberOfLightBulbs,Integer numberOfWindows,Long houseId) {
        Room room = new Room();
        room.setNumberOfSockets(numberOfSockets);
        room.setNumberOfLightBulbs(numberOfLightBulbs);
        room.setNumberOfWindows(numberOfWindows);
        House house = houseService.findById(houseId).orElseThrow();
        room.setHouse(house);
        return saveRoom(room);
    }

    @Override
    public void delete(Long id) {
        Room roomToDelete = roomRepository.findById(id).orElseThrow();
        roomRepository.delete(roomToDelete);
    }

}
