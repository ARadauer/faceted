package com.radauer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Andreas on 17.04.2017.
 */
@Service
public class ResultService {
    private List<Result> resultList = new ArrayList<>();

    public List<ResultTo> getResults() {

        List<ResultTo> toList = new ArrayList<>(resultList.size());
        for (int i = 0; i < resultList.size(); i++) {
            Result result = resultList.get(i);
            toList.add(new ResultTo(i + 1, result.getName(), result.getPoints(), result.getTime()));
        }

        return toList;
    }

    public int addResult(Result result) {

        resultList.add(result);
        Collections.sort(resultList, new Comparator<Result>() {
            @Override
            public int compare(Result o1, Result o2) {
                if(o1.getPoints() == o2.getPoints()){
                    return o1.getTime() - o2.getTime();
                }
                return o2.getPoints()- o1.getPoints();
            }
        });

        return resultList.indexOf(result);
    }

    public boolean containsEmail(String email){
        Result result = new Result();
        result.setEmail(email);
        return resultList.contains(result);
    }

}
