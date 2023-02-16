package com.example.thymeleaf.repository;

import com.example.thymeleaf.domain.Socket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocketRepository extends JpaRepository<Socket, Integer> {
}
