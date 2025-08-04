package com.example.focusflow.service;

import com.example.focusflow.model.PomodoroSession;
import com.example.focusflow.repository.PomodoroSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PomodoroService {

    @Autowired
    private PomodoroSessionRepository pomodoroSessionRepository;

    public List<PomodoroSession> getByUser(Long userId) {
        return pomodoroSessionRepository.findByUserId(userId);
    }

    public PomodoroSession save(PomodoroSession session) {
        return pomodoroSessionRepository.save(session);
    }
}
