package com.radauer;

import java.io.Serializable;

/**
 * Created by Andreas on 17.04.2017.
 */
public class QuizSession implements Serializable
{

    private String user;
    private String email;
    private String company;
    private long quizStart;
    private int currentQuestion;
    private int points;

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public long getQuizStart()
    {
        return quizStart;
    }

    public void setQuizStart(long quizStart)
    {
        this.quizStart = quizStart;
    }

    public int getCurrentQuestion()
    {
        return currentQuestion;
    }

    public void setCurrentQuestion(int currentQuestion)
    {
        this.currentQuestion = currentQuestion;
    }

    public int getPoints()
    {
        return points;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString()
    {
        return "QuizSession{"
            + "user='"
            + user
            + '\''
            + ", email='"
            + email
            + '\''
            + ", quizStart="
            + quizStart
            + ", currentQuestion="
            + currentQuestion
            + ", points="
            + points
            + '}';
    }
}
