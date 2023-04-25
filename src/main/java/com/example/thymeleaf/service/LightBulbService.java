package com.example.thymeleaf.service;

import com.example.thymeleaf.domain.LightBulb;

import java.util.List;
import java.util.Optional;

public interface LightBulbService {

    public LightBulb saveLightBulb(LightBulb lightBulb);

    public List<LightBulb> findAll();

    public Optional<LightBulb> findById(Long id);

    public LightBulb insertLightBulb(String brand, Integer intensity, Integer wattsPower, Boolean onOff);

    public LightBulb setLightBulbValues(Long id, Integer intensity, Boolean onOff);

    public void delete(Long id);
}
