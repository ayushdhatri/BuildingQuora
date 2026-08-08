package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AnswerRequestDTO {
    @NotBlank
    @Size(min = 10,max=1000, message = "Content must be betwween 10 and 100 character")
    private String content;

    @NotNull
    @NotBlank(message = "Question is required")
    private String questionId;
}
