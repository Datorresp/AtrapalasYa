/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.stage.Stage;


public class juego {
    
    private int nivel;
    private ArrayList <Usuario> u;
    private Stage s;
    private Figura [] fig;

    public juego(int nivel) {
        this.nivel = nivel;
        
        fig = new Figura[4];

    }

    public Figura[] getFig() {
        return fig;
        
    }
    
    
    
    public void loadTextFile( String path)throws IOException, PathException{

        int i = 0;
        String sep = ",";
        
        if (path != null) {

            File f = new File (path);
            FileReader fr = new  FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            

            String line = br.readLine();

            while (line != null && i <= 4) {

                if (line.charAt(0) != '#' && line.charAt(0) != '0' && line.charAt(0) != '1' && line.charAt(0) != '2') {

                    String[] parts = line.split(sep);
                    String diametro = parts[0];
                    String posX = parts[1];
                    String posY = parts[2];
                    String tiempo = parts[3];
                    String direccion = parts[4];
                    String rebotes = parts[5];
                    String parada = parts[6];
                    Figura fi = new Figura(s, Integer.parseInt(diametro), Integer.parseInt(posX), Integer.parseInt(posY), Integer.parseInt(tiempo), Integer.parseInt(rebotes), direccion, Boolean.valueOf(parada));
                    fig[i] = fi;
                    line = br.readLine();
                     i++;
                }
            }
        } else{
            
            
            throw new PathException("Falta el archivo");
        }       
    } 
    
    public void mejoresPuntajes(String fichero) throws IOException, ClassNotFoundException{
        
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));        
        Object aux = ois.readObject();
        
        while (aux!=null){
            
        if (aux instanceof Usuario)
            
            System.out.println(aux);
        
        aux = ois.readObject();
        }
        
        ois.close();
    }

    
}
