package com.example.focusflow.repository;

import com.example.focusflow.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByUserId(Long userId);
    List<Schedule> findByTaskId(Long taskId);
    List<Schedule> findBySessionId(Long sessionId);
}
