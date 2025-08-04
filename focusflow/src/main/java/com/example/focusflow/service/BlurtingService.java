package com.example.focusflow.service;

import com.example.focusflow.model.Blurting;
import com.example.focusflow.repository.BlurtingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlurtingService {

    @Autowired
    private BlurtingRepository blurtingRepository;

    public List<Blurting> findAll() {
        return blurtingRepository.findAll();
    }

    public void createBlurting(String content, Long sessionId) {
        Blurting b = new Blurting();
        b.setContent(content);
        b.setCreatedAt(LocalDateTime.now());
        // TODO: gán session, user nếu cần
        blurtingRepository.save(b);
    }

    public void deleteById(Long id) {
        blurtingRepository.deleteById(id);
    }
}
