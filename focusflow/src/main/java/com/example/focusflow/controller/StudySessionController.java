package com.example.focusflow.controller;

import com.example.focusflow.model.StudySession;
import com.example.focusflow.service.StudySessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
public class StudySessionController {

    @Autowired
    private StudySessionService studySessionService;

    @GetMapping("/user/{userId}")
    public List<StudySession> getSessions(@PathVariable Long userId) {
        return studySessionService.getByUser(userId);
    }

    @PostMapping
    public StudySession save(@RequestBody StudySession session) {
        return studySessionService.save(session);
    }
}
