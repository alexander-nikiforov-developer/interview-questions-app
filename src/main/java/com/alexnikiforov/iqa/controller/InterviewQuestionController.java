package com.alexnikiforov.iqa.controller;

import com.alexnikiforov.iqa.dto.InterviewQuestionDto;
import com.alexnikiforov.iqa.model.InterviewQuestion;
import com.alexnikiforov.iqa.service.InterviewQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/questions")
public class InterviewQuestionController {

    private final InterviewQuestionService service;

    public InterviewQuestion createInterviewQuestion(InterviewQuestionDto questionDto) {
        return service.create(questionDto);
    }

    @GetMapping
    public List<InterviewQuestionDto> getAllInterviewQuestions() {
        return service.getAll();
    }
}
