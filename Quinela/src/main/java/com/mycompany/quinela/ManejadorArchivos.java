package com.mycompany.quinela;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ManejadorArchivos {

    ManejadorArchivos(){

    }

    public String leer(String ruta){
        try{
            File archivo = new File(ruta);
            Scanner lector = new Scanner(archivo);
            StringBuilder data = new StringBuilder();

            while(lector.hasNextLine()){
                String parte = lector.nextLine();
                data.append(parte);
            }
            return data.toString();
        }
        catch (FileNotFoundException e){
            return "1";
        }

    }


    public int escribir(String ruta, String data){
        try{
            FileWriter escritor = new FileWriter(ruta);
            escritor.write(data);
            escritor.close();
            return 0;
        }
        catch (IOException e){
            return 1;
        }
    }


    public int crear_carpeta(String ruta){
        File archivo = new File(ruta);
        if(archivo.mkdir()){
            return 0;
        }
        else{
            return 1;
        }
    }
}