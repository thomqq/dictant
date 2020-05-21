package tq.arxsoft.dictant.lessons;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Question {
    private QuestionType type;
    private String question;
    private List<String> answers;
}
