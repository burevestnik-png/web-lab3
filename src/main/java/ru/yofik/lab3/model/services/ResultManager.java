package ru.yofik.lab3.model.services;

import com.google.inject.Guice;
import com.google.inject.Key;
import ru.yofik.lab3.storage.DAO;
import ru.yofik.lab3.storage.DAOException;
import ru.yofik.lab3.guiceModules.Lab3Module;
import ru.yofik.lab3.model.entities.Result;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "results")
@SessionScoped
public class ResultManager implements Serializable {
    private static final long UID = 123L;

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

    public void addResult(double x, double y, double r) {
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
