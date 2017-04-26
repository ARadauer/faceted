package com.radauer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Andreas on 17.04.2017.
 */
@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    public List<ResultTo> getResults() {

        Iterable<Result> resultList = resultRepository.findAll();
        List<ResultTo> toList = new ArrayList<>();
        int count = 0;
        for (Result result : resultList) {
            count++;

            toList.add(new ResultTo(count, result.getName(), result.getCompany(), result.getPoints(), result.getTime()));
        }

        return toList;
    }

    public int addResult(Result result) {

        resultRepository.save(result);

        List<Result> resultList = (List<Result>) resultRepository.findAll();
        sort(resultList);

        return resultList.indexOf(result);
    }

    private void sort(List<Result> resultList) {
        Collections.sort(resultList, (o1, o2) -> {
            if (o1.getPoints() == o2.getPoints()) {
                return o1.getTime() - o2.getTime();
            }
            return o2.getPoints() - o1.getPoints();
        });
    }

    public boolean containsEmail(String email) {
        Result result = new Result();
        result.setEmail(email);
        //TOOD
        return false;
    }

}
