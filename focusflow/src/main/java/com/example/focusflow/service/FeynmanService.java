package com.example.focusflow.service;

import com.example.focusflow.model.FeynmanNote;
import com.example.focusflow.repository.FeynmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FeynmanService {

    @Autowired
    private FeynmanRepository feynmanRepository;

    public List<FeynmanNote> findAll() {
        return feynmanRepository.findAll();
    }

    public void create(String topic, String explanation, Long sessionId) {
        FeynmanNote note = new FeynmanNote();
        note.setTopic(topic);
        note.setExplanation(explanation);
        note.setCreatedAt(LocalDateTime.now());
        // TODO: gán session, user nếu cần
        feynmanRepository.save(note);
    }

    public void deleteById(Long id) {
        feynmanRepository.deleteById(id);
    }
}
