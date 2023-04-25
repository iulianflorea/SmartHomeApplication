package com.example.thymeleaf.service.impl;

import com.example.thymeleaf.domain.Socket;
import com.example.thymeleaf.repository.RoomRepository;
import com.example.thymeleaf.repository.SocketRepository;
import com.example.thymeleaf.service.SocketService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocketServiceImpl implements SocketService {
    private final SocketRepository socketRepository;
    private final RoomServiceImpl roomServiceImpl;
    private final RoomRepository roomRepository;

    public SocketServiceImpl(SocketRepository socketRepository, RoomServiceImpl roomServiceImpl, RoomRepository roomRepository) {
        this.socketRepository = socketRepository;
        this.roomServiceImpl = roomServiceImpl;
        this.roomRepository = roomRepository;
    }
@Override
    public Socket saveSocket(Socket socket) {
        return socketRepository.save(socket);
    }

    @Override
    public List<Socket> findAll() {
        List<Socket> sockets = socketRepository.findAll();
        System.out.println(sockets);
        return socketRepository.findAll();
    }

    @Override
    public Optional<Socket> findById(Long id) {
        return socketRepository.findById(id);
    }

    @Override
    public Socket insertSocket(String brand, String color, Integer wattsPower, Boolean onOff) {
        Socket socket = new Socket();
        socket.setBrand(brand);
        socket.setColor(color);
        socket.setWattsPower(wattsPower);
        socket.setOnOff(onOff);
        return saveSocket(socket);
    }

    @Override
    public void delete(Long id) {
        Socket socketToDelete = socketRepository.findById(id).orElseThrow();
        socketRepository.delete(socketToDelete);
    }


}
