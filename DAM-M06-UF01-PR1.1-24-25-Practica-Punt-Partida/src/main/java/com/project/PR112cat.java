package com.project;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PR112cat {

    public static void main(String[] args) {
        // Comprovar que s'ha proporcionat una ruta com a paràmetre
        if (args.length == 0) {
            System.out.println("No s'ha proporcionat cap ruta d'arxiu.");
            return;
        }

        // Obtenir la ruta del fitxer des dels paràmetres
        String rutaArxiu = args[0];
        mostrarContingutArxiu(rutaArxiu);
    }

    // Funció per mostrar el contingut de l'arxiu o el missatge d'error corresponent
    public static void mostrarContingutArxiu(String rutaArxiu) {
        File arch = new File(rutaArxiu);
        if (!arch.exists()){
            System.out.println("El fitxer no existeix o no és accessible.");
        }
        else if (arch.isDirectory()){
            System.out.println("El path no correspon a un arxiu, sinó a una carpeta.");
        } else {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arch), StandardCharsets.UTF_8))) {
                String linia;
                while ((linia = br.readLine()) != null) {
                    System.out.println(linia);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
