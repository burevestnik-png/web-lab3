package ru.yofik.lab3.dao;

import java.util.List;

public interface DAO<T> {
    List<T> get() throws DAOException;

    void create(List<T> objects) throws DAOException;

    void update(List<T> objects) throws DAOException;

    void delete(List<T> objects) throws DAOException;
}
