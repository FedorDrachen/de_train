package ru.fDrachen.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.fDrachen.console.config.SpringConfig;
import ru.fDrachen.console.controller.ConsoleController;



@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    private ConsoleController controller;
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ConsoleController controller = context.getBean(ConsoleController.class);
        SpringApplication.run(App.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        controller.interactWithUser();
    }
}
