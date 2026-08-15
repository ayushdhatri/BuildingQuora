package com.example.demo.models;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "likes")
public class Like {
    @Id
    private String id;

    @NotBlank(message = "Target Id is required")
    private String targetId;

    @NotBlank(message = "Target type is required")
    private String targetType;// Question, Answer

    private Boolean isLike;

    @CreatedDate
    private LocalDateTime createdAt;

}
