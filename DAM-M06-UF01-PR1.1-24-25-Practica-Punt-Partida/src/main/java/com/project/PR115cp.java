package com.project;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class PR115cp {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Error: Has d'indicar dues rutes d'arxiu.");
            System.out.println("Ús: PR115cp <origen> <destinació>");
            return;
        }

        // Ruta de l'arxiu origen
        String rutaOrigen = args[0];
        // Ruta de l'arxiu destinació
        String rutaDesti = args[1];

        // Crida al mètode per copiar l'arxiu
        copiarArxiu(rutaOrigen, rutaDesti);
    }

    // Mètode per copiar un arxiu de text de l'origen al destí
    public static void copiarArxiu(String rutaOrigen, String rutaDesti) {
        File origFich = new File(rutaOrigen);
        File destFich = new File(rutaDesti);
        String texto = "";
        if (!origFich.exists()){
            System.out.println("El fichero no existe");
        }
        else if (!origFich.isFile()){
            System.out.println("Esto no es un archivo");
        }
        else {
            try (Scanner scanner = new Scanner(new InputStreamReader(new FileInputStream(origFich), StandardCharsets.UTF_8))) {
                String linia;
                while (scanner.hasNextLine()) {
                    linia = scanner.nextLine();
                    if (scanner.hasNextLine()){
                        linia += "\n";
                    }
                    texto += linia;

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destFich), StandardCharsets.UTF_8))){
                bw.write(texto);
                bw.newLine();


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
