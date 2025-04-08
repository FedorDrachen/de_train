package ru.fDrachen.spring.hibernate.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import ru.fDrachen.domain.model.Project;
import ru.fDrachen.domain.repo.ProjectRepository;
import ru.fDrachen.spring.hibernate.entity.ProjectEntity;
import ru.fDrachen.spring.hibernate.mapper.QuestionMapper;
import ru.fDrachen.spring.hibernate.repo.ProjectCurdRepository;

import java.util.List;
import java.util.Optional;

@Component
public class ProjectDao implements ProjectRepository {
    private static final Logger logger = LogManager.getLogger(ProjectDao.class);
    private final QuestionMapper mapper;
    private final ProjectCurdRepository repository;

    public ProjectDao(QuestionMapper mapper, ProjectCurdRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<Project> findAll() {
        return mapper.mapProjectToModel(repository.findAll());
    }

    @Override
    public Optional<Project> findById(Long id) {
        return repository.findById(id).map(mapper::mapToModel);
    }

    @Override
    public void add(Project project) {
        repository.save(processQuestionsBeforeSave(mapper.mapToEntity(project)));
    }

    @Override
    public void update(Project project) {
        repository.save(processQuestionsBeforeSave(mapper.mapToEntity(project)));
    }

    @Override
    public void remove(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    private ProjectEntity processQuestionsBeforeSave(ProjectEntity project) {
        project.getQuestions().forEach( question -> question.setProject(project));
        return project;
    }
}
