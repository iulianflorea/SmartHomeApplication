package com.example.thymeleaf.repository;

import com.example.thymeleaf.domain.WindowBlind;
import com.example.thymeleaf.intersection_table.WindowBlindRoomInt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WindowBlindRoomIntRepository extends JpaRepository<WindowBlindRoomInt, Long> {
}
