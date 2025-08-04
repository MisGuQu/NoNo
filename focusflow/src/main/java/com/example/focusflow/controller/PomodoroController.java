package com.example.focusflow.controller;

import com.example.focusflow.model.PomodoroSession;
import com.example.focusflow.service.PomodoroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pomodoro")
public class PomodoroController {

    @Autowired
    private PomodoroService pomodoroService;

    @GetMapping("/user/{userId}")
    public List<PomodoroSession> getSessions(@PathVariable Long userId) {
        return pomodoroService.getByUser(userId);
    }

    @PostMapping
    public PomodoroSession save(@RequestBody PomodoroSession session) {
        return pomodoroService.save(session);
    }
}
