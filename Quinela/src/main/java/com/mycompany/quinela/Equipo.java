/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quinela;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class Equipo implements Serializable{
    public String pais;
    private char grupo;
    private double ranking;
    private ArrayList<Partido> partidos;
    private int puntos;
    private int golAFavor;
    private int golEnContra;

    public Equipo(String pais, double ranking) {
        this.pais = pais;
        this.ranking = ranking;
        this.partidos=new ArrayList<Partido>();
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public char getGrupo() {
        return grupo;
    }

    public void setGrupo(char grupo) {
        this.grupo = grupo;
    }

    public double getRanking() {
        return ranking;
    } 

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }
    
}
