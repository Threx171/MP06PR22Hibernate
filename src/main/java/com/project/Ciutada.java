package com.project;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Ciutada")
public class Ciutada implements Serializable{
    
    @Id
    @Column(name = "ciutadaId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ciutadaId;
    private long ciutatId;

    @Column(name = "nom")
    private String nom;
    private String cognom;
    private int edat;
    private Ciutat ciutat;

    public Ciutada() {}

    public Ciutada(long ciutatId, String nom, String cognom, int edat) {
        this.ciutatId = ciutatId;
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
    }

    public long getCiutadaId() {
        return this.ciutadaId;
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

    public void setCiutat (Ciutat ciutat) {
        this.ciutat = ciutat;
    }

    public Ciutat getCiutat () {
        return this.ciutat;
    }

    @Override
    public String toString () {
      	return this.getNom() + " " + this.getCognom() + ", " + this.getEdat() + " - " + this.getCiutadaId();
    }
}
