package com.iesam.huellas.domain.usecases;

import com.iesam.huellas.domain.models.Cat;
import com.iesam.huellas.domain.models.CatRepository;


public class AddCatUseCase {

    private final CatRepository repository;

    public AddCatUseCase(CatRepository repository) {
        this.repository = repository;
    }

    public void execute(Cat cat) {
        repository.save(cat);
    }
}
