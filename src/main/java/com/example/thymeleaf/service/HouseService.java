package com.example.thymeleaf.service;

import com.example.thymeleaf.domain.House;

import java.util.List;
import java.util.Optional;

public interface HouseService {


    public House saveHouse(House house);

    public List<House> findAll();

    public Optional<House> findById(Long id);

    public House insertHouse(Integer numberOfRooms, String color, Integer floors);

    public void delete(Long id);


}
