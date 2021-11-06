package com.my.maven.project.data.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {
    T save (T t);
    Optional<T> findById(ID id);
    void delete(ID id);
    List<T> findAll();
}
