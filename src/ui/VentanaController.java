package ui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import javafx.stage.Stage;
import model.Figura;
import model.PathException;
import model.juego;

/**
 *
 * @author diegoa.torres
 */
public class VentanaController implements Initializable {

    
    private Stage stage;
    private juego j;
    List <String> firstFile;
    
    @FXML
    private Label lastfile;
    
    @FXML
    private Button files;

    public VentanaController() {
        
        j = new juego(0);
    }
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        j = new juego(0);
//        //j.getFig()[0].mover();
//        //j.getFig()[1].mover();
//        //j.getFig()[2].mover();
//        //j.getFig()[3].mover();
//        Figura f1 = new Figura(stage, 100, 0, 0, 50, 50, null, true);
//        Figura f2 = new Figura(stage, 109, 10, 010, 50, 0, null, true);
//        Figura f3 = new Figura(stage, 70, 50, 50, 50, 0, null, true);
//        f1.start();
//        f3.start();
//        f2.start();
        
    }
    
    //PRUEBA DE FILECHOOSER
    @FXML
    private void seleccionarArchivo() throws IOException, PathException{
        
        j = new juego(0);
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Word Files", firstFile));
        File f = fc.showOpenDialog(null);
        
        if (f != null) {
            lastfile = new Label("Acrchivo Seleccionado");
            System.out.println("Acrchivo Seleccionado: " + f.getAbsolutePath());
//            lastfile.setText("Acrchivo Seleccionado: " + f.getAbsolutePath());
            j.loadTextFile(f.getAbsolutePath());
        }
        
    }
    
    @FXML
    
    private void mejoresPuntajes() throws IOException, ClassNotFoundException{
 
        j = new juego(0);
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Word Files", firstFile));
        File f = fc.showOpenDialog(null);
        
        if (f != null) {
            lastfile = new Label("Acrchivo Seleccionado");
            System.out.println("Acrchivo Seleccionado: " + f.getAbsolutePath());
            j.mejoresPuntajes(f.getAbsolutePath());
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        firstFile = new ArrayList<>();  
        firstFile.add("*.doc");
        firstFile.add("*.docx");
        firstFile.add("*.DOC");
        firstFile.add("*.DOCX");
        firstFile.add("*.txt");
        firstFile.add("*.RTF");
    }  

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
     
    
}
