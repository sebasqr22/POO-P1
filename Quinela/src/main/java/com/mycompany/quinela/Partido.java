/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quinela;

import com.mycompany.quinela.Equipo;
import java.io.Serializable;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 *
 * @author sergio
 */
public class Partido implements Serializable{
    
    public Equipo local;
    public Equipo visita;
    private Equipo ganadorPenales;
    public char grupo;
    private int golLocal;
    private JComboBox<String> golLocalCB;
    private JComboBox<String> golVisitaCB;
    private JButton generarResultado;
    private int golVisita;
    private boolean penales;
    public String date = "";

    public Partido(Equipo local, Equipo visita, char grupo, String date) {
        this.local = local;
        this.visita = visita;
        this.grupo = grupo;
        golLocal=-1;
        golVisita=-1;
        this.local.getPartidos().add(this);
        this.visita.getPartidos().add(this);
        this.date = date;
    }
    public Partido(Equipo local, Equipo visita, String date) {
        this.local = local;
        this.visita = visita;
        golLocal=-1;
        golVisita=-1;
       // this.local.getPartidos().add(this);
        //this.visita.getPartidos().add(this);
    }

    public Equipo getLocal() {
        return local;
    }

    public Equipo getVisita() {
        return visita;
    }

    public JComboBox<String> getGolLocalCB() {
        return golLocalCB;
    }

    public JComboBox<String> getGolVisitaCB() {
        return golVisitaCB;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public void setVisita(Equipo visita) {
        this.visita = visita;
    }
    
    
    
    public int getGolLocal() {
        return golLocal;
    }

    public void setGolLocal(int golLocal) {
        this.golLocal = golLocal;
    }

    public int getGolVisita() {
        return golVisita;
    }

    public void setGolVisita(int golVisita) {
        this.golVisita = golVisita;
    }

    public void setResultadoLocal(JComboBox resultadoLocal) {
        this.golLocalCB = resultadoLocal;
    }

    public void setResultadoVisita(JComboBox resultadoVisita) {
        this.golVisitaCB = resultadoVisita;
    }

    public void setGenerarResultado(JButton generarResultado) {
        this.generarResultado = generarResultado;
    }

    public boolean isPenales() {
        return penales;
    }

    public void setPenales(boolean penales) {
        this.penales = penales;
    }

    public Equipo getGanadorPenales() {
        return ganadorPenales;
    }

    public void setGanadorPenales(Equipo ganadorPenales) {
        this.ganadorPenales = ganadorPenales;
    }
    
    
    public void generarResultado(){
        int probabilidad=(new Random().nextInt(99));
        
        if(probabilidad<80){
            golLocal=(new Random().nextInt(2));
            golVisita=(new Random().nextInt(2));
        }
        else if(probabilidad>=80 && probabilidad<95){
            golLocal=(new Random().nextInt(3, 5));
            golVisita=(new Random().nextInt(3,5));
        }else{
            golLocal=(new Random().nextInt(5, 9));
            golVisita=(new Random().nextInt(5,9));
        }
        System.out.println("PROBABILIDAD: "+probabilidad+"%");
        System.out.println("GOL "+local.pais+": "+golLocal+"  GOL "+visita.pais+": "+golVisita);
        golLocalCB.setSelectedIndex(golLocal);
        golVisitaCB.setSelectedIndex(golVisita);
    }
    
    private int aleatorio(int rango){
        return (new Random().nextInt(0, rango));
    }
    public void generarHeuristica(){
        int rankLocal = aleatorio((int) local.getRanking());
        int rankVisita = aleatorio((int) visita.getRanking());
        System.out.println("RANKINGS randoms: " + local.pais + ": " + rankLocal + "  " + visita.pais + ": " + rankVisita);
        Equipo ganadorRanking = local;

        Equipo ganadorPartido = null;
        if (rankLocal < rankVisita) {
            ganadorRanking = visita;
        }
        System.out.println("GANADOR RANKING: " + ganadorRanking.pais);
        while (ganadorRanking != ganadorPartido) {
            generarResultado();
            if (golLocal - golVisita== 0) {
                continue;
            }
            if (golLocal >= golVisita) {
                ganadorPartido = local;
            } else {
                ganadorPartido = visita;
            }
        }
    }
}
