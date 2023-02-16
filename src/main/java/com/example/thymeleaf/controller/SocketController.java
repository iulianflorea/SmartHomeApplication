package com.example.thymeleaf.controller;

import com.example.thymeleaf.domain.Socket;
import com.example.thymeleaf.service.SocketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/socket")
public class SocketController {
    private SocketService socketService;

    public SocketController(SocketService socketService) {
        this.socketService = socketService;
    }

    @GetMapping("/sockets")
    public List<Socket> getAll() {
        return socketService.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public Optional<Socket> findById(@PathVariable("id") Integer id) {
        return socketService.findById(id);
    }

    @PostMapping("/brand/{brand}/color/{color}/power/{power}/on-off/{onOff}")
    public Socket insertSocket(@PathVariable("brand") String brand,
                                @PathVariable("color") String color,
                                @PathVariable("power") java.lang.Integer power,
                                @PathVariable("onOff") Boolean onOff) {
        return socketService.insertSocket(brand, color, power,onOff);
    }

//    @PutMapping("/socket-id/{socketId}/room-id/{roomId}")
//    public Socket assignSocketToRoom(
//            @PathVariable Integer socketId,
//            @PathVariable Integer roomId) {
//        return socketService.assignSocketToRoom(socketId, roomId);
//    }

    @DeleteMapping("/delete-id/{id}")
    public void delete(@PathVariable("id") java.lang.Integer id) {
        socketService.delete(id);
    }


}
