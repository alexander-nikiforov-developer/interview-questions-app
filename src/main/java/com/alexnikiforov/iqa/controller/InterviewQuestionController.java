package com.alexnikiforov.iqa.controller;

import com.alexnikiforov.iqa.dto.InterviewQuestionDto;
import com.alexnikiforov.iqa.service.InterviewQuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping
    public ResponseEntity<Void> addInterviewQuestion(@RequestBody @Valid InterviewQuestionDto interviewQuestionDto) {
        Long id = service.create(interviewQuestionDto);
        URI location = URI.create("/api/v1/questions/" + id);
        return ResponseEntity.created(location).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
