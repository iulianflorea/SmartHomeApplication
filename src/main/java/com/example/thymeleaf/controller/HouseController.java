package com.example.thymeleaf.controller;

import com.example.thymeleaf.domain.House;
import com.example.thymeleaf.service.HouseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/house")
public class HouseController {
    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @PostMapping("/add")
    public void addHouse(@RequestParam House house) {
        houseService.saveHouse(house);
    }

    @GetMapping("/houses")
    public List<House> getAll() {
        return houseService.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public Optional<House> findById(@PathVariable("id") Integer id) {
        return houseService.findById(id);
    }

    @GetMapping("/insert-rooms/{id}/color/{color}/floors/{floors}")
    public House insertHouse(@PathVariable("id")Integer numberOfHouse,
                             @PathVariable("color")String color,
                             @PathVariable("floors")Integer floors) {
       return houseService.insertHouse(numberOfHouse,color,floors);
    }

    @DeleteMapping("/delete-id/{id}")
    public void delete(@PathVariable("id") Integer id) {
        houseService.delete(id);
    }
}
