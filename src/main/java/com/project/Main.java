package com.project;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Hibernate;

/*

Help: https://www.baeldung.com/hibernate-one-to-many

*/

public class Main {

   public static void main(String[] args) {
      
      String basePath = System.getProperty("user.dir") + "/data/";

      // Crear la carpeta 'data' si no existeix
      File dir = new File(basePath);
      if (!dir.exists()){
         if(!dir.mkdirs()) {
               System.out.println("Error en la creació de la carpeta 'data'");
         }
      }

      Manager.createSessionFactory();

      try {

         Ciutat ciutat1 = Manager.addCiutat("Barcelona", "Spain", 8001);
         Ciutat ciutat2 = Manager.addCiutat("Madrid", "Spain", 8002);
         Ciutat ciutat3 = Manager.addCiutat("Alicante", "Spain", 8003);

         Ciutada ciutada1 = Manager.addCiutada(ciutat1.getCiutatId(), "Joan", "Perez", 20);
         Ciutada ciutada2 = Manager.addCiutada(ciutat1.getCiutatId(), "Maria", "Garcia", 30);
         Ciutada ciutada3 = Manager.addCiutada(ciutat2.getCiutatId(), "Pere", "Martinez", 40);
         Ciutada ciutada4 = Manager.addCiutada(ciutat2.getCiutatId(), "Anna", "Lopez", 50);
         Ciutada ciutada5 = Manager.addCiutada(ciutat3.getCiutatId(), "Jordi", "Sanchez", 60);
         Ciutada ciutada6 = Manager.addCiutada(ciutat3.getCiutatId(), "Laura", "Gomez", 70);

         Set<Ciutada> ciutadans1 = new HashSet<Ciutada>();
         ciutadans1.add(ciutada1);
         ciutadans1.add(ciutada2);

         Set<Ciutada> ciutadans2 = new HashSet<Ciutada>();
         ciutadans2.add(ciutada3);
         ciutadans2.add(ciutada4);

         Set<Ciutada> ciutadans3 = new HashSet<Ciutada>();
         ciutadans3.add(ciutada5);
         ciutadans3.add(ciutada6);

         ciutat1.setCiutadans(ciutadans1);
         ciutat2.setCiutadans(ciutadans2);
         ciutat3.setCiutadans(ciutadans3);

         Manager.updateCiutat(ciutat1.getCiutatId(), ciutat1.getNom(), ciutat1.getPais(), ciutat1.getCodiPostal(), ciutadans1);
         Manager.updateCiutat(ciutat2.getCiutatId(), ciutat2.getNom(), ciutat2.getPais(), ciutat2.getCodiPostal(), ciutadans2);
         Manager.updateCiutat(ciutat3.getCiutatId(), ciutat3.getNom(), ciutat3.getPais(), ciutat3.getCodiPostal(), ciutadans3);


         System.out.println("---------------------------------");

         // System.out.println("Ciutats:\n" + ciutat1.getNom() + ", " + ciutat1.getPais() + " " + ciutat1.getCodiPostal() + "\n" + ciutat2.getNom() + ", " + ciutat2.getPais() + " " + ciutat2.getCodiPostal() + "\n" + ciutat3.getNom() + ", " + ciutat3.getPais() + " " + ciutat3.getCodiPostal() + "\n");

         // System.out.println("---------------------------------");
         // System.out.println("Ciutadans:");
         // System.out.println(Manager.collectionToString(Ciutada.class, Manager.listCollection(Ciutada.class, "")));

         Collection<?> ciutats = Manager.listCollection(Ciutat.class, "");
         for(Object obj: ciutats) {
            Ciutat cObj = (Ciutat) obj;
            System.out.println("Ciutadans de " + cObj.getNom() + ":");
            Collection<?> ciutadans = Manager.listCollection(Ciutada.class, 
                                              "ciutatId=" + cObj.getCiutatId());
            for(Object obj2: ciutadans) {
               Ciutada cObj2 = (Ciutada) obj2;
               System.out.println("    " + cObj2.toString());
            }
         }

         Manager.delete(Ciutada.class, ciutada2.getCiutadaId());
         Manager.delete(Ciutada.class, ciutada4.getCiutadaId());
         Manager.delete(Ciutada.class, ciutada6.getCiutadaId());
         Manager.delete(Ciutat.class, ciutat2.getCiutatId());
        
         System.out.println("Ciutats:");
         Collection<?> llista = Manager.listCollection(Ciutat.class, "");
         for(Object obj: ciutats) {
            Ciutat cObj = (Ciutat) obj;
            System.out.println("  " + cObj);
         }
         System.out.println("Ciutadans:");
         llista = Manager.listCollection(Ciutada.class, "");
         for(Object obj: llista) {
            Ciutada cObj = (Ciutada) obj;
            System.out.println("  " + cObj);
         }
       
       
        


         Manager.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}