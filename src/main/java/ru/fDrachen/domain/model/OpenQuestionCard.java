package ru.fDrachen.domain.model;

public class OpenQuestionCard {

    private final Long id;
    private final String question;
    private final String expectedAnswer;

    public OpenQuestionCard(Long id, String question, String expectedAnswer) {

        if (question == null || question.trim().isEmpty()){
            throw new IllegalArgumentException("Поле question не должно быть пустым или null");
        }

        if (expectedAnswer == null || expectedAnswer.trim().isEmpty()){
            throw new IllegalArgumentException("Поле expectedAnswer не должно быть пустым или null");
        }

        this.id = id;
        this.question = question;
        this.expectedAnswer = expectedAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public boolean checkAnswer(String userAnswer) {
        return expectedAnswer.equals(userAnswer);
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "OpenQuestionCard{" +
                "question='" + question + '\'' +
                ", expectedAnswer='" + expectedAnswer + '\'' +
                '}';
    }
}
