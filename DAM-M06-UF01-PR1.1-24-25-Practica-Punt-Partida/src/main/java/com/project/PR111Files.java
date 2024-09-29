package com.project;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PR111Files {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/pr111";
        gestionarArxius(camiFitxer);
    }

    public static void gestionarArxius(String camiFitxer) {
        try {
            File carp = new File(camiFitxer+"/myFiles");
            if (carp.mkdirs()){
                //System.out.println("Se ha creado la carpeta");
            }else {
                //System.out.println("Ya existe");
            }

            File fix = new File(camiFitxer+"/myFiles/file1.txt");
            if (!fix.exists()) {
                if (fix.createNewFile()) {

                    //System.out.println("Se ha creado fix1");
                } else {
                    //System.out.println("Ya existe");
                }
            }
            File segFix = new File(camiFitxer+"/myFiles/file2.txt");
            if (!segFix.exists()) {
                if (segFix.createNewFile()){
                    //System.out.println("Se ha creado fix2");
                }else {
                    //System.out.println("Ya existe");
                }
            }

            segFix.renameTo(new File(camiFitxer+"/myFiles/renamedFile.txt"));
            String [] listArch = carp.list();
            for (int i = 0; i<listArch.length;i++){
                System.out.println("Els arxius de la carpeta són: "+listArch[i]);
            }
            fix.delete();
            listArch = carp.list();
            for (int i = 0; i<listArch.length;i++){
                System.out.println("Els arxius de la carpeta són: "+listArch[i]);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
