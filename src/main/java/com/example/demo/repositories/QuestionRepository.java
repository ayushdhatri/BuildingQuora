package com.example.demo.repositories;

import com.example.demo.models.Question;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface QuestionRepository extends ReactiveMongoRepository<Question, String> {

    @Query("{ '$or':[{ 'title':{$regex: ?0, $options: 'i'} }, { 'content' : {$regex: ?0, $options: 'i'} } ]}")
    Flux<Question> findByTitleOrContentContainingIgnoreCase(String searchTerm, Pageable pageabl);

    Flux<Question> findByCreatedAtGreaterThanOrderByCreatedAtAsc(LocalDateTime cursor, Pageable pageable);

    Flux<Question> findTop10ByOrderByCreatedAtAsc();

}
