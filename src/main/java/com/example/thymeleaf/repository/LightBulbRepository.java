package com.example.thymeleaf.repository;

import com.example.thymeleaf.domain.LightBulb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightBulbRepository extends JpaRepository<LightBulb, Long> {

}
