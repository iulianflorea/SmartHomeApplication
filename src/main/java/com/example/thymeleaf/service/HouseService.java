package com.example.thymeleaf.service;

import com.example.thymeleaf.domain.House;
import com.example.thymeleaf.repository.HouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService {
    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public House saveHouse(House house) {
        return houseRepository.save(house);
    }

    public List<House> findAll() {
        List<House> houses = houseRepository.findAll();
        System.out.println(houses);
        return houses;
    }

    public Optional<House> findById(Integer id) {
        return houseRepository.findById(id);
    }

    public House insertHouse(Integer numberOfRooms, String color, Integer floors) {
        House house = new House();
        house.setNumberOfRooms(numberOfRooms);
        house.setColor(color);
        house.setFloors(floors);
        return saveHouse(house);
    }

    public void delete(Integer id) {
        House houseToDelete = houseRepository.findById(id).orElseThrow();
        houseRepository.delete(houseToDelete);
    }
}
