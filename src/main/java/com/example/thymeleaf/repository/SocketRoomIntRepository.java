package com.example.thymeleaf.repository;

import com.example.thymeleaf.domain.SocketRoomInt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocketRoomIntRepository extends JpaRepository<SocketRoomInt,Long> {
}
