package com.example.demo.services;

import com.example.demo.dto.LikeRequestDTO;
import com.example.demo.dto.LikeResponseDTO;
import com.example.demo.models.Like;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ILikeService {
    Mono<LikeResponseDTO> createLike(LikeRequestDTO likeRequestDTO);

    Mono<LikeResponseDTO> countLikesByTargetIdAndTargetType(String targetId, String targetType);

    Mono<LikeResponseDTO> countDislikesByTargetIdAndTargetType(String targetId, String targetType);

    Mono<LikeResponseDTO> toggleLike(String targetId, String targetType);

}
