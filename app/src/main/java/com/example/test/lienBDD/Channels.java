package com.example.test.lienBDD;

public class Channels {

    private Integer idChannel;
    private Integer idCommunate;
    private Integer idDroit;
    private String nomChannel;

    public Channels(Integer idChannel, Integer idCommunate,
                    Integer idDroit, String nomChannel){
        this.idChannel = idChannel;
        this.idCommunate = idCommunate;
        this.idDroit = idDroit;
        this.nomChannel = nomChannel;
    }

    public Integer getIdChannel() {
        return idChannel;
    }

    public void setIdChannel(Integer idChannel) {
        this.idChannel = idChannel;
    }

    public Integer getIdCommunate() {
        return idCommunate;
    }

    public void setIdCommunate(Integer idCommunate) {
        this.idCommunate = idCommunate;
    }

    public Integer getIdDroit() {
        return idDroit;
    }

    public void setIdDroit(Integer idDroit) {
        this.idDroit = idDroit;
    }

    public String getNomChannel() {
        return nomChannel;
    }

    public void setNomChannel(String nomChannel) {
        this.nomChannel = nomChannel;
    }
}