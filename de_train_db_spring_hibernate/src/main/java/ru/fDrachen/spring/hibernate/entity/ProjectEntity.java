package ru.fDrachen.spring.hibernate.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "project")
public class ProjectEntity {
    @Id
    @Column
    private Long id;

    @Column
    private String question;

    @Column
    private String expectedAnswer;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<OpenQuestionCardEntity> questions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getExpectedAnswer() {
        return expectedAnswer;
    }

    public void setExpectedAnswer(String expectedAnswer) {
        this.expectedAnswer = expectedAnswer;
    }

    public List<OpenQuestionCardEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<OpenQuestionCardEntity> questions) {
        this.questions = questions;
    }
}