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

    private final InterviewQuestionService interviewQuestionService;

    @GetMapping
    public ResponseEntity<List<InterviewQuestionDto>> getAllInterviewQuestions() {
        List<InterviewQuestionDto> allQuestions = interviewQuestionService.getAll();
        return allQuestions.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(allQuestions);
    }

    @PostMapping
    public ResponseEntity<Void> addInterviewQuestion(@RequestBody @Valid InterviewQuestionDto interviewQuestionDto) {
        Long id = interviewQuestionService.create(interviewQuestionDto);
        URI location = URI.create("/api/v1/questions/" + id);
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInterviewQuestion(@PathVariable long id) {
        boolean deleted = interviewQuestionService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterviewQuestionDto> updateInterviewQuestion(
            @PathVariable long id,
            @RequestBody @Valid InterviewQuestionDto interviewQuestionDto) {
        boolean updated = interviewQuestionService.updateAndReturn(id, interviewQuestionDto);
        return updated ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
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
