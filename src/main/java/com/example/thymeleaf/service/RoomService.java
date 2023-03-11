package com.example.thymeleaf.service;

import com.example.thymeleaf.domain.House;
import com.example.thymeleaf.domain.Room;
import com.example.thymeleaf.domain.Socket;
import com.example.thymeleaf.repository.RoomRepository;
import com.example.thymeleaf.repository.SocketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final HouseService houseService;
    private final SocketRepository socketRepository;

    public RoomService(RoomRepository roomRepository, HouseService houseService, SocketRepository socketRepository) {
        this.roomRepository = roomRepository;
        this.houseService = houseService;
        this.socketRepository = socketRepository;
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> findAll() {
        List<Room> rooms = roomRepository.findAll();
        System.out.println(rooms);
        return roomRepository.findAll();
    }

    public Optional<Room> findById(Long id) {
        return roomRepository.findById(id);
    }

    public Room insertRoom(Integer numberOfSockets, Integer numberOfLightBulbs,Integer numberOfWindows,Long houseId) {
        Room room = new Room();
        room.setNumberOfSockets(numberOfSockets);
        room.setNumberOfLightBulbs(numberOfLightBulbs);
        room.setNumberOfWindows(numberOfWindows);
        House house = houseService.findById(houseId).orElseThrow();
        room.setHouse(house);
        return saveRoom(room);
    }


    public void delete(Long id) {
        Room roomToDelete = roomRepository.findById(id).orElseThrow();
        roomRepository.delete(roomToDelete);
    }

    public Room setSocketToRoom(Long roomId, Long socketId, Boolean socketValue) {
        Room roomSelected = roomRepository.findById(roomId).get();
        Socket socket = socketRepository.findById(socketId).get();
        socket.setOnOff(socketValue);
        return saveRoom(roomSelected);
    }
}
