package com.example.focusflow.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blurting")
public class Blurting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String content;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private StudySession session;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
