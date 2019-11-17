/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



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
public class Figura  {
    
//    Stage s;
//    GraphicsContext gc;
//    Image fondo;
//    ImageView fondoFinal;
    private double diametro, posX, posY;
    private int tiempo, rebotes;
    private String direccion;
    private boolean parada;
    private Ellipse el;
    
    

//    public Figura(Stage s, int diametro, int posX, int posY, int tiempo, int rebotes, String direccion, boolean parada) {
//        this.s = s;
//        this.diametro = diametro;
//        this.posX = posX;
//        this.posY = posY;
//        this.tiempo = tiempo;
//        this.rebotes = rebotes;
//        this.direccion = direccion;
//        this.parada = parada;
//        
//        AnchorPane root = new AnchorPane();
//        Canvas canvas = new Canvas(s.getWidth(), s.getHeight());
//        root.getChildren().add(canvas);
//        gc = canvas.getGraphicsContext2D();        
//        fondo = new Image("img/fondo.jpg");
//        fondoFinal = new ImageView(fondo);
//        fondoFinal.setFitHeight(s.getHeight());
//        fondoFinal.setFitWidth(s.getMaxWidth());
//        gc.drawImage(fondoFinal.getImage(), 0, 0, s.getHeight(), s.getWidth());
//        gc.fillOval(diametro, diametro, posX , posY);
//        Scene theScene = new Scene(root, s.getWidth(), s.getHeight());
//        s.setScene(theScene); 
//        
//    }

        
}
