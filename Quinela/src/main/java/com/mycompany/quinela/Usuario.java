/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quinela;

/**
 *
 * @author sergio
 */
public class Usuario {
    private String id;
    private String nombre;
    private String password;

    public Usuario(String id, String nombre, String password) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
   
    
}
