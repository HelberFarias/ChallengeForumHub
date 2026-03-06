package com.alura.forumhub.domain.topicss;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicsRepository extends JpaRepository<Topic, Long> {
    Page<Topic> findAllByStatusTrue(Pageable pageable);


}
