package tq.arxsoft.dictant.lessons.fakes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tq.arxsoft.dictant.entity.LessonRepository;
import tq.arxsoft.dictant.lessons.*;

import java.util.*;

@Service
@Primary
public class LessonServiceFake implements LessonService {


    private LessonRepository lessonRepository;

    @Autowired
    public LessonServiceFake(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

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
        switch (id) {
            case 1:
                return createInterviewLesson();
            case 2:
                return createPETLesson();
            case 3:
                return createAnimalLesson();

        }
        return null;
    }

    private Lesson createAnimalLesson() {
        Lesson lesson = new Lesson(getLessonInfo(3), createAnimalQuestion());
        return lesson;
    }

    private List<Question> createAnimalQuestion() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(QuestionType.SimpleQuestionAnswer, "Question1", Arrays.asList("Answer1")));
        questions.add(new Question(QuestionType.SimpleQuestionAnswer, "Question2", Arrays.asList("Answer2")));
        questions.add(new Question(QuestionType.SimpleQuestionAnswer, "Question3", Arrays.asList("Answer3")));
        questions.add(new Question(QuestionType.SimpleQuestionAnswer, "Question4", Arrays.asList("Answer4")));
        return questions;

    }

    private Lesson createPETLesson() {
        Lesson lesson = new Lesson(getLessonInfo(2), createPETQuestion());
        return lesson;
    }

    private List<Question> createPETQuestion() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(QuestionType.SimpleQuestionAnswer, "Question1", Arrays.asList("Answer1")));
        questions.add(new Question(QuestionType.SimpleQuestionAnswer, "Question2", Arrays.asList("Answer2")));
        questions.add(new Question(QuestionType.SimpleQuestionAnswer, "Question3", Arrays.asList("Answer3")));
        questions.add(new Question(QuestionType.SimpleQuestionAnswer, "Question4", Arrays.asList("Answer4")));
        return questions;
    }

    private Lesson createInterviewLesson() {
        Lesson lesson = new Lesson(getLessonInfo(1), createInterviewQuestion());
        return lesson;
    }

    private List<Question> createInterviewQuestion() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(QuestionType.SimpleQuestionAnswer, "Question1", Arrays.asList("Answer1")));
        questions.add(new Question(QuestionType.SimpleQuestionAnswer, "Question2", Arrays.asList("Answer2")));
        questions.add(new Question(QuestionType.SimpleQuestionAnswer, "Question3", Arrays.asList("Answer3")));
        questions.add(new Question(QuestionType.SimpleQuestionAnswer, "Question4", Arrays.asList("Answer4")));
        return questions;
    }

    @Override
    public LessonInfo getLessonInfo(int id) {
        return lessons.get(id);
    }
}
