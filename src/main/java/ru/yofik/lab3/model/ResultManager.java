package ru.yofik.lab3.model;

import com.google.inject.Guice;
import com.google.inject.Key;
import ru.yofik.lab3.dao.DAO;
import ru.yofik.lab3.dao.DAOException;
import ru.yofik.lab3.guiceModules.Lab3Module;
import ru.yofik.lab3.model.result.Result;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "results")
@ApplicationScoped
public class ResultManager {
    private DAO<Result> resultDAO;

    private final List<Result> results;


    public ResultManager() {
        resultDAO = Guice.createInjector(new Lab3Module()).getInstance(new Key<DAO<Result>>() {});
        try {
            results = resultDAO.get();
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Result> getResults() {
        return results;
    }

    public void setResults() {
        throw new RuntimeException("Not allowed");
    }

    public void addResult(double x, double y, int r) {
        Result result = new Result(x, y, r, HitChecker.isHit(x, y, r));
        results.add(result);

        List<Result> newResults = new ArrayList<>();
        newResults.add(result);
        try {
            resultDAO.create(newResults);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "ResultManager{" +
                "results=" + results +
                '}';
    }
}
