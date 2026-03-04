package com.alura.forumhub.domain.topics;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private LocalDate createdAt;
    private boolean status = true;
    private Long authorId;
    private Long courseIid;

    public Topic( CreateTopicRequest data) {
        this.title = data.title();
        this.message = data.message();
        this.authorId = data.authorId();
        this.courseIid = data.courseId();
    }
}
