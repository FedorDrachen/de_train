package ru.fDrachen.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class OpenQuestionCardTest {
    private static final Long ID = 123L;
    private static final String CARD_QUESTION = "Что такое класс в Java?";

    private static final String CARD_EXPECTED_ANSWER = "Модель для создания объектов определённого типа, описывающая их структуру";

    private OpenQuestionCard openQuestionCard;

    @BeforeEach
    void setUp() {
        openQuestionCard = new OpenQuestionCard(ID,CARD_QUESTION, CARD_EXPECTED_ANSWER);
    }

    @Test
    @DisplayName("Создание OpenquestionCard с корректными question и expectedQuestion проходит успешно")
    void having_correctQuestion_when_newOpenQuestionCard_then_created(){
        assertEquals(CARD_QUESTION, openQuestionCard.getQuestion());
    }

    @Test
    @DisplayName("Создание OpenQuestionCard с question равным null выбрасывает исключение")
    void having_nullQuestion_when_newOpenQuestionCard_then_exceptionThrown() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new OpenQuestionCard(ID,null, CARD_EXPECTED_ANSWER));
    }

    @Test
    @DisplayName("Создание OpenQuestionCard с expected_answer равным null выбрасывает исключение")
    void having_nullExpectedAnswer_when_newOpenQuestionCard_then_exceptionThrown() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new OpenQuestionCard(ID, CARD_QUESTION, null));
    }

    @Test
    @DisplayName("Создание OpenQuestionCard с пустым полем question выбрасывает исключение")
    void having_emptyQuestion_when_newOpenQuestionCard_then_exceptionThrown() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new OpenQuestionCard(ID, "", CARD_EXPECTED_ANSWER));
    }

    @Test
    @DisplayName("Создание OpenQuestionCard с пустым полем expected_answer выбрасывает исключение")
    void having_emptyExpectedAnswer_when_newOpenQuestionCard_then_exceptionThrown() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new OpenQuestionCard(ID, CARD_QUESTION, ""));
    }

    @Test
    @DisplayName("Создание OpenQuestionCard с id равным null выбрасывает исключение")
    void having_nullId_when_newOpenQuestionCard_then_exceptionThrown() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new OpenQuestionCard(null,CARD_QUESTION, CARD_EXPECTED_ANSWER));
    }

    @Test
    @DisplayName("Проверка ответа методом checkAnswer() проходит успешно")
    void having_correctResult_while_using_checkAnswer_method() {
        String answer = "Неверный ответ";
        assertTrue(openQuestionCard.checkAnswer(CARD_EXPECTED_ANSWER));
        assertFalse(openQuestionCard.checkAnswer(answer));
    }
}