package ru.yofik.lab3.model.services;

import lombok.Getter;
import ru.yofik.lab3.model.entities.Result;
import ru.yofik.lab3.storage.ResultDAO;

import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "resultsBean")
@SessionScoped
public class ResultManager implements Serializable {
    private static final long UID = 123L;

    @ManagedProperty(value = "#{dao}")
    private ResultDAO resultDAO;

    @Getter
    private List<Result> results;

    @Getter
    private Result currentResult;


    public ResultManager() {
        results = resultDAO.get();
        currentResult = new Result();
    }


    public void addResult() {
        currentResult.setCurrentTime(new Date(System.currentTimeMillis()));
        currentResult.setHit(HitChecker.isHit(currentResult.getX(), currentResult.getY(), currentResult.getR()));
        results.add(currentResult);

        resultDAO.create(Collections.singletonList(currentResult));

        currentResult = new Result();
    }
}
