package com.alexnikiforov.iqa.initdata;

import com.alexnikiforov.iqa.controller.InterviewQuestionController;
import com.alexnikiforov.iqa.dto.InterviewQuestionDto;


public class InitDataLoader {
    private final InterviewQuestionController interviewQuestionController;

    public InitDataLoader(InterviewQuestionController interviewQuestionController) {
        this.interviewQuestionController = interviewQuestionController;
        loadTestData();
    }

    private void loadTestData() {
        interviewQuestionController.createInterviewQuestion(new InterviewQuestionDto("Question text 1",
                "Answer text 1"));
        interviewQuestionController.createInterviewQuestion(new InterviewQuestionDto("Question text 2",
                "Answer text 2"));
        System.out.println("INFO: Test questions are loaded" + System.lineSeparator());
    }
}
