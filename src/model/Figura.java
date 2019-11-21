/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;




import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 *
 * @author diegoa.torres
 */
public class Figura extends Thread {
    
    public static final String ARRIBA = "ARRIBA";
    public static final String ABAJO = "ABAJO";
    public static final String IZQUIERDA = "IZQUIERDA";
    public static final String DERECHA = "DERECHA";
    Stage s;
    GraphicsContext gc;
    Image fondo;
    ImageView fondoFinal;
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

    public Figura(double diametro, double posX, double posY, int tiempo, int rebotes, String direccion, boolean parada) {
        this.diametro = diametro;
        this.posX = posX;
        this.posY = posY;
        this.tiempo = tiempo;
        this.rebotes = rebotes;
        this.direccion = direccion;
        this.parada = parada;

    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getRebotes() {
        return rebotes;
    }

    public void setRebotes(int rebotes) {
        this.rebotes = rebotes;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isParada() {
        return parada;
    }

    public void setParada(boolean parada) {
        this.parada = parada;
    }

    public Ellipse getEl() {
        return el;
    }

    public void setEl(Ellipse el) {
        this.el = el;
        el.setLayoutX(posX);
        el.setLayoutY(posY);
        el.setStroke(Color.WHITE);
        el.setFill(Color.YELLOW);
    }
    
    public String direccionContraria(String direction) {
            String dir = "";
            if(direction.equals(ARRIBA)){
                    dir = ABAJO;
            }if(direction.equals(ABAJO)){
                    dir = ARRIBA;
            }if(direction.equals(DERECHA)){
                    dir = IZQUIERDA;
            }if(direction.equals(IZQUIERDA)){
                    dir = DERECHA;
            }
            return dir;
    } 
    
        @Override
    public void run() {
        
        double dir = posX;
        for (double x = posX; true; x+=dir) {
            
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

    }  

    @Override
    public String toString() {
        return "Figura{" + "diametro=" + diametro + ", posX=" + posX + ", posY=" + posY + ", tiempo=" + tiempo + ", rebotes=" + rebotes + ", direccion=" + direccion + ", parada=" + parada + ", el=" + el + '}';
    }
    
    
        
}
