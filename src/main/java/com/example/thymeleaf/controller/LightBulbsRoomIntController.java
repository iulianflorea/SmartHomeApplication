package com.example.thymeleaf.controller;

import com.example.thymeleaf.intersection_table.LightBulbsRoomInt;
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
    public LightBulbsRoomInt assignLightBulbsToRoom(@PathVariable Long lightBulbId,
                                                    @PathVariable Long roomId) {
        return lightBulbsRoomIntService.assignLightBulbsToRoom(lightBulbId,roomId);
    }
    @PutMapping("/light-bulb-id/{lightBulbId}/intensity/{intensity}/on-off/{onOff}")
    public LightBulbsRoomInt setLightBulbValueToRoom(@PathVariable Long lightBulbId,
                                                     @PathVariable Integer intensity,
                                                     @PathVariable Boolean onOff) {
        return lightBulbsRoomIntService.setLightBulbValueToRoom(lightBulbId,intensity,onOff);
    }
    @PostMapping("/timer/light-bulb-id/{lightBulbId}/hour-on/{hourIn}/{minIn}")
    public void timer(@PathVariable Long lightBulbId,
                                   @PathVariable String hourIn,
                                   @PathVariable String minIn) {
        lightBulbsRoomIntService.timer(lightBulbId,hourIn,minIn);
    }


}
