package com.example.focusflow.repository;

import com.example.focusflow.model.PomodoroSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PomodoroSessionRepository extends JpaRepository<PomodoroSession, Long> {
    List<PomodoroSession> findByUserId(Long userId);
    List<PomodoroSession> findByTaskId(Long taskId);
}
