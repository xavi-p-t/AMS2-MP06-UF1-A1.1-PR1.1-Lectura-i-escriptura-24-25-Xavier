package com.project;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PR114linies {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/numeros.txt";

        // Crida al mètode que genera i escriu els números aleatoris
        generarNumerosAleatoris(camiFitxer);
    }

    // Mètode per generar 10 números aleatoris i escriure'ls al fitxer
    public static void generarNumerosAleatoris(String camiFitxer) {
        File fich = new File(camiFitxer);
        int num = 0;
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fich), StandardCharsets.UTF_8))){
           for (int i = 0; i<10;i++){
               num = (int)(Math.random() * 100);
               bw.write(""+num);
               bw.newLine();
           }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
