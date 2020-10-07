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


    public ResultManager() {
        this.resultDAO = new HibernateDAO<>("From Result");
        results = resultDAO.get();
    }


    public void addResult(double x, double y, double r) {
        Result result = new Result();
        result.setX(x);
        result.setY(y);
        result.setR(r);
        result.setHit(HitChecker.isHit(x, y, r));
        results.add(result);

        resultDAO.create(Collections.singletonList(result));
    }
}
