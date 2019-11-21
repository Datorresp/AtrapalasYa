/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author diegoa.torres
 */
public class Scores implements Serializable{
    
    	ArrayList<Usuario> us;
	
	public Scores() {
		us = new ArrayList<>();
	}
	
	public ArrayList<Usuario> getUsuario() {
		return us;
	}

	public void addPlayer(Usuario u) {
		us.add(u);
	}
	

}
