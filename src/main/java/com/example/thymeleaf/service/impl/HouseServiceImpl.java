package com.example.thymeleaf.service.impl;

import com.example.thymeleaf.domain.House;
import com.example.thymeleaf.repository.HouseRepository;
import com.example.thymeleaf.service.HouseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;

    public HouseServiceImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Override
    public House saveHouse(House house) {
        return houseRepository.save(house);
    }

    public List<House> findAll() {
        List<House> houses = houseRepository.findAll();
        System.out.println(houses);
        return houses;
    }

    @Override
    public Optional<House> findById(Long id) {
        return houseRepository.findById(id);
    }

    @Override
    public House insertHouse(Integer numberOfRooms, String color, Integer floors) {
        House house = new House();
        house.setNumberOfRooms(numberOfRooms);
        house.setColor(color);
        house.setFloors(floors);
        return saveHouse(house);
    }

    @Override
    public void delete(Long id) {
        House houseToDelete = houseRepository.findById(id).orElseThrow();
        houseRepository.delete(houseToDelete);
    }
}
