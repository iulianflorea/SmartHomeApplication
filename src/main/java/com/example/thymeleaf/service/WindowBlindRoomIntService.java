package com.example.thymeleaf.service;

import com.example.thymeleaf.intersection_table.WindowBlindRoomInt;

import java.util.List;
import java.util.Optional;

public interface WindowBlindRoomIntService {

    WindowBlindRoomInt saveWindowBlindRoomInt(WindowBlindRoomInt windowBlindRoomInt);

    List<WindowBlindRoomInt> findAll();

    Optional<WindowBlindRoomInt> findById(Long id);

    WindowBlindRoomInt assignWindowBlindToRoom(Long windowBlindId, Long roomId);

    WindowBlindRoomInt setWindowBlindInRoom(Long id, Integer opened);

    void timer(Long windowBlindId, String hourIn, String minIn, Integer opened);

    void deleteById(Long id);
}
