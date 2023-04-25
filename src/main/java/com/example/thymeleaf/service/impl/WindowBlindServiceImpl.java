package com.example.thymeleaf.service.impl;

import com.example.thymeleaf.domain.WindowBlind;
import com.example.thymeleaf.repository.WindowBlindRepository;
import com.example.thymeleaf.service.WindowBlindService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class WindowBlindServiceImpl implements WindowBlindService {
    private final WindowBlindRepository windowBlindRepository;

    public WindowBlindServiceImpl(WindowBlindRepository windowBlindRepository) {
        this.windowBlindRepository = windowBlindRepository;
    }

    @Override
    public WindowBlind saveWindowBlind(WindowBlind windowBlind) {
        return windowBlindRepository.save(windowBlind);
    }


    @Override
    public List<WindowBlind> findAll() {
        List<WindowBlind> windowBlindList = windowBlindRepository.findAll();
        System.out.println(windowBlindList);
        return windowBlindList;
    }


    @Override
    public Optional<WindowBlind> findById(Long id) {
        return windowBlindRepository.findById(id);
    }

    @Override
    public WindowBlind insertWindowBlind(String brand, Integer opened, String timer) {
        WindowBlind windowBlind = new WindowBlind();
        windowBlind.setBrand(brand);
        windowBlind.setOpened(opened);
        return saveWindowBlind(windowBlind);
    }

    @Override
    public void deleteById(Long id) {
        WindowBlind windowBlind = windowBlindRepository.findById(id).orElseThrow();
        windowBlindRepository.delete(windowBlind);
    }

}
