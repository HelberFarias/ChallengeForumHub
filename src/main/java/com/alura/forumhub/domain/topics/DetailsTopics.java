package com.alura.forumhub.domain.topics;

import java.time.LocalDate;

public record DetailsTopics(
        Long id,
        String tittle,
        String message,
        LocalDate createdAt,
        Long authorId,
        Long courseIid)
{
    public DetailsTopics(Topic newTopic) {
        this(
                newTopic.getId(),
                newTopic.getTitle(),
                newTopic.getMessage(),
                newTopic.getCreatedAt(),
                newTopic.getAuthorId(),
                newTopic.getCourseIid()
        );
    }
}
