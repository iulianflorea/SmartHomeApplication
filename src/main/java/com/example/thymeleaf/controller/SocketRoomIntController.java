package com.example.thymeleaf.controller;

import com.example.thymeleaf.intersection_table.SocketRoomInt;
import com.example.thymeleaf.service.SocketRoomIntService;
import com.example.thymeleaf.service.impl.SocketRoomIntServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/socket-int")
public class SocketRoomIntController {
    private final SocketRoomIntService socketRoomIntService;

    public SocketRoomIntController(SocketRoomIntService socketIntService) {
        this.socketRoomIntService = socketIntService;
    }

    @PostMapping("/socket-id/{socketId}/room-id/{roomId}")
    public SocketRoomInt assignSocketToRoom(@PathVariable Long socketId,
                                            @PathVariable Long roomId) {
        return socketRoomIntService.assignSocketToRoom(socketId, roomId);
    }

    @PutMapping("/socket-id/{socketId}/socket-set/{onOff}")
    public SocketRoomInt setSocketToRoom(@PathVariable Long socketId,
                                         @PathVariable Boolean onOff) {
        return socketRoomIntService.setSocketValueToRoom(socketId, onOff);
    }

    @PostMapping("/timer/socket-id/{socketId}/hour-on/{hourIn}/{minIn}")
    public void timer(@PathVariable Long socketId,
                      @PathVariable String hourIn,
                      @PathVariable String minIn) {
        socketRoomIntService.timer(socketId,hourIn,minIn);
    }
}
