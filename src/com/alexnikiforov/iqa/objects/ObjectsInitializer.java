package com.alexnikiforov.iqa.objects;

import com.alexnikiforov.iqa.cli.CommandLineInterface;
import com.alexnikiforov.iqa.controller.InterviewQuestionController;
import com.alexnikiforov.iqa.dao.InterviewQuestionStorage;
import com.alexnikiforov.iqa.dao.inmemory.InMemoryInterviewQuestionStorage;
import com.alexnikiforov.iqa.initdata.InitDataLoader;
import com.alexnikiforov.iqa.service.InterviewQuestionService;
import com.alexnikiforov.iqa.service.mappers.InterviewQuestionMapper;

public class ObjectsInitializer {

    private final InterviewQuestionStorage interviewQuestionStorage;
    private final InterviewQuestionMapper interviewQuestionMapper;
    private final InterviewQuestionService interviewQuestionService;
    private final InterviewQuestionController interviewQuestionController;
    private final InitDataLoader initDataLoader;
    private final CommandLineInterface commandLineInterface;

    public ObjectsInitializer() {
        this.interviewQuestionStorage = new InMemoryInterviewQuestionStorage();
        this.interviewQuestionMapper = new InterviewQuestionMapper();
        this.interviewQuestionService = new InterviewQuestionService(
                interviewQuestionMapper, interviewQuestionStorage);
        this.interviewQuestionController = new InterviewQuestionController(interviewQuestionService);
        this.commandLineInterface = new CommandLineInterface(interviewQuestionController);
        this.initDataLoader = new InitDataLoader(interviewQuestionController);
    }

    public void run() {
        commandLineInterface.run();
    }

}
