package com.example.thymeleaf.service;

import com.example.thymeleaf.domain.WindowBlind;
import com.example.thymeleaf.repository.WindowBlindRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class WindowBlindService {
    private final WindowBlindRepository windowBlindRepository;

    public WindowBlindService(WindowBlindRepository windowBlindRepository) {
        this.windowBlindRepository = windowBlindRepository;
    }

    public WindowBlind saveWindowBlind(WindowBlind windowBlind) {
        return windowBlindRepository.save(windowBlind);
    }

    public List<WindowBlind> findAll() {
        List<WindowBlind> windowBlindList = windowBlindRepository.findAll();
        System.out.println(windowBlindList);
        return windowBlindList;
    }

    public Optional<WindowBlind> findById(Long id) {
        return windowBlindRepository.findById(id);
    }

    public WindowBlind insertWindowBlind(String brand, Integer opened) {
        WindowBlind windowBlind = new WindowBlind();
        windowBlind.setBrand(brand);
        windowBlind.setOpened(opened);
        return saveWindowBlind(windowBlind);
    }

    public void deleteById(Long id) {
        WindowBlind windowBlind = windowBlindRepository.findById(id).orElseThrow();
        windowBlindRepository.delete(windowBlind);
    }

}
