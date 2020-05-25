package tq.arxsoft.dictant.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import tq.arxsoft.dictant.controllers.QuestionView;
import tq.arxsoft.dictant.lessons.LessonContext;
import tq.arxsoft.dictant.lessons.QuestionType;

@Configuration
public class QuestionViewFactory {
    @Bean
    @Scope(value = "prototype")
    QuestionView createQuestionView() {
        QuestionView questionView = new QuestionView();
        questionView.add(QuestionType.SimpleQuestionAnswer, "simple_answer");
        return questionView;
    }

    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    LessonContext createLessonContext() {
        return new LessonContext();
    }
}
