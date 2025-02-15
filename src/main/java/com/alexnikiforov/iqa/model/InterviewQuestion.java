package com.alexnikiforov.iqa.model;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
public class InterviewQuestion {
    private Long id;
    private String question;
    private String answer;

    public InterviewQuestion(String question, String answer) {
        this(null, question, answer);
    }

    //todo change once we add hibernate support
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterviewQuestion that = (InterviewQuestion) o;
        return Objects.equals(id, that.id) && Objects.equals(question, that.question) && Objects.equals(answer, that.answer);
    }

    //todo change once we add hibernate support
    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer);
    }
}
