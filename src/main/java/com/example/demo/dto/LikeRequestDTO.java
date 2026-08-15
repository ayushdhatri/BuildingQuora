package com.example.demo.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LikeRequestDTO {
    @NotNull
    @NotBlank(message = "Target Id is required")
    private String targetId;

    @NotBlank
    private String targetType;

    @NotNull
    private Boolean isLike;
}


