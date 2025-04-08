package ru.fDrachen.domain.model;

import ru.fDrachen.domain.utility.ValidationUtility;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private final Long id;
    private final String question;
    private final String expectedAnswer;
    private final List<OpenQuestionCard> questions;

    public Project(Long id, String question, String expectedAnswer) {

        ValidationUtility.validateNotEmpty(String.valueOf(id), "id не может быть пустым");
        ValidationUtility.validateNotEmpty(question, "question не может быть пустым");
        ValidationUtility.validateNotEmpty(expectedAnswer, "expectedAnswer не может быть пустым");

        this.id = id;
        this.question = question;
        this.expectedAnswer = expectedAnswer;
        this.questions = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public List<OpenQuestionCard> getQuestions() {
        return questions;
    }

    public String getExpectedAnswer() {
        return expectedAnswer;
    }
    public void addQuestion(OpenQuestionCard openQuestionCard) {
        questions.add(openQuestionCard);
    }

    public void removeQuestion(OpenQuestionCard openQuestionCard) {
        questions.remove(openQuestionCard);
    }

    @Override
    public String toString() {
        return id + ": " + question + ": " + expectedAnswer;
    }
}
