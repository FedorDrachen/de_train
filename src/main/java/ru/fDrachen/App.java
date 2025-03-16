package ru.fDrachen;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.fDrachen.config.SpringConfig;
import ru.fDrachen.controller.ConsoleController;
import ru.fDrachen.storage.QuestionlnMemoryStorage;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ConsoleController controller = context.getBean(ConsoleController.class);
        controller.interactWithUser();
    }
}
