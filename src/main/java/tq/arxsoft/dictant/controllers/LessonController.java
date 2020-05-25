package tq.arxsoft.dictant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tq.arxsoft.dictant.lessons.*;

import java.util.HashMap;

@Controller
public class LessonController {

    private LessonService lessonService;
    private QuestionView questionView;
    private LessonContext lessonContext;

    @Autowired
    public LessonController(LessonService lessonService, QuestionView questionView, LessonContext lessonContext) {
        this.lessonService = lessonService;
        this.questionView = questionView;
        this.lessonContext = lessonContext;
    }

    @GetMapping("/lesson")
    ModelAndView lesson(@RequestParam("lessonid") int id) {
        ModelAndView modelAndView = new ModelAndView();
        Lesson lesson = lessonService.getLesson(id);
        modelAndView.addObject("lessonInfo", lesson.getLessonInfo());
        Question question = lesson.getNextQuestion(lessonContext);
        modelAndView.addObject("lessonQuestion", question.getQuestion());

        modelAndView.setViewName(questionView.getView(question));
        return modelAndView;
    }
}
