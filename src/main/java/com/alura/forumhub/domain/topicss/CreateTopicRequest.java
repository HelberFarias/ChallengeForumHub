package com.alura.forumhub.domain.topicss;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CreateTopicRequest(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotNull
        Long courseId
) {}
