package com.alexnikiforov.iqa.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InterviewQuestionDto {

    @NotBlank(message = "Question cannot be empty")
    String question;
    @NotBlank(message = "Answer cannot be empty")
    String answer;

}
