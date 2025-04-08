package ru.fDrachen.spring.hibernate.repo;

import org.springframework.data.repository.CrudRepository;
import ru.fDrachen.spring.hibernate.entity.ProjectEntity;
import java.util.List;
import java.util.Optional;

public interface ProjectCurdRepository extends CrudRepository<ProjectEntity, Long> {
    List<ProjectEntity> findAll();
    Optional<ProjectEntity> findById(Long id);
}

