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
    
    public String archivosEn(String ruta){
        File f = new File(ruta);
        if(f.exists()){
            File[] archivos = f.listFiles();
            String todos = "";
            for(File i: archivos){
                if(!i.getName().equals("administrativo") && !i.getName().contains(".")){
                    todos += i.getName() + "-";
                }
            }
            System.out.println(todos.substring(0, todos.length()-1));
            return todos.substring(0, todos.length()-1);
        }
        else{
            return "1";
        }
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
    
    public Mundial buscarMundial(String user, boolean superUser){
        Mundial m=null;
        FileInputStream ficheroEntrada=null;
        
        try{
            if(!superUser)
                ficheroEntrada= new FileInputStream("archivos/" + user + "/quiniela.txt");
            else{
                System.out.println("USER NORMAL");
                ficheroEntrada= new FileInputStream("archivos/administrativo/reales.txt");
            }
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
    
    public void guardarMundial(Mundial mundial,ArrayList<Partido> todos,String user, boolean superUser){
        
        
        FileOutputStream fichero = null;
        try {
            if(!superUser)
                fichero = new FileOutputStream("archivos/" + user + "/quiniela.txt",false);
           
            else{
                fichero = new FileOutputStream("archivos/administrativo/reales.txt",false);
            }
            
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
        FileOutputStream fichero2 = null;
        try {
           
             fichero = new FileOutputStream("archivos/" + username + "/quiniela.txt");
             fichero2 = new FileOutputStream("archivos/" + username + "/ranking.txt");
           
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            ObjectOutputStream tuberia2 = new ObjectOutputStream(fichero2);
            escribir("archivos/" + username + "/ranking.txt", "0");
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