package com.alura.forumhub.domain.topics;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity (name = "Topics")
@Table (name = "topics")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    @Column (name = "created_at")
    private LocalDateTime createdAt;
    private boolean status;
    private Long authorId;
    private Long courseId;

    public Topic( CreateTopicRequest data) {
        this.title = data.title();
        this.message = data.message();
        this.status = true;
        this.courseId = data.courseId();
        this.createdAt = LocalDateTime.now();
    }

}
