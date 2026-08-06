package com.example.demo.repositories;

import com.example.demo.models.Question;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface QuestionRepository extends ReactiveMongoRepository<Question, String> {
    Flux<Question> findByAuthorId(String authorId);

    Mono<Long> countByAuthorId(String authorId);

}
