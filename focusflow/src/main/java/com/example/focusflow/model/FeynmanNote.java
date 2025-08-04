package com.example.focusflow.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "feynman_notes")
public class FeynmanNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topic;

    @Lob
    private String explanation;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private StudySession session;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
