package com.example.test.lienBDD;

public class Droits {

    private Integer idDroit;
    private String type;

    public Droits(Integer idDroit, String type){
        this.idDroit = idDroit;
        this.type = type;
    }

    public Integer getIdDroit() {
        return idDroit;
    }

    public void setIdDroit(Integer idDroit) {
        this.idDroit = idDroit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}