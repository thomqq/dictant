package tq.arxsoft.dictant.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Embeddable
@Table(name = " answers")
@Data
public class QuestionAnswersEntity {
    @Id
    private Long id;
    private String answer;
}
