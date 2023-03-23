package com.example.thymeleaf.controller;

import com.example.thymeleaf.domain.LightBulb;
import com.example.thymeleaf.domain.Socket;
import com.example.thymeleaf.service.LightBulbService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lightBulb")
public class LightBulbController {
    private final LightBulbService lightBulbService;

    public LightBulbController(LightBulbService lightBulbService) {
        this.lightBulbService = lightBulbService;
    }

    @GetMapping("/lightBulbs")
    public List<LightBulb> getAll() {
        return lightBulbService.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public Optional<LightBulb> findById(@PathVariable("id") Long id) {
        return lightBulbService.findById(id);
    }

    @PostMapping("/brand/{brand}/intensity/{intensity}/power/{power}/on-off/{true-false}")
    public LightBulb insertLightBulb(@PathVariable("brand") String brand,
                                     @PathVariable("intensity") Integer intensity,
                                     @PathVariable("power") Integer power,
                                     @PathVariable("true-false") Boolean onOff) {
        return lightBulbService.insertLightBulb(brand, intensity, power, onOff);
    }
    @PutMapping("/id/{id}/intensity/{intensity}/on-off/{on-off}")
    public LightBulb setLightBulbValues(@PathVariable("id") Long id,
                                        @PathVariable("intensity") Integer intensity,
                                        @PathVariable("on-off") Boolean onOff) {
        return lightBulbService.setLightBulbValues(id, intensity, onOff);
    }

    @DeleteMapping("/delete-id/{id}")
    public void delete(@PathVariable("id") Long id) {
        lightBulbService.delete(id);
    }
}
