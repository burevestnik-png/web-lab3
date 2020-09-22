package ru.yofik.lab3.guiceModules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import ru.yofik.lab3.dao.DAO;
import ru.yofik.lab3.dao.HibernateDAO;
import ru.yofik.lab3.model.result.Result;

public class Lab3Module extends AbstractModule {

    @Singleton
    @Provides
    DAO<Result> provideResultDAO() {
        return new HibernateDAO<>();
    }
}
