package com.alexnikiforov.iqa.service;

import com.alexnikiforov.iqa.dao.InterviewQuestionStorage;
import com.alexnikiforov.iqa.dto.InterviewQuestionDto;
import com.alexnikiforov.iqa.model.InterviewQuestion;
import com.alexnikiforov.iqa.service.mappers.InterviewQuestionMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InterviewQuestionService {

    private final InterviewQuestionMapper interviewQuestionMapper;
    private final InterviewQuestionStorage storage;

    public Long create(InterviewQuestionDto questionDto) {
        InterviewQuestion interviewQuestion = interviewQuestionMapper.toInterviewQuestion(questionDto);
        return storage.createInterviewQuestion(interviewQuestion).getId();
    }

    public List<InterviewQuestionDto> getAll() {
        List<InterviewQuestion> questions = storage.getAll();
        return questions.stream()
                .map(interviewQuestionMapper::toInterviewQuestionDto)
                .toList();
    }

    public boolean delete(long id) {
        return storage.delete(id);
    }
}
