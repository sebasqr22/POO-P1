package com.mycompany.quinela;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
    
    public Mundial buscarMundial(String user){
        Mundial m=null;
        FileInputStream ficheroEntrada=null;
        
        try{
            ficheroEntrada= new FileInputStream("archivos/" + user + "/quiniela.txt");
            ObjectInputStream tuberiaEntrada = new ObjectInputStream(ficheroEntrada);
            m=(Mundial)tuberiaEntrada.readObject();
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        
        System.out.println("MUNDIAL DE FICHERO "+m.getTodos().get(0).getGolLocal());
        return m;
    }
    
    public void guardarMundial(Mundial mundial,ArrayList<Partido> todos,String user){
        
        
        //mundial.setTodosPartidos(todos);
        System.out.println("GUARDANDO...."+mundial.getTodos().get(0).getGolLocal());
        
        FileOutputStream fichero = null;
        try {
            fichero = new FileOutputStream("archivos/" + user + "/quiniela.txt",false);
            
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            tuberia.writeObject(mundial);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fichero.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }
    
    public void asignarMundial(Mundial mundial, String username, String nombre, String password) {
        mundial.crearUsuario(username, nombre, password);
        FileOutputStream fichero = null;
        try {
            fichero = new FileOutputStream("archivos/" + username + "/quiniela.txt");
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            tuberia.writeObject(mundial);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fichero.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }
}