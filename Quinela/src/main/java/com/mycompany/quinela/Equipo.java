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
    private int puntos=0;
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
    public int getPuntos() {
        return puntos;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public int getGolAFavor() {
        return golAFavor;
    }

    public void sumarGolAFavor(int golAFavor) {
        this.golAFavor = this.golAFavor+ golAFavor;
    }

    public int getGolEnContra() {
        return golEnContra;
    }

    public void sumarGolEnContra(int golEnContra) {
        this.golEnContra = this.golEnContra+golEnContra;
    }
    
    
    
    public void sumarPuntos(int puntos){
        this.puntos=this.puntos+puntos;
    }
    
}
