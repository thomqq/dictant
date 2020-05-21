package tq.arxsoft.dictant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tq.arxsoft.dictant.lessons.LessonInfo;
import tq.arxsoft.dictant.lessons.LessonService;

@Controller
public class LessonController {

    private LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/lesson")
    ModelAndView lesson(@RequestParam("lessonid") int id) {
        ModelAndView modelAndView = new ModelAndView();
        LessonInfo lessonInfo = lessonService.getLesson(id);
        modelAndView.addObject("lessonInfo", lessonInfo);
        modelAndView.setViewName("lesson");

        return  modelAndView;
    }
}
