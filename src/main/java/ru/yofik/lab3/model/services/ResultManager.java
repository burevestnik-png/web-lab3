package ru.yofik.lab3.model.services;

import lombok.Getter;
import ru.yofik.lab3.model.entities.Result;
import ru.yofik.lab3.storage.DAO;
import ru.yofik.lab3.storage.HibernateDAO;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@ManagedBean(name = "resultsBean")
@SessionScoped
public class ResultManager implements Serializable {
    private static final long UID = 123L;

    private DAO<Result> resultDAO;

    @Getter
    private final List<Result> results;

    @Getter
    private Result currentResult;


    public ResultManager() {
        this.resultDAO = new HibernateDAO<>("From Result");
        results = resultDAO.get();
        currentResult = new Result();
    }


    public void addResult() {
        currentResult.setHit(HitChecker.isHit(currentResult.getX(), currentResult.getY(), currentResult.getR()));
        results.add(currentResult);

        resultDAO.create(Collections.singletonList(currentResult));

        currentResult = new Result();
    }
}
