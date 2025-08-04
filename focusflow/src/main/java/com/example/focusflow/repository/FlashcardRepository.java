package com.example.focusflow.repository;

import com.example.focusflow.model.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {
    List<Flashcard> findByUserId(Long userId);
    List<Flashcard> findBySessionId(Long sessionId);
}
