package com.example.thymeleaf.repository;

import com.example.thymeleaf.domain.WindowBlind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WindowBlindRepository  extends JpaRepository<WindowBlind, Long> {
}
