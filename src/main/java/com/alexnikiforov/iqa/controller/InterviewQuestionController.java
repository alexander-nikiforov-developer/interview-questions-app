package com.alexnikiforov.iqa.controller;

import com.alexnikiforov.iqa.dto.InterviewQuestionDto;
import com.alexnikiforov.iqa.model.InterviewQuestion;
import com.alexnikiforov.iqa.service.InterviewQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InterviewQuestionController {

    private final InterviewQuestionService service;

    public InterviewQuestion createInterviewQuestion(InterviewQuestionDto questionDto) {
        return service.create(questionDto);
    }

    public List<InterviewQuestionDto> getAllInterviewQuestions() {
        return service.getAll();
    }
}
