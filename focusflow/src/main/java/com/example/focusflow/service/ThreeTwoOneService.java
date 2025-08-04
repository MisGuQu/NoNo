package com.example.focusflow.service;

import com.example.focusflow.model.ThreeTwoOne;
import com.example.focusflow.repository.ThreeTwoOneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ThreeTwoOneService {

    @Autowired
    private ThreeTwoOneRepository threeTwoOneRepository;

    public List<ThreeTwoOne> findAll() {
        return threeTwoOneRepository.findAll();
    }

    public void create(String threeThings, String twoInteresting, String oneQuestion, Long sessionId) {
        ThreeTwoOne entry = new ThreeTwoOne();
        entry.setThreeThings(threeThings);
        entry.setTwoInteresting(twoInteresting);
        entry.setOneQuestion(oneQuestion);
        entry.setCreatedAt(LocalDateTime.now());
        // TODO: gán session, user nếu cần
        threeTwoOneRepository.save(entry);
    }

    public void deleteById(Long id) {
        threeTwoOneRepository.deleteById(id);
    }
}
