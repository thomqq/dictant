package tq.arxsoft.dictant.lessons;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Lesson {
    private LessonInfo lessonInfo;
    private List<Question> questions;

    public Question getNextQuestion(LessonContext lessonContext) {
        int pos = (lessonContext.getQuestionNumber() ) % questions.size();
        lessonContext.setQuestionNumber( pos  + 1);
        return questions.get(pos);
    }
}
