package com.alura.forumhub.controllers;

import com.alura.forumhub.domain.topics.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topics")
public class TopicsController {

    @Autowired
    private TopicsRepository topicsRepository;

    @PostMapping
    @Transactional
    public ResponseEntity createTopic(@RequestBody @Valid CreateTopicRequest data, UriComponentsBuilder uriBuilder){
        var newTopic = new Topic(data);
        topicsRepository.save(newTopic);

        var uri = uriBuilder.path("/topics/{id}").buildAndExpand(newTopic.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailsTopics(newTopic));
    }

    @GetMapping
    public ResponseEntity <Page<TopicResponse>>showTopics(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable) {

        var page = topicsRepository.findAllByStatusTrue(pageable).map(TopicResponse::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping ("/{id}")
    public ResponseEntity topicDetails (@PathVariable Long id) {
        var topic = topicsRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetailsTopics(topic));
    }

    @PutMapping ("/{id}")
    @Transactional
    public ResponseEntity updateTopic (@PathVariable Long id, @RequestBody @Valid UpdateTopicData data) {

        var update = topicsRepository.getReferenceById(data.id());
        update.updateTopic(data);

        return ResponseEntity.ok(new UpdateTopicData(update));

    }

}
