package com.radauer;

/**
 * Created by Andreas on 17.04.2017.
 */
public class ResultTo
{
    private int num;
    private String name;
    private int points;
    private int time;

    public ResultTo(int num, String name, int points, int time)
    {
        this.num = num;
        this.name = name;
        this.points = points;
        this.time = time;
    }

    public int getNum()
    {
        return num;
    }

    public void setNum(int num)
    {
        this.num = num;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPoints()
    {
        return points;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }

    public int getTime()
    {
        return time;
    }

    public void setTime(int time)
    {
        this.time = time;
    }
}
