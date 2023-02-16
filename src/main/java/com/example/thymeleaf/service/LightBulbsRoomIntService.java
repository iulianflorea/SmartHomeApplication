package com.example.thymeleaf.service;

import com.example.thymeleaf.domain.LightBulb;
import com.example.thymeleaf.domain.LightBulbsRoomInt;
import com.example.thymeleaf.domain.Room;
import com.example.thymeleaf.repository.LightBulbRepository;
import com.example.thymeleaf.repository.LightBulbsRoomIntRepository;
import com.example.thymeleaf.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LightBulbsRoomIntService {
    private final LightBulbsRoomIntRepository lightBulbsRoomIntRepository;
    private final LightBulbRepository lightBulbRepository;
    private final RoomRepository roomRepository;

    public LightBulbsRoomIntService(LightBulbsRoomIntRepository lightBulbsRoomIntRepository, LightBulbRepository lightBulbRepository, RoomRepository roomRepository) {
        this.lightBulbsRoomIntRepository = lightBulbsRoomIntRepository;
        this.lightBulbRepository = lightBulbRepository;
        this.roomRepository = roomRepository;
    }

    public LightBulbsRoomInt saveLightBulbsRoomInt(LightBulbsRoomInt lightBulbsRoomInt) {
        return lightBulbsRoomIntRepository.save(lightBulbsRoomInt);
    }

    public List<LightBulbsRoomInt> findAll() {
        List<LightBulbsRoomInt> lightBulbsRoomInts = lightBulbsRoomIntRepository.findAll();
        System.out.println(lightBulbsRoomInts);
        return lightBulbsRoomIntRepository.findAll();
    }

    public Optional<LightBulbsRoomInt> findById(Integer id) {
        return lightBulbsRoomIntRepository.findById(id);
    }

    public LightBulbsRoomInt assignLightBulbsToRoom(Integer lightBulbId, Integer roomId) {
        LightBulbsRoomInt lightBulbsRoomInt = new LightBulbsRoomInt();
        LightBulb lightBulb = lightBulbRepository.findById(lightBulbId).orElseThrow();
        Room room = roomRepository.findById(roomId).orElseThrow();
        lightBulbsRoomInt.setLightBulbId(lightBulb);
        lightBulbsRoomInt.setRoomId(room);
        return saveLightBulbsRoomInt(lightBulbsRoomInt);
    }

    public LightBulbsRoomInt setLightBulbValueToRoom(Integer lightBulbsId, Integer intensity, Boolean onOff) {
        LightBulbsRoomInt lightBulbsRoomInt = lightBulbsRoomIntRepository.findById(lightBulbsId).orElseThrow();
        if (intensity >= 0 && intensity <= 100) {
            lightBulbsRoomInt.setIntensity(intensity);
        } else {
            System.out.println("Intensitatea trebuie sa fie cuprinsa intre 0 si 100");
        }
        lightBulbsRoomInt.setOnOff(onOff);
        return saveLightBulbsRoomInt(lightBulbsRoomInt);
    }

    public void deleteById(Integer id) {
        lightBulbsRoomIntRepository.deleteById(id);
    }
}
