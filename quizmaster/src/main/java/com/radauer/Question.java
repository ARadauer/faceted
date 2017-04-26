package com.radauer;

/**
 * Created by Andreas on 17.04.2017.
 */
public class Question {
    String question;
    String[] answers;
    int correctAnswer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public Answer[] generateAnswersForResult() {
        Answer[] result = new Answer[answers.length];
        for (int i = 0; i < answers.length; i++) {
            result[i] = new Answer(i, answers[i]);
        }
        return result;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
