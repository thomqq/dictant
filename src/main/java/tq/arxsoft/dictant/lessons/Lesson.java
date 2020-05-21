package tq.arxsoft.dictant.lessons;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Lesson {
    private LessonInfo lessonInfo;
    private List<Question> questions;
}
