package ru.fDrachen.spring.hibernate.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = "ru.fDrachen.spring.hibernate.entity")
@EnableJpaRepositories(basePackages = "ru.fDrachen.spring.hibernate.repo")
public class DbConfig {
    private static final Logger logger = LogManager.getLogger(DbConfig.class);
}