package com.example.demo.service;

import java.util.Optional;

public interface IGeneral<T> {
    Iterable<T> findAll();

    Optional<T> findOne();

    T save(T t);

    void remove(Long id);
}
