package ru.fDrachen.web.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Проект в системе TM")
public class ProjectDto {
    @Schema(description = "ID проекта", example = "12")
    private Long id;

    @Schema(description = "Вопрос", example = "Важный вопрос")
    private String question;

    @Schema(description = "Название проекта", example = "Важный ответ")
    private String expectedAnswer;

    @Schema(description = "Вопросы проекта")
    private List<OpenQuestionCardDto> questions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String title) {
        this.question = question;
    }

    public List<OpenQuestionCardDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<OpenQuestionCardDto> questions) {
        this.question = question;
    }
}