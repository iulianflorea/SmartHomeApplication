package com.example.thymeleaf.service;

import com.example.thymeleaf.domain.Socket;

import java.util.List;
import java.util.Optional;

public interface SocketService {
    Socket saveSocket(Socket socket);

    List<Socket> findAll();

    Optional<Socket> findById(Long id);

    Socket insertSocket(String brand, String color, Integer wattsPower, Boolean onOff);

    void delete(Long id);
}
