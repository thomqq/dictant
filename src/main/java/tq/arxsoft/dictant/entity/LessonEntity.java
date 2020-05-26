package tq.arxsoft.dictant.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lesson", schema = "dictant")
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class LessonEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private final Long id;
    private final String name;

}
