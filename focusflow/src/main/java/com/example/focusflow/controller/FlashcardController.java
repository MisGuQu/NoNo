package com.example.focusflow.controller;

import com.example.focusflow.model.Flashcard;
import com.example.focusflow.service.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flashcards")
public class FlashcardController {

    @Autowired
    private FlashcardService flashcardService;

    @GetMapping("/user/{userId}")
    public List<Flashcard> getFlashcards(@PathVariable Long userId) {
        return flashcardService.getByUser(userId);
    }

    @PostMapping
    public Flashcard save(@RequestBody Flashcard flashcard) {
        return flashcardService.save(flashcard);
    }
}
