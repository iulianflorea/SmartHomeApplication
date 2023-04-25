package com.example.thymeleaf.controller;

import com.example.thymeleaf.domain.Room;
import com.example.thymeleaf.service.RoomService;
import com.example.thymeleaf.service.impl.RoomServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomServiceImpl roomServiceImpl) {
        this.roomService = roomServiceImpl;
    }

    @GetMapping("/rooms")
    public List<Room> getAll() {
        return roomService.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public Optional<Room> findById(@PathVariable("id") Long id) {
        return roomService.findById(id);
    }

    @PostMapping("/socket/{socket}/light-bulbs/{light-bulbs}/windows/{windows}/house-id/{house-id}")
    public Room insertRoom(@PathVariable("socket") Integer numberOfSockets,
                           @PathVariable("light-bulbs") Integer numberOfLightBulbs,
                           @PathVariable("windows") Integer numberOfWindows,
                           @PathVariable("house-id") Long houseId) {
        return roomService.insertRoom(numberOfSockets, numberOfLightBulbs, numberOfWindows, houseId);
    }


    @DeleteMapping("/delete-id/{id}")
    public void delete(@PathVariable("id") Long id) {
        roomService.delete(id);
    }
}
