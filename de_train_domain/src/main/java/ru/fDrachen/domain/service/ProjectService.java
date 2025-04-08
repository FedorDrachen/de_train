package ru.fDrachen.domain.service;

import org.springframework.stereotype.Service;
import ru.fDrachen.domain.model.Project;
import ru.fDrachen.domain.repo.ProjectRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public List<Project> getAll() {
        return repository.findAll();
    }

    public Optional<Project> getById(Long id) {
        if (Objects.isNull(id)) {
            return Optional.empty();
        }
        return repository.findById(id);
    }

    public boolean contains(Project project) {
        if (isProjectInvalid(project)) {
            return false;
        }
        return repository.findById(project.getId()).isPresent();
    }

    public void save(Project project) {
        if (isProjectInvalid(project)) {
            return;
        }
        if (contains(project)) {
            repository.update(project);
        } else {
            repository.add(project);
        }
    }

    public void delete(Project project) {
        if (isProjectInvalid(project)) {
            return;
        }
        repository.remove(project.getId());
    }

    private boolean isProjectInvalid(Project project) {
        return Objects.isNull(project) || Objects.isNull(project.getId());
    }
}
