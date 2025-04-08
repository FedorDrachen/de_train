-- liquibase formatted sql
-- changeset developer:init logicalFilePath:-
--comment: Создание вопроса question
CREATE TABLE question (id int AUTO_INCREMENT PRIMARY KEY, question VARCHAR(100), expectedAnswer VARCHAR(100));
comment on table question is 'Таблица с вопросами';
comment on column question.id is 'ID вопроса';
comment on column question.question is 'Вопрос';
comment on column question.expectedAnswer is 'Ответ';
--rollback DROP TABLE question;