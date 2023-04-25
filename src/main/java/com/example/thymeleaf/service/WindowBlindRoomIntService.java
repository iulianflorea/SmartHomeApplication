package com.example.thymeleaf.service;

import com.example.thymeleaf.domain.Room;
import com.example.thymeleaf.domain.WindowBlind;
import com.example.thymeleaf.intersection_table.WindowBlindRoomInt;
import com.example.thymeleaf.repository.RoomRepository;
import com.example.thymeleaf.repository.WindowBlindRepository;
import com.example.thymeleaf.repository.WindowBlindRoomIntRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;

@Service
public interface WindowBlindRoomIntService {


    WindowBlindRoomInt saveWindowBlindRoomInt(WindowBlindRoomInt windowBlindRoomInt);

    List<WindowBlindRoomInt> findAll();

    Optional<WindowBlindRoomInt> findById(Long id);

    WindowBlindRoomInt assignWindowBlindToRoom(Long windowBlindId, Long roomId);

    WindowBlindRoomInt setWindowBlindInRoom(Long id, Integer opened);

    void timer(Long windowBlindId, String hourIn, String minIn, Integer opened);

    void deleteById(Long id);
}
