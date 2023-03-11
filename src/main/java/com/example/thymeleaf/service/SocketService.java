package com.example.thymeleaf.service;

import com.example.thymeleaf.domain.Socket;
import com.example.thymeleaf.repository.RoomRepository;
import com.example.thymeleaf.repository.SocketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocketService {
    private final SocketRepository socketRepository;
    private final RoomService roomService;
    private final RoomRepository roomRepository;

    public SocketService(SocketRepository socketRepository, RoomService roomService, RoomRepository roomRepository) {
        this.socketRepository = socketRepository;
        this.roomService = roomService;
        this.roomRepository = roomRepository;
    }

    public Socket saveSocket(Socket socket) {
        return socketRepository.save(socket);
    }

    public List<Socket> findAll() {
        List<Socket> sockets = socketRepository.findAll();
        System.out.println(sockets);
        return socketRepository.findAll();
    }

    public Optional<Socket> findById(Long id) {
        return socketRepository.findById(id);
    }

    public Socket insertSocket(String brand, String color, Integer wattsPower, Boolean onOff) {
        Socket socket = new Socket();
        socket.setBrand(brand);
        socket.setColor(color);
        socket.setWattsPower(wattsPower);
        socket.setOnOff(onOff);
        return saveSocket(socket);
    }


    public void delete(Long id) {
        Socket socketToDelete = socketRepository.findById(id).orElseThrow();
        socketRepository.delete(socketToDelete);
    }


}
