package com.radauer;

/**
 * Created by Andreas on 24.04.2017.
 */
public class Answer {
    private int number;
    private String answer;

    public Answer(int number, String answer) {
        this.number = number;
        this.answer = answer;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
