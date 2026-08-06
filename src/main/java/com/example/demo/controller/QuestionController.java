package com.example.demo.controller;


import com.example.demo.dto.QuestionRequestDTO;
import com.example.demo.dto.QuestionResponseDTO;
import com.example.demo.services.IQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/questions")
@AllArgsConstructor
@Controller
public class QuestionController {
    private final IQuestionService questionService;

    @PostMapping
    public Mono<QuestionResponseDTO> createQuestion(@RequestBody QuestionRequestDTO questionRequestDTO){
        return questionService.createQuestion(questionRequestDTO)
                .doOnSuccess(response -> System.out.println("Question created Successfully " + response))
                .doOnError(error -> System.out.println("Error creating question: " + error));
    }
}
