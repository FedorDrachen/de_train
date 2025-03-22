package ru.fDrachen.gui.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import ru.fDrachen.spring.jdbc.config.DbConfig;
@Configuration
@PropertySource("jdbc.properties")
@Import(DbConfig.class)
@ComponentScan(basePackages = "ru.fDrachen")
public class SpringConfig {

}