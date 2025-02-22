package com.alexnikiforov.iqa.initdata;

import com.alexnikiforov.iqa.dto.InterviewQuestionDto;
import com.alexnikiforov.iqa.service.InterviewQuestionService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InitDataLoader {

    private final InterviewQuestionService interviewQuestionService;

    @PostConstruct
    private void init() {
        loadTestData();
    }

    private void loadTestData() {
        interviewQuestionService.create(new InterviewQuestionDto("Question text 1",
                "Answer text 1"));
        interviewQuestionService.create(new InterviewQuestionDto("Question text 2",
                "Answer text 2"));
        System.out.println("INFO: Test questions are loaded" + System.lineSeparator());
    }
}
