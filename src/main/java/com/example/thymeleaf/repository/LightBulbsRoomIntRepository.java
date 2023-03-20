package com.example.thymeleaf.repository;

import com.example.thymeleaf.intersection_table.LightBulbsRoomInt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightBulbsRoomIntRepository extends JpaRepository<LightBulbsRoomInt,Long> {
}
