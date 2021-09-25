package com.example.fitness.service;

import com.example.fitness.entity.Hall;

import java.util.ArrayList;

public interface HallService {
    ArrayList<Hall> getHallByTrainer(String username);
}
