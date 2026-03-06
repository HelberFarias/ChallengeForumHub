package com.alura.forumhub.domain.topicss;

import java.time.LocalDateTime;

public record DetailsTopics(
        Long id,
        String tittle,
        String message,
        LocalDateTime createdAt,
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
                newTopic.getCourseId()
        );
    }
}
