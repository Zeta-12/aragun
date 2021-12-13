package com.example.test.lienBDD;

public class Communautes {

    private Integer idCommunaute;
    private String nomCommunaute;

    public Communautes(Integer idCommunaute, String nomCommunaute){
        this.idCommunaute = idCommunaute;
        this.nomCommunaute = nomCommunaute;
    }

    public Integer getIdCommunaute() {
        return idCommunaute;
    }

    public void setIdCommunaute(Integer idCommunaute) {
        this.idCommunaute = idCommunaute;
    }

    public String getNomCommunaute() {
        return nomCommunaute;
    }

    public void setNomCommunaute(String nomCommunaute) {
        this.nomCommunaute = nomCommunaute;
    }
}
