package com.example.focusflow.service;

import com.example.focusflow.model.Flashcard;
import com.example.focusflow.repository.FlashcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlashcardService {

    @Autowired
    private FlashcardRepository flashcardRepository;

    public List<Flashcard> getByUser(Long userId) {
        return flashcardRepository.findByUserId(userId);
    }

    public Flashcard save(Flashcard card) {
        return flashcardRepository.save(card);
    }
}
