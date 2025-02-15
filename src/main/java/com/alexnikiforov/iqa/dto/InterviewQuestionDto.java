package com.alexnikiforov.iqa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterviewQuestionDto {
        Long id;
        String question;
        String answer;


    public InterviewQuestionDto(String question, String answer) {
        this(null, question, answer);
    }

}
