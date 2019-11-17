/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 *
 * @author diegoa.torres
 */
public class Figura extends Thread {
    
    Stage s;
    GraphicsContext gc;
    Image fondo;
    ImageView fondoFinal;
    private int diametro, posX, posY, tiempo, rebotes;
    private String direccion;
    private boolean parada;

    public Figura(Stage s, int diametro, int posX, int posY, int tiempo, int rebotes, String direccion, boolean parada) {
        this.s = s;
        this.diametro = diametro;
        this.posX = posX;
        this.posY = posY;
        this.tiempo = tiempo;
        this.rebotes = rebotes;
        this.direccion = direccion;
        this.parada = parada;
        
        AnchorPane root = new AnchorPane();
        Canvas canvas = new Canvas(s.getWidth(), s.getHeight());
        root.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();        
        fondo = new Image("img/fondo.jpg");
        fondoFinal = new ImageView(fondo);
        fondoFinal.setFitHeight(s.getHeight());
        fondoFinal.setFitWidth(s.getMaxWidth());
        gc.drawImage(fondoFinal.getImage(), 0, 0, s.getHeight(), s.getWidth());
        gc.fillOval(diametro, diametro, posX , posY);
        Scene theScene = new Scene(root, s.getWidth(), s.getHeight());
        s.setScene(theScene);         
    }



    


    @Override
    public void run() {
        
        int dir = posX;
        for (int x = posX; true; x+=dir) {
            
            try {
                
                
                gc.drawImage(fondoFinal.getImage(), 0, 0, s.getWidth(), s.getHeight());
                
                gc.fillOval(x, posY, diametro, diametro);
                Thread.sleep(tiempo);
                if(x>s.getHeight()+90)dir=-10;
                if(x<10)dir=+10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        
    }
    
    

    
    public void mover(){
        
        this.start();
        s.show();
    }    
        
}
