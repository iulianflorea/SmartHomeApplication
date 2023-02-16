package com.example.thymeleaf.controller;

import com.example.thymeleaf.domain.SocketRoomInt;
import com.example.thymeleaf.service.SocketRoomIntService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

@RestController
@RequestMapping("/socket-int")
public class SocketRoomIntController {
    private final SocketRoomIntService socketIntService;

    public SocketRoomIntController(SocketRoomIntService socketIntService) {
        this.socketIntService = socketIntService;
    }

    @PostMapping("/socket-id/{socketId}/room-id/{roomId}")
    public SocketRoomInt assignSocketToRoom(@PathVariable Integer socketId,
                                            @PathVariable Integer roomId) {
        return socketIntService.assignSocketToRoom(socketId, roomId);
    }

    @PutMapping("/socket-id/{socketId}/socket-set/{onOff}")
    public SocketRoomInt setSocketToRoom(@PathVariable Integer socketId,
                                         @PathVariable Boolean onOff) {
        return socketIntService.setSocketValueToRoom(socketId, onOff);
    }

    @PostMapping("/socket-id/{socketId}/hour-on/{hour}/{min}")
    public SocketRoomInt setSocketHourOn(@PathVariable Integer socketId,
                                         @PathVariable String hour,
                                         @PathVariable String min) throws InterruptedException {
        return socketIntService.setSocketHourOn(socketId,hour, min);
    }

    @PostMapping("/timer/{socketId}/{hourIn}/{minIn}")
    public void timer(@PathVariable Integer socketId,
                      @PathVariable String hourIn,
                      @PathVariable String minIn) {
        socketIntService.timer(socketId,hourIn,minIn);
    }
}
