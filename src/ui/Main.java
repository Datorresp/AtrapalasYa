package ui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author diegoa.torres
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("Ventana.fxml"));
//        
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//        stage.show();
        
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Ventana.fxml"));
            AnchorPane root = (AnchorPane)loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            VentanaController controller = loader.getController();
            controller.setStage(stage);
            stage.show();
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
