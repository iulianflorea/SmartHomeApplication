package com.example.thymeleaf.service;

import com.example.thymeleaf.domain.LightBulb;

import com.example.thymeleaf.repository.LightBulbRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LightBulbService {
    private final LightBulbRepository lightBulbRepository;

    public LightBulbService(LightBulbRepository lightBulbRepository) {
        this.lightBulbRepository = lightBulbRepository;
    }

    public LightBulb saveLightBulb(LightBulb lightBulb) {
        return lightBulbRepository.save(lightBulb);
    }

    public List<LightBulb> findAll() {
        List<LightBulb> lightBulbs = lightBulbRepository.findAll();
        System.out.println(lightBulbs);
        return lightBulbRepository.findAll();
    }

    public Optional<LightBulb> findById(Integer id) {
        return lightBulbRepository.findById(id);
    }

    public LightBulb insertLightBulb(String brand, Integer intensity, Integer wattsPower, Boolean onOff) {
        LightBulb lightBulb = new LightBulb();
        lightBulb.setBrand(brand);
        lightBulb.setIntensity(intensity);
        lightBulb.setWattsPower(wattsPower);
        lightBulb.setOnOff(onOff);
        return saveLightBulb(lightBulb);
    }

    public LightBulb setLightBulbValues(Integer id, Integer intensity, Boolean onOff) {
        LightBulb lightBulbSelected = lightBulbRepository.findById(id).orElseThrow();
        lightBulbSelected.setIntensity(intensity);
        lightBulbSelected.setOnOff(onOff);
        return saveLightBulb(lightBulbSelected);
    }

    public void delete(Integer id) {
        LightBulb lightBulbToDelete = lightBulbRepository.findById(id).orElseThrow();
        lightBulbRepository.delete(lightBulbToDelete);
    }
}
