package tq.arxsoft.dictant.entity;

import lombok.Data;
import tq.arxsoft.dictant.lessons.QuestionType;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="questions")
public class QuestionEntity {
    @Id
    private Long id;
    @ManyToOne
    private LessonEntity lesson;
    private String question;

    @ElementCollection
    @CollectionTable(
            name = "answers",
            joinColumns=@JoinColumn(name="question_id")
    )
    private List<QuestionAnswersEntity> anwsers;

    @Enumerated
    private QuestionType type;
}
