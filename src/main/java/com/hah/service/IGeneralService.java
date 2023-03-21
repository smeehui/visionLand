package com.hah.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> findAll();

    Optional<T> findById(Long id);
    T save(T t);
    void deleteById(Long id);

    void delete(T t);
}