package com.alexnikiforov.iqa.dao;

import com.alexnikiforov.iqa.model.InterviewQuestion;

import java.util.List;

public interface InterviewQuestionStorage {

    InterviewQuestion createInterviewQuestion(InterviewQuestion question);

    List<InterviewQuestion> getAll();
}
