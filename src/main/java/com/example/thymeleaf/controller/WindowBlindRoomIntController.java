package com.example.thymeleaf.controller;

import com.example.thymeleaf.intersection_table.WindowBlindRoomInt;
import com.example.thymeleaf.service.WindowBlindRoomIntService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/windowBlindRoom")
public class WindowBlindRoomIntController {
    private final WindowBlindRoomIntService windowBlindRoomIntService;

    public WindowBlindRoomIntController(WindowBlindRoomIntService windowBlindRoomIntService) {
        this.windowBlindRoomIntService = windowBlindRoomIntService;
    }

    @PostMapping("/assign-room/window-blind-id/{windowBlindId}/room-id/{roomId}")
    public WindowBlindRoomInt assignWindowBlindToRoom(@PathVariable Long windowBlindId,
                                                      @PathVariable Long roomId) {
        return windowBlindRoomIntService.assignWindowBlindToRoom(windowBlindId, roomId);
    }

    @PutMapping("/set-window-blind/window-blind-id/{id}/opened/{opened}")
    public WindowBlindRoomInt setWindowBlindInRoom(@PathVariable Long id,
                                                   @PathVariable Integer opened) {
        return windowBlindRoomIntService.setWindowBlindInRoom(id, opened);
    }

    @PutMapping("/timer/id/{id}/hour/{hour}/min/{min}/opened/{opened}")
    public void timer(@PathVariable Long id,
                      @PathVariable String hour,
                      @PathVariable String min,
                      @PathVariable Integer opened) {
        windowBlindRoomIntService.timer(id, hour, min, opened);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public void deleteById(@PathVariable Long id) {
        windowBlindRoomIntService.deleteById(id);
    }


}
