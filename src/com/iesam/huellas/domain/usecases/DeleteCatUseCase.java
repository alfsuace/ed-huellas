package com.iesam.huellas.domain.usecases;

import com.iesam.huellas.domain.models.CatRepository;



public class DeleteCatUseCase {

    private CatRepository catRepository;

    public DeleteCatUseCase(CatRepository catRepository){
        this.catRepository = catRepository;
    }

    public void execute(Integer catId){
        catRepository.delete(catId);
    }
}
