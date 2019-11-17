package ui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import javafx.stage.Stage;
import model.Figura;
import model.PathException;
import model.Scores;
import model.Usuario;


/**
 *
 * @author diegoa.torres
 */
public class VentanaController implements Initializable {

    private int nivel, rebotes;
    private boolean parado, cargado;
    Figura figura;
    Usuario u;
    Scores s;
    ArrayList<Figura>figuras;
//  private Stage stage;
    List <String> firstFile;
    
    
     //_____________________________//
    //              FXML           //
   //_____________________________//
    
    @FXML
    private Label lastfile;
    
    @FXML
    private Button files;
    
    @FXML
    private AnchorPane paneJuego;
    
    @FXML
    private void CargarJuego(){
     
        cargado = false;
        parado = true;
        rebotes = 0;
        paneJuego.getChildren().clear();
        figuras = new ArrayList<>();
        String filePath = "";
        BufferedReader br = null;
        FileReader fr = null;        

        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Word Files", firstFile));
        File f = fc.showOpenDialog(null);
        
        if (f != null) {
            filePath = f.getAbsolutePath();
            System.out.println("Acrchivo Seleccionado: " + f.getAbsolutePath());
            try {
                
                fr = new FileReader(filePath);
                br = new BufferedReader(fr);

                String lineaActual;   
                
                while ((lineaActual = br.readLine()) != null) {

                        if (lineaActual.charAt(0) != '#') {
                                if (lineaActual.length() > 1) {
                                        String[] parts = lineaActual.split(" ");
                                        double diarmetro = Double.parseDouble(parts[0]);
                                        double x = Double.parseDouble(parts[1]);
                                        double y = Double.parseDouble(parts[2]);
                                        int espera = Integer.parseInt(parts[3]);
                                        String direction = parts[4];
                                        int rebotes = Integer.parseInt(parts[5]);
                                        boolean parado = Boolean.parseBoolean(parts[5]);
                                        figura = new Figura(diarmetro, x, y, espera, rebotes, direction, parado);
                                        figuras.add(figura);
                                } else {
                                        nivel = Integer.parseInt(lineaActual);
                                }
                        }
                }                
                
            } catch (IOException e) {
                
                e.printStackTrace();
            }finally{
                
                try {

                    if (br != null)
                            br.close();

                    if (fr != null)
                            fr.close();                    
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
            }
            
            cargado = true;
        }
    }
    
    //PRUEBA DE FILECHOOSER
    @FXML
    private void seleccionarArchivo() throws IOException, PathException{
        
        
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Word Files", firstFile));
        File f = fc.showOpenDialog(null);
        
        if (f != null) {
            lastfile = new Label("Acrchivo Seleccionado");
            System.out.println("Acrchivo Seleccionado: " + f.getAbsolutePath());
//            lastfile.setText("Acrchivo Seleccionado: " + f.getAbsolutePath());
            //j.loadTextFile(f.getAbsolutePath());
        }
        
    }
//    
//    @FXML
//    
//    private void mejoresPuntajes() throws IOException, ClassNotFoundException{
// 
//        j = new juego(0);
//        FileChooser fc = new FileChooser();
//        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Word Files", firstFile));
//        File f = fc.showOpenDialog(null);
//        
//        if (f != null) {
//            lastfile = new Label("Acrchivo Seleccionado");
//            System.out.println("Acrchivo Seleccionado: " + f.getAbsolutePath());
//            j.mejoresPuntajes(f.getAbsolutePath());
//        }
//        
//    }
    
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

//    public void setStage(Stage stage) {
//        this.stage = stage;
//    }
//    
     
    
}
