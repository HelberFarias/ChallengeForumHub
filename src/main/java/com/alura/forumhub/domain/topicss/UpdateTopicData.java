package com.alura.forumhub.domain.topicss;

import jakarta.validation.constraints.NotNull;

public record UpdateTopicData(
        @NotNull
        Long id,
        String title,
        String message,
        Long courseId
) {
    public UpdateTopicData(Topic topic) {
        this(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCourseId());
    }
}
