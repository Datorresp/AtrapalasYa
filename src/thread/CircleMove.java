package thread;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Figura;
import ui.VentanaController;

public class CircleMove extends Thread {

    VentanaController vc;
    Figura f;
        
    Stage s;
    GraphicsContext gc;
    Image fondo;
    ImageView fondoFinal;        

    public CircleMove(Stage s, VentanaController vc, Figura f) {

        this.vc = vc;
        this.f = f;

        AnchorPane root = new AnchorPane();
        Canvas canvas = new Canvas(s.getWidth(), s.getHeight());
        root.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();        
        fondo = new Image("img/fondo.jpg");
        fondoFinal = new ImageView(fondo);
        fondoFinal.setFitHeight(s.getHeight());
        fondoFinal.setFitWidth(s.getMaxWidth());
        gc.drawImage(fondoFinal.getImage(), 0, 0, s.getHeight(), s.getWidth());
        gc.fillOval(f.getPosX(),f.getPosY() , f.getDiametro() , f.getDiametro());
        Scene theScene = new Scene(root, s.getWidth(), s.getHeight());
        s.setScene(theScene);
    }

    @Override
    public void run() {
        double dir = f.getPosX();
        for (double x = f.getPosX(); true; x+=dir) {
            
            try {
                
                
                gc.drawImage(fondoFinal.getImage(), 0, 0, s.getWidth(), s.getHeight());
                
                gc.fillOval(x, f.getPosY(), f.getDiametro(), f.getDiametro());
                Thread.sleep(f.getTiempo());
                if(x>s.getHeight()+90)dir=-10;
                if(x<10)dir=+10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "CircleMove{" + "f=" + f + '}';
    }
    
    

}