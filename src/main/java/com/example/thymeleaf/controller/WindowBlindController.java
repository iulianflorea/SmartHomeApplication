package com.example.thymeleaf.controller;

import com.example.thymeleaf.domain.LightBulb;
import com.example.thymeleaf.domain.WindowBlind;
import com.example.thymeleaf.service.WindowBlindService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/windowBlind")
public class WindowBlindController {
    private final WindowBlindService windowBlindService;

    public WindowBlindController(WindowBlindService windowBlindService) {
        this.windowBlindService = windowBlindService;
    }

    @GetMapping("/windowBlinds")
    public List<WindowBlind> getAll() {
        return windowBlindService.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public Optional<WindowBlind> findById(@PathVariable Long id) {
        return windowBlindService.findById(id);
    }

    @PostMapping("/brand/{brand}/intensity/{intensity}")
    public WindowBlind insertWindowBlind(@PathVariable("brand") String brand,
                                         @PathVariable("intensity") Integer intensity) {
        return windowBlindService.insertWindowBlind(brand, intensity);
    }
}
