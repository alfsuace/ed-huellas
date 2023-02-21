package com.iesam.huellas.domain.models;

import java.util.List;

public interface CatRepository {
    public void save(Cat cat);
    public List<Cat> getAll();
    public Cat getById(Integer id);
    public void delete(Integer id);
    public void update(Cat cat);
}
