package com.example.thymeleaf.controller;

import com.example.thymeleaf.domain.LightBulb;
import com.example.thymeleaf.domain.LightBulbsRoomInt;
import com.example.thymeleaf.service.LightBulbsRoomIntService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/light-bulbs-int")
public class LightBulbsRoomIntController {
    private final LightBulbsRoomIntService lightBulbsRoomIntService;

    public LightBulbsRoomIntController(LightBulbsRoomIntService lightBulbsRoomIntService) {
        this.lightBulbsRoomIntService = lightBulbsRoomIntService;
    }
    @PostMapping("/light-bulb-id/{lightBulbId}/room-id/{roomId}")
    public LightBulbsRoomInt assignLightBulbsToRoom(@PathVariable Integer lightBulbId,
                                                    @PathVariable Integer roomId) {
        return lightBulbsRoomIntService.assignLightBulbsToRoom(lightBulbId,roomId);
    }
    @PutMapping("/light-bulb-id/{lightBulbId}/intensity/{intensity}/on-off/{onOff}")
    public LightBulbsRoomInt setLightBulbValueToRoom(@PathVariable Integer lightBulbId,
                                                     @PathVariable Integer intensity,
                                                     @PathVariable Boolean onOff) {
        return lightBulbsRoomIntService.setLightBulbValueToRoom(lightBulbId,intensity,onOff);
    }


}
