package com.project;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Ciutat")
public class Ciutat implements Serializable {
    
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      @Column(name = "ciutatId", unique = true, nullable = false)
      private long ciutatId;

      @Column(name = "nom")
      private String nom;  

      private String pais;

      private int codiPostal;

      private Set<Ciutada> ciutadans;

      public Ciutat() {}
    
      public Ciutat(String nom, String pais, int codiPostal) {
         this.nom = nom;
         this.pais = pais;
         this.codiPostal = codiPostal;
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
    
      public String getPais() {
         return pais;
      }

      public void setPais(String pais) {
         this.pais = pais;
      }

      public int getCodiPostal() {
         return codiPostal;
      }

      public void setCodiPostal(int codiPostal) {
         this.codiPostal = codiPostal;
      }

      public void setCiutadans(Set<Ciutada> ciutadans) {
         this.ciutadans = ciutadans;
      }

      public Set<Ciutada> getCiutadans() {
         return this.ciutadans;
      }

      public String getCiutadansString() {
         return Manager.collectionToString(Ciutada.class, this.ciutadans);
      }

      public List<Object[]> queryItems () {
		   long id = this.getCiutatId();
		   return Manager.queryTable("SELECT DISTINCT i.name, i.surname, i.age, i.ciutatId FROM Ciutada i, Ciutat c WHERE c.ciutatId = i.ciutatId AND c.ciutatId = " + id);
	   }


      @Override
      public String toString () {
         return this.getNom() + ", " + this.getPais() + " " + this.getCodiPostal();
      }
 }