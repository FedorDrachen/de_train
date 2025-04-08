package ru.fDrachen.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.fDrachen.console.controller.ProjectController;


@ComponentScan(basePackages = "ru.fDrachen")
@SpringBootApplication
public class App  implements CommandLineRunner {
    @Autowired
    private ProjectController controller;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        controller.interactWithUser();
    }
}

