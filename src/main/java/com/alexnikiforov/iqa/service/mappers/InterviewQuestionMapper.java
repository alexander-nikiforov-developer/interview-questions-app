package com.alexnikiforov.iqa.service.mappers;

import com.alexnikiforov.iqa.dto.InterviewQuestionDto;
import com.alexnikiforov.iqa.model.InterviewQuestion;
import org.springframework.stereotype.Service;

@Service
public class InterviewQuestionMapper {

    public InterviewQuestion toInterviewQuestion(InterviewQuestionDto interviewQuestionDto) {
        return new InterviewQuestion(interviewQuestionDto.getQuestion(), interviewQuestionDto.getAnswer());
    }

    public InterviewQuestionDto toInterviewQuestionDto(InterviewQuestion interviewQuestion) {
        return new InterviewQuestionDto(
                interviewQuestion.getId(),
                interviewQuestion.getQuestion(),
                interviewQuestion.getAnswer()
        );
    }
}
