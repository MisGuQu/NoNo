package com.example.focusflow.repository;

import com.example.focusflow.model.ThreeTwoOne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThreeTwoOneRepository extends JpaRepository<ThreeTwoOne, Long> {
    List<ThreeTwoOne> findByUserId(Long userId);
    List<ThreeTwoOne> findBySessionId(Long sessionId);
}
