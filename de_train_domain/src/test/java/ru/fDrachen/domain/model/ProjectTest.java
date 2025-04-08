package ru.fDrachen.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {
    @ParameterizedTest
    @MethodSource("provideIncorrectInput")
    @DisplayName("Создание Project с некорректными данными завершается ошибкой")
    void having_incorrectInput_when_newProject_then_exception(Long id, String question, String expectedAnswer) {
        Assertions.assertThrowsExactly(IllegalArgumentException.class,
                () -> new Project(id, question, expectedAnswer));
    }

    @Test
    @DisplayName("Создание Project с корректными id и question или expectedAnswer проходит успешно")
    void having_correctId_when_newProject_then_created() {
        Long id = 12L;
        String question = "Вопрос";
        String expectedAnswer = "Ответ";
        Project project = new Project(id, question, expectedAnswer);
        Assertions.assertEquals(id, project.getId());
    }

    @Test
    @DisplayName("Создание Project с корректными question  проходит успешно")
    void having_correctQuestion_when_newProject_then_created() {
        Long id = 12L;
        String question = "Вопрос";
        String expectedAnswer = "Вопрос";
        Project project = new Project(id, question, expectedAnswer);
        Assertions.assertEquals(question, project.getQuestion());
    }

    @Test
    @DisplayName("Создание Project с корректными expectedAnswer проходит успешно")
    void having_correctExpectedAnswer_when_newProject_then_created() {
        Long id = 12L;
        String question = "Вопрос";
        String expectedAnswer = "Вопрос";
        Project project = new Project(id, question, expectedAnswer);
        Assertions.assertEquals(expectedAnswer, project.getExpectedAnswer());
    }

    @Test
    @DisplayName("После создание Project, список вопросов не null")
    void when_newProject_then_questionsNotNull() {
        Long id = 12L;
        String question = "Вопрос";
        String expectedAnswer = "Вопрос";
        Project project = new Project(id, question, expectedAnswer);
        Assertions.assertNotNull(project.getQuestions());
    }

    @Test
    @DisplayName("Добавление задачи успешно")
    void when_addQuestion_then_questionAdded() {
        Long id = 12L;
        String question = "Вопрос";
        String expectedAnswer = "Ответ";
        Project project = new Project(id, question, expectedAnswer);
        project.addQuestion(new OpenQuestionCard(12L, "Вопрос", "Ответ"));
        Assertions.assertEquals(1, project.getQuestions().size());
        Assertions.assertEquals(12L, project.getQuestions().get(0).getId());
        Assertions.assertEquals("Вопрос", project.getQuestions().get(0).getQuestion());
        Assertions.assertEquals("Ответ", project.getQuestions().get(0).getExpectedAnswer());
    }

    @Test
    @DisplayName("Добавление задачи успешно")
    void when_removeQuestion_then_questionRemoved() {
        Long id = 12L;
        String question = "Вопрос";
        String expectedAnswer = "Ответ";
        Project project = new Project(id, question, expectedAnswer);
        OpenQuestionCard openQuestionCard = new OpenQuestionCard(12L, "Вопрос", "Ответ");
        project.addQuestion(openQuestionCard);
        project.removeQuestion(openQuestionCard);
        Assertions.assertEquals(0, project.getQuestions().size());
    }

    private static Stream<Arguments> provideIncorrectInput() {
        return Stream.of(
                Arguments.of(null, null, null),
                Arguments.of(123L, null, null),
                Arguments.of(null, "", null),
                Arguments.of(null, null, ""),
                Arguments.of(123L, "", ""),
                Arguments.of(123L, "", ""),
                Arguments.of(123L, "Что то", ""),
                Arguments.of(123L, "", "Что то"),
                Arguments.of(123L, null, null),
                Arguments.of(null, "Что то", null),
                Arguments.of(null, null, "Что то")
        );
    }
}