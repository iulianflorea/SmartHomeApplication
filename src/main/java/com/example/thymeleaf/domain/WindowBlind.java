package com.example.thymeleaf.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "window_blind")
public class WindowBlind {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private Integer opened;
    private String timer;

    public WindowBlind() {
    }

    public WindowBlind(Long id, String brand, Integer opened, String timer) {
        this.id = id;
        this.brand = brand;
        this.opened = opened;
        this.timer = timer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getOpened() {
        return opened;
    }

    public void setOpened(Integer opened) {
        this.opened = opened;
    }

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }
}
