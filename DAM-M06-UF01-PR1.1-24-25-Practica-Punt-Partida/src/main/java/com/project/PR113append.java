package com.project;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PR113append {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/frasesMatrix.txt";

        // Crida al mètode que afegeix les frases al fitxer
        afegirFrases(camiFitxer);
    }

    // Mètode que afegeix les frases al fitxer amb UTF-8 i línia en blanc final
    public static void afegirFrases(String camiFitxer) {
        File fich = new File(camiFitxer);
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fich,true),StandardCharsets.UTF_8))){
            bw.write("I can only show you the door");
            bw.newLine();
            bw.write("You're the one that has to walk through it");
            bw.newLine();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
