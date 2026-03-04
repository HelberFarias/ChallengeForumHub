package com.alura.forumhub.controllers;

import com.alura.forumhub.domain.topics.CreateTopicRequest;
import com.alura.forumhub.domain.topics.Topic;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topics")
public class TopicsController {

    @PostMapping
    @Transactional
    public ResponseEntity createTopic(@RequestBody @Valid CreateTopicRequest data ){
        var newTopic = new Topic();

        return ResponseEntity.created(uri).body(new DetailsTopics(topic));
    }

}
