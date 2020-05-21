package tq.arxsoft.dictant.lessons.fakes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tq.arxsoft.dictant.lessons.Lesson;
import tq.arxsoft.dictant.lessons.LessonInfo;
import tq.arxsoft.dictant.lessons.LessonService;

import java.util.*;

@Service
@Primary
public class LessonServiceFake implements LessonService {

    private Hashtable<Integer, LessonInfo> lessons = new Hashtable<>();

    public LessonServiceFake() {
        lessons.put(1, new LessonInfo(1, "Rozmowa"));
        lessons.put(2, new LessonInfo(2, "PET"));
        lessons.put(3, new LessonInfo(3, "Zwierzęta"));

    }

    @Override
    public List<LessonInfo> getLessonInfos() {
        ArrayList<LessonInfo> infos = new ArrayList<>();
        for (Integer i : lessons.keySet()) {
            infos.add(lessons.get(i));
        }
        infos.sort((x, y) -> x.getName().compareTo(y.getName()));
        return infos;
    }

    @Override
    public Lesson getLesson(int id) {
        return null;
    }

    @Override
    public LessonInfo getLessonInfo(int id) {
        return lessons.get(id);
    }
}
