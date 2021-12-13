package com.example.test.lienBDD;

public class Messages {

    private Integer idMessage;
    private Integer idChannel;
    private String contenu;

    public Messages(Integer idMessage, Integer idChannel,
                    String contenu){
        this.idMessage = idMessage;
        this.idChannel = idChannel;
        this.contenu = contenu;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public Integer getIdChannel() {
        return idChannel;
    }

    public void setIdChannel(Integer idChannel) {
        this.idChannel = idChannel;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}