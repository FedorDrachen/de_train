package ru.fDrachen.spring.hibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.fDrachen.domain.model.OpenQuestionCard;
import ru.fDrachen.domain.repo.QuestionRepository;
import ru.fDrachen.spring.hibernate.entity.OpenQuestionCardEntity;
import ru.fDrachen.spring.hibernate.mapper.QuestionMapper;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class QuestionHibernateDao implements QuestionRepository {

    private static final Logger logger = LogManager.getLogger(QuestionHibernateDao.class);

    private final QuestionMapper mapper;

    @PersistenceContext
    private EntityManager entityManager;

    public QuestionHibernateDao(QuestionMapper mapper) {
        this.mapper = mapper;
    }

    @Transactional
    public void save(OpenQuestionCard openQuestionCard) {
        OpenQuestionCardEntity entity = mapper.mapToEntity(openQuestionCard);
        entityManager.merge(entity);
    }
    @Override
    @Transactional(readOnly = true)
    public List<OpenQuestionCard> findAll() {
        logger.debug("Выбираем всех");
        List<OpenQuestionCardEntity> openQuestionCardEntities = entityManager
                .createQuery("SELECT question FROM OpenQuestionCardEntity question", OpenQuestionCardEntity.class)
                .getResultList();
        return mapper.mapToModel(openQuestionCardEntities);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OpenQuestionCard> findById(Long id) {
        List<OpenQuestionCardEntity> entity = entityManager.createQuery("SELECT question FROM OpenQuestionCardEntity question WHERE question.id = ?1", OpenQuestionCardEntity.class)
                .setParameter(1, id)
                .getResultList();
        if (!entity.isEmpty()) {
            OpenQuestionCard openQuestionCard = mapper.mapToModel(entity.get(0));
            return Optional.of(openQuestionCard);
        } else {
            return Optional.empty();
        }
    }
    @Override
    @Transactional
    public void add(OpenQuestionCard openQuestionCard) {
        save(openQuestionCard);
    }


    @Override
    public void update(OpenQuestionCard openQuestionCard) {
        save(openQuestionCard);
    }

    @Override
    public void remove(Long id) {
        OpenQuestionCardEntity entity = entityManager.createQuery("SELECT question FROM OpenQuestionCardEntity question WHERE question.id = ?1", OpenQuestionCardEntity.class)
                .setParameter(1, id)
                .getSingleResult();
        entityManager.remove(entity);
    }
}
