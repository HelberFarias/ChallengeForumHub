package com.alura.forumhub.domain.topics;

import java.time.LocalDateTime;

public record TopicResponse(
        Long id,
        String title,
        String message,
        LocalDateTime createdAt,
        boolean status,
        Long authorId,
        Long courseId)
{
    public TopicResponse (Topic topic) {
        this(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreatedAt(),
                topic.isStatus(),
                topic.getAuthorId(),
                topic.getCourseId());
    }
}
