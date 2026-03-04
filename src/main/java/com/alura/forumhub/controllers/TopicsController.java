package com.alura.forumhub.controllers;

import com.alura.forumhub.domain.topics.CreateTopicRequest;
import com.alura.forumhub.domain.topics.DetailsTopics;
import com.alura.forumhub.domain.topics.Topic;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topics")
public class TopicsController {

    @PostMapping
    @Transactional
    public ResponseEntity createTopic(@RequestBody @Valid CreateTopicRequest data, UriComponentsBuilder uriBuilder){
        var newTopic = new Topic(data);
        var uri = uriBuilder.path("/topics/{}").buildAndExpand(newTopic.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailsTopics(newTopic));
    }

}
