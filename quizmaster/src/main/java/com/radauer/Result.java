package com.radauer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Andreas on 17.04.2017.
 */
@Entity
public class Result {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String company;
    private int points;
    private int time;

    public Result(String name, String email, String company, int points, int time) {
        this.name = name;
        this.company = company;
        this.email = email;
        this.points = points;
        this.time = time;
    }

    public Result() {

    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Result result = (Result) o;

        return email != null ? email.equals(result.email) : result.email == null;

    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }
}
