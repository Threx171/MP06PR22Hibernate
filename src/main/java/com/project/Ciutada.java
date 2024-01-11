package com.project;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Ciutada implements Serializable{
    
    private long ciutadaId;
    private long ciutatId;
    private String nom;
    private String cognom;
    private int edat;

    public Ciutada() {}

    public Ciutada(String nom, String cognom, int edat) {
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
    }

    public long getCiutadaId() {
        return ciutadaId;
    }

    public void setCiutadaId(long id) {
        this.ciutadaId = id;
    }

    public long getCiutatId() {
        return ciutatId;
    }

    public void setCiutatId(long id) {
        this.ciutatId = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }
}
