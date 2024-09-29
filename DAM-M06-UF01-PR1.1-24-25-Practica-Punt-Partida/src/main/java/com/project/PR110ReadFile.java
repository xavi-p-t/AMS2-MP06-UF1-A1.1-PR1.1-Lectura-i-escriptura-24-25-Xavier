package com.project;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PR110ReadFile {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/GestioTasques.java";
        llegirIMostrarFitxer(camiFitxer);  // Només cridem a la funció amb la ruta del fitxer
    }

    // Funció que llegeix el fitxer i mostra les línies amb numeració
    public static void llegirIMostrarFitxer(String camiFitxer) {

        File fitx = new File(camiFitxer);

        try{
            Scanner sc = new Scanner(fitx);
            int num = 0;
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                num++;
                System.out.println(num + ": " + linea);
            }
            sc.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
