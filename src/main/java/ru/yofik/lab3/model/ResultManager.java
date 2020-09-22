package ru.yofik.lab3.model;

import ru.yofik.lab3.result.Result;

import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "results")
@ApplicationScoped
public class ResultManager {
    private final List<Result> results;


    public ResultManager() {
        results = new ArrayList<>();
    }


    private List<Result> getResults() {
        return results;
    }

    private void setResults() {
        throw new RuntimeException("Not allowed");
    }

    @Override
    public String toString() {
        return "ResultManager{" +
                "results=" + results +
                '}';
    }
}
