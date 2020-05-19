package tq.arxsoft.dictant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/")
public class MainCotroller {

    @GetMapping
    public String main() {
        return "main";
    }
}
