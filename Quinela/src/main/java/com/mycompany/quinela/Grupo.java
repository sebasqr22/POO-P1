/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quinela;

import com.mycompany.quinela.Equipo;
import java.util.ArrayList;

/**
 *
 * @author sergi
 */
public class Grupo {
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
    
}
