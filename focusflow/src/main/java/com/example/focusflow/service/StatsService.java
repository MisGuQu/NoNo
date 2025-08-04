package com.example.focusflow.service;

import com.example.focusflow.repository.TaskRepository;
import com.example.focusflow.repository.PomodoroSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private PomodoroSessionRepository pomodoroSessionRepository;

    // Ví dụ: Thống kê tổng thời gian Pomodoro
    public Long getTotalPomodoroMinutesByUser(Long userId) {
        return pomodoroSessionRepository.findByUserId(userId)
                .stream()
                .mapToLong(p -> p.getActualFocusMinutes())
                .sum();
    }

    // Các thống kê khác tuỳ thêm
}
