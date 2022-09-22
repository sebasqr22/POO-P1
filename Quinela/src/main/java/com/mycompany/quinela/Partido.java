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
    private Equipo local;
    private Equipo visita;
    private char grupo;
    private int golLocal;
    private int golVisita;
    private boolean penales;

    public Partido(Equipo local, Equipo visita, char grupo) {
        this.local = local;
        this.visita = visita;
        this.grupo = grupo;
        golLocal=-1;
        golVisita=-1;
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
