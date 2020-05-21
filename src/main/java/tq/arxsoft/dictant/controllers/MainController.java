package tq.arxsoft.dictant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import tq.arxsoft.dictant.lessons.LessonInfo;
import tq.arxsoft.dictant.lessons.LessonService;

import java.util.List;

@Controller
public class MainController {

    private LessonService lessonService;

    @Autowired
    public MainController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/")
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        List<LessonInfo> lesson = lessonService.getLessonInfos();
        modelAndView.addObject("lessons", lesson);
        modelAndView.setViewName("main");
        return modelAndView;
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }
}
