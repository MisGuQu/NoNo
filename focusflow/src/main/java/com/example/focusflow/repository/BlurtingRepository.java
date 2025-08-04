package com.example.focusflow.repository;

import com.example.focusflow.model.Blurting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlurtingRepository extends JpaRepository<Blurting, Long> {
    List<Blurting> findByUserId(Long userId);
    List<Blurting> findBySessionId(Long sessionId);
}
