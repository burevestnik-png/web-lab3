package ru.yofik.lab3.dao;

import java.util.List;

public final class HibernateDAO<T> implements DAO<T> {
    @Override
    public List<T> get() throws DAOException {
        return null;
    }

    @Override
    public void create(List<T> objects) throws DAOException {

    }

    @Override
    public void update(List<T> objects) throws DAOException {

    }

    @Override
    public void delete(List<T> objects) throws DAOException {

    }
}
