/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author diegoa.torres
 */
public class Scores {
    
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
	
	public String messageScore() {
		String msg = "";
		if (us.size() > 2) {
			Collections.sort(us, new Comparator<Usuario>() {

                            @Override
                            public int compare(Usuario o1, Usuario o2) {
                                return new Integer(o1.getPuntaje()).compareTo(new Integer(o2.getPuntaje()));
                            }

			});
		}
		for (int i = 0; i < us.size(); i++) {
			msg += "\n" + (i + 1) + ") " + us.get(i).getNobre()+ "  -  " + us.get(i).getNobre();
		}
		return msg;
	}
}
