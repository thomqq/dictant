package tq.arxsoft.dictant.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<QuestionEntity, Long> {
    Iterable<QuestionEntity> findByLesson_Id(Long id);
}
