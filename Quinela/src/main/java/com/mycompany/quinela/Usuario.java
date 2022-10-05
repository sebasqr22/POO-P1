/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quinela;

import java.io.Serializable;

/**
 *
 * @author sergio
 */
public class Usuario implements Serializable{
    private String username;
    private String nombre;
    private String password;
    private float ranking=0;

    public Usuario(String username, String nombre, String password) {
        this.username = username;
        this.nombre = nombre;
        this.password = password;
    }

    public String getId() {
        return username;
    }

    public void setId(String id) {
        this.username = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public float getRanking() {
        return ranking;
    }

    public void setRanking(float ranking) {
        this.ranking = ranking;
    }
   
    
}
