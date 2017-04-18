package com.radauer;

/**
 * Created by Andreas on 17.04.2017.
 */
public class QuizResult
{

    private String user;

    private String message;
    private boolean finished;

    private int currentQuestion;
    private String question;
    private String[] answers;
    private int timeInSecounds;
    private int points;

    public int getCurrentQuestion()
    {
        return currentQuestion;
    }

    public void setCurrentQuestion(int currentQuestion)
    {
        this.currentQuestion = currentQuestion;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public String[] getAnswers()
    {
        return answers;
    }

    public void setAnswers(String[] answers)
    {
        this.answers = answers;
    }

    public int getTimeInSecounds()
    {
        return timeInSecounds;
    }

    public void setTimeInSecounds(int timeInSecounds)
    {
        this.timeInSecounds = timeInSecounds;
    }

    public int getPoints()
    {
        return points;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public boolean isFinished()
    {
        return finished;
    }

    public void setFinished(boolean finished)
    {
        this.finished = finished;
    }
}
