package ru.lukyanov.repo;

public interface Repo<T> {
    T getById(Long id);
}