/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quinela;

import com.mycompany.quinela.Equipo;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 *
 * @author sergio
 */
public class Partido {
    
    public Equipo local;
    public Equipo visita;
    private Equipo ganadorPenales;
    public char grupo;
    private int golLocal;
    private JComboBox golLocalCB;
    private JComboBox golVisitaCB;
    private JButton generarResultado;
    private int golVisita;
    private boolean penales;

    public Partido(Equipo local, Equipo visita, char grupo) {
        this.local = local;
        this.visita = visita;
        this.grupo = grupo;
        golLocal=-1;
        golVisita=-1;
        this.local.getPartidos().add(this);
        this.visita.getPartidos().add(this);
    }
    public Partido(Equipo local, Equipo visita) {
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
}
