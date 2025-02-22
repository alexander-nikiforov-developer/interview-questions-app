package com.alexnikiforov.iqa.controller;

import com.alexnikiforov.iqa.dto.InterviewQuestionDto;
import com.alexnikiforov.iqa.service.InterviewQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/questions")
public class InterviewQuestionController {

    private final InterviewQuestionService service;

    @GetMapping
    public ResponseEntity<List<InterviewQuestionDto>> getAllInterviewQuestions() {
        List<InterviewQuestionDto> allQuestions = service.getAll();
        return allQuestions.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(allQuestions);
    }
}
