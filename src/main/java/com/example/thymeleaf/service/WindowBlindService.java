package com.example.thymeleaf.service;

import com.example.thymeleaf.domain.WindowBlind;

import java.util.List;
import java.util.Optional;

public interface WindowBlindService {
    WindowBlind saveWindowBlind(WindowBlind windowBlind);

    List<WindowBlind> findAll();

    Optional<WindowBlind> findById(Long id);

    WindowBlind insertWindowBlind(String brand, Integer opened, String timer);

    void deleteById(Long id);
}
