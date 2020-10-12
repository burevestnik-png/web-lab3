package ru.yofik.lab3.model.services;

import lombok.Getter;
import ru.yofik.lab3.model.entities.Result;
import ru.yofik.lab3.storage.ResultDAO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

//@ManagedBean(name = "resultsBean")
//@SessionScoped
public class ResultManager implements Serializable {
    private static final long UID = 123L;

    private ResultDAO resultDAO;

    @Getter
    private List<Result> results;

    @Getter
    private Result currentResult;


    public void init() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        resultDAO =
                (ResultDAO) facesContext.getApplication().createValueBinding("#{dao}").getValue(facesContext);

        results = resultDAO.get();
        currentResult = new Result();

        if (results.size() > 0) {
            currentResult.setX(null);
            currentResult.setY(null);
            currentResult.setR(results.get(results.size() - 1).getR());
        } else {
            currentResult.setX(null);
            currentResult.setY(null);
            currentResult.setR(5.0);
        }

        System.out.println("her");
    }


    public void addResult() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
        currentResult.setCurrentTime(dateFormat.format(new Date(System.currentTimeMillis())));
        System.out.println(currentResult.getX());
        System.out.println(currentResult.getY());
        System.out.println(currentResult.getR());
        System.out.println(HitChecker.isHit(currentResult.getX(), currentResult.getY(), currentResult.getR()));
        currentResult.setHit(HitChecker.isHit(currentResult.getX(), currentResult.getY(), currentResult.getR()));
        results.add(currentResult);

        resultDAO.create(Collections.singletonList(currentResult));

        currentResult = new Result();
        currentResult.setX(null);
        currentResult.setY(null);
        currentResult.setR(results.get(results.size() - 1).getR());
    }
}
