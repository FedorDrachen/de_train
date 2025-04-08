package ru.fDrachen.console.controller;

import org.springframework.stereotype.Component;
import ru.fDrachen.domain.model.Project;
import ru.fDrachen.domain.service.ProjectService;

import java.util.Optional;
import java.util.Scanner;

@Component
public class ProjectController {
    private static final String MENU = """
          Введите [1], чтобы показать все вопросы
          Введите [2], чтобы добавить вопрос
          Введите [3], чтобы удалить вопрос
          Введите [4], чтобы найти вопрос
          Введите [5], чтобы выйти
          """;
    private final ProjectService service;
    private final Scanner scanner;

    public ProjectController(ProjectService service) {
        this.service = service;
        scanner = new Scanner(System.in);
    }

    public void interactWithUser() {
        while(true) {
            printMenu();
            String operationCode = scanner.nextLine();
            switch (operationCode) {
                case "1" -> printAllQuestions();
                case "2" -> addQuestion();
                case "3" -> removeQuestion();
                case "4" -> findQuestion();
                case "5" -> { return; }
                default -> System.out.println("Неизвестная команда");
            }
        }
    }

    private void printMenu() {
        System.out.println(MENU);
    }

    private void printAllQuestions() {
        System.out.println(service.getAll());
    }

    private void addQuestion() {
        System.out.println("Введите id вопроса");
        Long id = Long.valueOf(scanner.nextLine());
        System.out.println("Введите вопрос");
        String question = scanner.nextLine();
        System.out.println("Введите ответ");
        String expectedAnswer = scanner.nextLine();
        Project openQuestionCard = new Project(id, question, expectedAnswer);
        service.save(openQuestionCard);
    }

    private void removeQuestion() {
        System.out.println("Введите id вопроса, который хотите удалить");
        String id = scanner.nextLine();
        Optional<Project> openQuestionCard = service.getById(Long.valueOf(id));
        if (openQuestionCard.isPresent()) {
            System.out.println("Введите [Y], если точно хотите удалить вопрос " + openQuestionCard.get());
            String confirmation = scanner.nextLine();
            if ("Y".equals(confirmation)) {
                service.delete(openQuestionCard.get());
            }
        } else {
            System.out.println("Такого вопроса найти не удалось");
        }
    }

    private void findQuestion() {
        System.out.println("Введите id вопроса, который хотите найти");
        Long id = Long.valueOf(scanner.nextLine());
        Optional<Project> openQuestionCard = service.getById(id);
        if (openQuestionCard.isPresent()) {
            System.out.println(openQuestionCard.get());
        } else {
            System.out.println("Такого вопроса найти не удалось");
        }
    }
}
