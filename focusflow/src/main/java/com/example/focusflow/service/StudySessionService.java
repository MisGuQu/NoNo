package com.example.focusflow.service;

import com.example.focusflow.model.StudySession;
import com.example.focusflow.repository.StudySessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudySessionService {

    @Autowired
    private StudySessionRepository studySessionRepository;

    public List<StudySession> getByUser(Long userId) {
        return studySessionRepository.findByUserId(userId);
    }

    public StudySession save(StudySession session) {
        return studySessionRepository.save(session);
    }
}
