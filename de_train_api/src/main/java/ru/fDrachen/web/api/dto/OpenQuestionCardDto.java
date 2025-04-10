package ru.fDrachen.web.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Вопрос в системе QM")
public class OpenQuestionCardDto {
    @Schema(description = "Id вопроса", example = "1")
    private Long id;

    @Schema(description = "Текст вопроса", example = "Что такое класс в Java?")
    private String question;

    @Schema(description = "Предполагаемы ответ", example = "Модель для создания объектов определённого типа, описывающая их структуру")
    private String expectedAnswer;

    public OpenQuestionCardDto() {
    }

    public OpenQuestionCardDto(Long id, String question, String expectedAnswer) {
        this.id = id;
        this.question = question;
        this.expectedAnswer = expectedAnswer;
    }

    public Long getId() { return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {this.question = question;}

    public String getExpectedAnswer() {
        return expectedAnswer;
    }

    public void setExpectedAnswer(String expectedAnswer) {this.expectedAnswer = expectedAnswer;}


    public String displayedName() {
        return String.format("%s: %s: %s", id, question, expectedAnswer);
    }
}
