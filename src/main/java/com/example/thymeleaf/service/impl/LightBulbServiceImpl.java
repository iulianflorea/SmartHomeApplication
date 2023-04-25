package com.example.thymeleaf.service.impl;

import com.example.thymeleaf.domain.LightBulb;

import com.example.thymeleaf.repository.LightBulbRepository;
import com.example.thymeleaf.service.LightBulbService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LightBulbServiceImpl implements LightBulbService {
    private final LightBulbRepository lightBulbRepository;

    public LightBulbServiceImpl(LightBulbRepository lightBulbRepository) {
        this.lightBulbRepository = lightBulbRepository;
    }

    @Override
    public LightBulb saveLightBulb(LightBulb lightBulb) {
        return lightBulbRepository.save(lightBulb);
    }


    @Override
    public List<LightBulb> findAll() {
        List<LightBulb> lightBulbs = lightBulbRepository.findAll();
        System.out.println(lightBulbs);
        return lightBulbRepository.findAll();
    }

    @Override
    public Optional<LightBulb> findById(Long id) {
        return lightBulbRepository.findById(id);
    }

    @Override
    public LightBulb insertLightBulb(String brand, Integer intensity, Integer wattsPower, Boolean onOff) {
        LightBulb lightBulb = new LightBulb();
        lightBulb.setBrand(brand);
        lightBulb.setIntensity(intensity);
        lightBulb.setWattsPower(wattsPower);
        lightBulb.setOnOff(onOff);
        return saveLightBulb(lightBulb);
    }

    @Override
    public LightBulb setLightBulbValues(Long id, Integer intensity, Boolean onOff) {
        LightBulb lightBulbSelected = lightBulbRepository.findById(id).orElseThrow();
        lightBulbSelected.setIntensity(intensity);
        lightBulbSelected.setOnOff(onOff);
        return saveLightBulb(lightBulbSelected);
    }

    @Override
    public void delete(Long id) {
        LightBulb lightBulbToDelete = lightBulbRepository.findById(id).orElseThrow();
        lightBulbRepository.delete(lightBulbToDelete);
    }
}
