package tq.arxsoft.dictant.controllers;

import tq.arxsoft.dictant.lessons.Question;
import tq.arxsoft.dictant.lessons.QuestionType;

import java.util.HashMap;

public class QuestionView {
    HashMap< QuestionType, String> typeToView = new HashMap<>();
    public void add(QuestionType questionType, String viewName) {
        typeToView.put(questionType, viewName);
    }

    public String getView(Question question) {
        return typeToView.get(question.getType());
    }
}
