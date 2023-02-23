package com.iesam.huellas.domain.models;

public class Cat extends Animal{
    private Integer id;
    private boolean hasLeukemia;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isHasLeukemia() {
        return hasLeukemia;
    }

    public void setHasLeukemia(boolean hasLeukemia) {
        this.hasLeukemia = hasLeukemia;
    }
}
