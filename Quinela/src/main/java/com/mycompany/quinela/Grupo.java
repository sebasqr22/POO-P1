/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quinela;

import com.mycompany.quinela.Equipo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author sergi
 */
public class Grupo implements Serializable{
    private char grupo;
    private ArrayList<Equipo> equipos;
    private Equipo[] clasificados=new Equipo[2];

    public Grupo(char grupo, ArrayList<Equipo> equipos) {
        this.grupo = grupo;
        this.equipos=equipos;
        this.clasificados[0]=this.equipos.get(0);
        this.clasificados[1]=this.equipos.get(1);
    }

    public char getGrupo() {
        return grupo;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public Equipo[] getClasificados() {
        return clasificados;
    }
    
    public void ordenar(Partido[] partidos){
        Equipo aux=null;
        Collections.sort(equipos);
        /*for(int i=0; i<equipos.size()-1;i++){
            Equipo e1=equipos.get(i);
            Equipo e2=equipos.get(i+1);
            aux=e1;
            
            //Ordenar por puntos
            Collections.sort(equipos, new Comparator<Equipo>(){
            @Override
            public int compare(Equipo e1,Equipo e2){
                return new Integer(e2.getPuntos()).compareTo(e1.getPuntos());
            }
        });
            
            if (e1.getPuntos() == e2.getPuntos()) {
                System.out.println("PUNTOS IGUALES: "+e1.pais+": "+e1.getPuntos() +" "+e2.pais+": "+ e2.getPuntos());
                int golDiffe1=e1.getGolAFavor() - e1.getGolEnContra();
                int golDiffe2=e2.getGolAFavor() - e2.getGolEnContra();
                
                //ordenar por gol diferencia
                Collections.sort(equipos, new Comparator<Equipo>() {
                    @Override
                    public int compare(Equipo e1, Equipo e2) {
                        return new Integer(golDiffe2).compareTo(golDiffe1);
                    }
                });
                
                if (golDiffe1 == golDiffe2) {
                    
                    //Ordenar por goles anotados
                    Collections.sort(equipos, new Comparator<Equipo>() {
                        @Override
                        public int compare(Equipo e1, Equipo e2) {
                            return new Integer(e2.getGolAFavor()).compareTo(e1.getGolAFavor());
                        }
                    });
                    //Ordenando por ganador del partido entre ellos
                    if(e1.getGolAFavor()==e2.getGolAFavor()){
                        
                        for(int o=0; o<partidos.length;o++){
                            if(partidos[o].local==e1 && partidos[o].visita==e2){
                                if(partidos[o].getGolLocal()<partidos[o].getGolVisita()){
                                    aux=e2;
                                    Collections.swap(equipos, equipos.indexOf(e1), equipos.indexOf(e2));
                                }
                                //Ordenando con aleatorio
                                if(partidos[o].getGolLocal()==partidos[o].getGolVisita()){
                                    int random= new Random().nextInt(2);
                                    //System.out.println("ALEATORIO: "+random+"\n\n");
                                    if(random==0){
                                        Collections.swap(equipos, equipos.indexOf(e1), equipos.indexOf(e2));
                                    }
                                }
                            }
                            if(partidos[o].local==e2 && partidos[o].visita==e1){
                                if(partidos[o].getGolLocal()>partidos[o].getGolVisita()){
                                    aux=e2;
                                    Collections.swap(equipos, equipos.indexOf(e1), equipos.indexOf(e2));
                                }
                                
                                //Ordenando con aleatorio
                                if(partidos[o].getGolLocal()==partidos[o].getGolVisita()){
                                    int random= new Random().nextInt(2);
                                    if(random==0){
                                        Collections.swap(equipos, equipos.indexOf(e1), equipos.indexOf(e2));
                                    }
                                }
                                
                            }
                        }
                        
                        
                       
                        
                    }
                    

                }
            }
            
            
        }*/
        clasificados[0]= equipos.get(0);
        clasificados[1]=equipos.get(1);
        System.out.println("GRUPO: "+grupo);
        for (Equipo equipo : equipos) {
            int goldiff=equipo.getGolAFavor()-equipo.getGolEnContra();
            System.out.println("EUIPO: "+equipo.pais+"\t PUNTOS---> "+equipo.getPuntos()+
                    " \tGOL DIFERENCIA: "+goldiff +
                    "\tGOLES ANOTADOS: "+equipo.getGolAFavor());
            
        }
        System.out.println("CLASIFICADOS: 1: "+clasificados[0].pais +" 2: "+clasificados[1].pais+"\n");
        
        
        
    }
}
