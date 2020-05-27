package tq.arxsoft.dictant.lessons;

import java.util.List;

public interface LessonService {
    List<LessonInfo> getLessonInfos();

    LessonInfo getLessonInfo(long id);

    Lesson getLesson(long id);
}
