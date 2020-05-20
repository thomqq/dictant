package tq.arxsoft.dictant.lessons.fakes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tq.arxsoft.dictant.lessons.LessonInfo;
import tq.arxsoft.dictant.lessons.LessonService;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class LessonServiceFake implements LessonService {
    @Override
    public List<LessonInfo> getLessons() {
        ArrayList<LessonInfo> infos = new ArrayList<>();
        infos.add(new LessonInfo(1, "Rozmowa"));
        infos.add(new LessonInfo(2, "Zwierzęta"));
        infos.add(new LessonInfo(3, "PET"));
        return infos;
    }
}
