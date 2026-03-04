package com.alura.forumhub.domain.topics;

public record CreateTopicRequest(
        String id,
        String title,
        String message,
        String created_at,
        String status,
        String author_id,
        String course_id
) {
}
