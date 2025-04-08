package ru.fDrachen.domain.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.fDrachen.domain.model.OpenQuestionCard;
import ru.fDrachen.domain.repo.QuestionRepository;
import java.util.List;
import java.util.Optional;

public class QuestionServiceTest {
    private QuestionService questionService;
    private QuestionRepository questionRepository;
    @BeforeEach
    void setUp() {
        questionRepository = Mockito.mock(QuestionRepository.class);
        questionService = new QuestionService(questionRepository);
    }

    @Test
    @DisplayName("Получение существующего вопроса по id")
    void having_questionInRepo_when_getById_then_returnQuestion() {
        Mockito.when(questionRepository.findById(1L))
                .thenReturn(Optional.of(new OpenQuestionCard(1L, "Вопрос", "Ответ")));
        Optional<OpenQuestionCard> openQuestionCard = questionService.getById(1L);
        Assertions.assertTrue(openQuestionCard.isPresent());
    }

    @Test
    @DisplayName("При сохранении нововй задачи, вызывается метод add у репозитория")
    void having_noQuestionInRepo_when_save_then_repoAddIsInvoken() {
        OpenQuestionCard openQuestionCard = new OpenQuestionCard(1L, "Вопрос", "Ответ");
        questionService.save(openQuestionCard);
        Mockito.verify(questionRepository).add(Mockito.any());
    }

    @Test
    @DisplayName("При попытке получить вопросы, когда репозиторий пуст, получаем пустой список")
    void having_noQuestionInRepo_when_getAll_then_returnEmpty() {
        List<OpenQuestionCard> question = questionService.getAll();
        Assertions.assertTrue(question.isEmpty());
    }

    @Test
    @DisplayName("При попытке получить несуществующий вопрос по id, получаем Optional.empty")
    void having_noQuestionInRepo_when_getById_then_returnEmpty() {
        Optional<OpenQuestionCard> question = questionService.getById(1L);
        Assertions.assertFalse(question.isPresent());
    }

    @Test
    @DisplayName("При попытке получить вопрос по коду null, получаем Optional.empty")
    void having_nullId_when_getById_then_returnEmpty() {
        Optional<OpenQuestionCard> question = questionService.getById(null);
        Assertions.assertFalse(question.isPresent());
    }

    @Test
    @DisplayName("Проверка существования вопроса успешна, если вопрос есть в репозитории")
    void having_questionInRepo_when_contains_then_returnTrue() {
        OpenQuestionCard question = new OpenQuestionCard(1L, "Вопрос", "Ответ");
        Mockito.when(questionRepository.findById(1L))
                .thenReturn(Optional.of(question));
        Assertions.assertTrue(questionService.contains(question));
    }

    @Test
    @DisplayName("Проверка существования вопроса возвращает false, если вопроса нет в репозитории")
    void having_noQuestionInRepo_when_contains_then_returnFalse() {
        OpenQuestionCard question = new OpenQuestionCard(1L, "Вопрос", "Ответ");
        Assertions.assertFalse(questionService.contains(question));
    }

    @Test
    @DisplayName("Проверка существования вопроса возвращает false, если вопроса нет в репозитории")
    void having_questionInRepo_when_save_then_repoUpdateIsInvoken() {
        OpenQuestionCard question = new OpenQuestionCard(1L, "Задача", "Вопрос");
        Mockito.when(questionRepository.findById(1L))
                .thenReturn(Optional.of(question));
        questionService.save(question);
        Mockito.verify(questionRepository).update(Mockito.any());
    }
}