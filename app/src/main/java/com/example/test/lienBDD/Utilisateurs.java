package com.example.test.lienBDD;

public class Utilisateurs {

    private String identifiant;
    private String email;
    private String password;
    private Integer idDroit;

    public Utilisateurs(String identifiant, String email,
                        String password, Integer idDroit){
        this.identifiant = identifiant;
        this.email = email;
        this.password = password;
        this.idDroit = idDroit;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdDroit() {
        return idDroit;
    }

    public void setIdDroit(Integer idDroit) {
        this.idDroit = idDroit;
    }
}