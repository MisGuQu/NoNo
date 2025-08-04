package com.example.focusflow.repository;

import com.example.focusflow.model.FeynmanNote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeynmanRepository extends JpaRepository<FeynmanNote, Long> {
    List<FeynmanNote> findByUserId(Long userId);
    List<FeynmanNote> findBySessionId(Long sessionId);
}
