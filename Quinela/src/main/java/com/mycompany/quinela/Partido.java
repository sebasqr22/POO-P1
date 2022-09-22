/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quinela;

import com.mycompany.quinela.Equipo;
import java.util.Random;

/**
 *
 * @author sergio
 */
public class Partido {
    

    public Equipo local;
    public Equipo visita;
    public char grupo;
    private int golLocal;
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
    
    public void generarResultado(){
        golLocal=(new Random().nextInt(8));
        golVisita=(new Random().nextInt(8));
    }
}
