package com.example.focusflow.controller;

import com.example.focusflow.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stats")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/pomodoro-total/{userId}")
    public Long getTotalPomodoroMinutes(@PathVariable Long userId) {
        return statsService.getTotalPomodoroMinutesByUser(userId);
    }
}
