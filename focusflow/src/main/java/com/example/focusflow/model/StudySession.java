package com.example.focusflow.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "study_sessions")
public class StudySession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDateTime createdAt;

    private String methods;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<Blurting> blurtings;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<ThreeTwoOne> threeTwoOnes;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<FeynmanNote> feynmanNotes;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<Flashcard> flashcards;
}
