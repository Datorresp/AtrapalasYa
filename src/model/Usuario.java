/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author diegoa.torres
 */
public class Usuario implements Serializable {
    
    private int puntaje;
    private String nobre;

    public Usuario(int puntaje, String nobre) {
        this.puntaje = puntaje;
        this.nobre = nobre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getNobre() {
        return nobre;
    }

    public void setNobre(String nobre) {
        this.nobre = nobre;
    }

    @Override
    public String toString() {
        return "Usuario{" + "puntaje=" + puntaje + ", nobre=" + nobre + '}';
    }
    
        
}
