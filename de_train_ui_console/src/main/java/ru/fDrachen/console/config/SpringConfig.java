package ru.fDrachen.console.config;

import org.springframework.context.annotation.*;
import ru.fDrachen.spring.jdbc.config.DbConfig;

@Configuration
@PropertySource("jdbc.properties")
@Import(DbConfig.class)
@ComponentScan(basePackages = "ru.fDrachen")
public class SpringConfig {

}