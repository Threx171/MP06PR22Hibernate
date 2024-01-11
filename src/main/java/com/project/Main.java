package com.project;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

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

      Manager.close();
   }
}