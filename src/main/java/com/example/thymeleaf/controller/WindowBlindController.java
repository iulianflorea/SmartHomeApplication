package com.example.thymeleaf.controller;

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

    @PostMapping("/insert-window-blind/brand/{brand}/opened/{opened}/timer/{timer}")
    public WindowBlind insertWindowBlind(@PathVariable String brand,
                                         @PathVariable Integer opened,
                                         @PathVariable String timer) {
        return windowBlindService.insertWindowBlind(brand, opened, timer);
    }

    @DeleteMapping("/delete-window-blind-byId/{id}")
    public void deleteById(@PathVariable Long id) {
        windowBlindService.deleteById(id);
    }
}
