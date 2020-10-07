package ru.yofik.lab3.storage;

import java.util.List;

public interface DAO<T> {
    List<T> get();

    void create(List<T> objects);

    void update(List<T> objects);

    void delete(List<T> objects);
}
