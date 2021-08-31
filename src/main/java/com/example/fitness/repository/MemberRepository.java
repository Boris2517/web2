package com.example.fitness.repository;

import com.example.fitness.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface MemberRepository extends JpaRepository<Member,Long> {
    //Member findByUsername(String username);
    Optional<Member> findByUsername(String username);
}
