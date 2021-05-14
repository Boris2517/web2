package com.example.fitness.service;

import com.example.fitness.entity.Member;

public interface UserService {
    Member create(Member user) throws Exception;
}
