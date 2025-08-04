package com.example.focusflow.controller;

import com.example.focusflow.model.Schedule;
import com.example.focusflow.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/user/{userId}")
    public List<Schedule> getByUser(@PathVariable Long userId) {
        return scheduleService.getByUser(userId);
    }

    @PostMapping
    public Schedule save(@RequestBody Schedule schedule) {
        return scheduleService.save(schedule);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        scheduleService.delete(id);
    }
}
