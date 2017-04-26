package com.radauer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andreas on 17.04.2017.
 */
public class Questions
{
    private List<Question> questions;

    public Questions()
    {
        this.questions = new ArrayList<>();
        for (int i = 0; i < 3; i++)
        {
            Question question = new Question();
            question.setQuestion("This is Question # " + (i + 1));
            question.setAnswers(new String[4]);
            question.setCorrectAnswer(0);
            questions.add(question);

            for (char c = 'A'; c < 'E'; c++)
            {
                question.getAnswers()[c - 'A'] = "answer " + c;
            }
        }
    }

    public Question getQuestion(int currentQuestion)
    {
        return questions.get(currentQuestion);
    }

    public int size()
    {
        return questions.size();
    }
}
