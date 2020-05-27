package tq.arxsoft.dictant.lessons;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tq.arxsoft.dictant.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Primary
public class LessonServiceImpl implements LessonService {

    private LessonRepository lessonRepository;
    private QuestionRepository questionRepository;

    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository, QuestionRepository questionRepository) {
        this.lessonRepository = lessonRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public List<LessonInfo> getLessonInfos() {
        return StreamSupport.stream(lessonRepository.findAll().spliterator(), false).map(
                x -> new LessonInfo(x.getId(), x.getName())
        ).collect(Collectors.toList());
    }

    @Override
    public LessonInfo getLessonInfo(long id) {
        LessonInfo result = new LessonInfo(-1l, "");
        //AtomicReference<LessonInfo> result = new AtomicReference<>();
        Optional<LessonEntity> lesson = lessonRepository.findById(id);
        lesson.ifPresent(x -> {
            result.setId(x.getId());
            result.setName(x.getName());
        });
        return result;
    }

    @Override
    public Lesson getLesson(long id) {

        LessonEntity lessonEntity = lessonRepository.findById(id).get();
        List<QuestionEntity> questionEntities = StreamSupport.stream(questionRepository.findByLesson_Id(lessonEntity.getId()).spliterator(), false).collect(Collectors.toList());
        Lesson lesson = convertFromEntity(lessonEntity, questionEntities);

        return lesson;
    }

    private List<Question> convertFromEntity(List<QuestionEntity> questionEntities) {
        List<Question> result = new ArrayList<>();
        for( QuestionEntity entity : questionEntities) {
            List<String> answers = convertFromAnswerEntity(entity.getAnwsers());
            Question question = new Question(entity.getType(), entity.getQuestion(), convertFromAnswerEntity(entity.getAnwsers()));
            result.add(question);
        }
        return result;
    }

    private List<String> convertFromAnswerEntity(List<QuestionAnswersEntity> anwsers) {
        List<String> result = new ArrayList<>();
        for( QuestionAnswersEntity entity : anwsers) {
            result.add(entity.getAnswer());
        }
        return result;
    }

    private Lesson convertFromEntity(LessonEntity lessonEntity, List<QuestionEntity> questionEntities) {
        List<Question> questions = convertFromEntity(questionEntities);
        Lesson lesson = new Lesson( new LessonInfo(lessonEntity.getId(), lessonEntity.getName()), questions );
        return lesson;
    }
}
