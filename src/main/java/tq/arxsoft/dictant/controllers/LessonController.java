package tq.arxsoft.dictant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LessonController {

    @GetMapping("/lesson")
    ModelAndView lesson() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("lesson");

        return  modelAndView;
    }
}
