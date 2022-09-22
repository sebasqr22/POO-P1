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
    private ArrayList<Equipo> clasificados;

    public Grupo(char grupo, ArrayList<Equipo> equipos) {
        this.grupo = grupo;
        this.equipos=equipos;
        System.out.println("GRUPO CREADO: "+grupo);
        for (Equipo equipo : equipos) {
            System.out.println(equipo.getPais()+" RANKING: "+equipo.getRanking());
        }
    }
}
