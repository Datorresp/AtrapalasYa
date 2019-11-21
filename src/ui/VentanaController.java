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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Figura;
import model.PathException;
import model.Scores;
import model.Usuario;
import thread.ChoqueDevueta;
import thread.CircleMove;



/**
 *
 * @author diegoa.torres
 */
public class VentanaController implements Initializable {

    private int nivel, rebotes;
    private boolean parado, cargado;
    private Stage st;
    Figura figura;
    Usuario u;
    Scores s = new Scores();
    ArrayList<Figura>figuras;
//  private Stage stage;
    List <String> firstFile;
    
    
     //_____________________________//
    //              FXML           //
   //_____________________________//
    
    @FXML
    private Label lbRebotes = new Label();
    
    @FXML
    private Button inicio = new Button();
    
    @FXML
    private Label lbMensajes = new Label();
    
    @FXML
    private AnchorPane paneJuego;
    
    @FXML
    private void CargarJuego(){
     
        cargado = false;
        parado = true;
        rebotes = 0;           
        figuras = new ArrayList<Figura>();
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
    
    
    @FXML
    void GuardarJuego(ActionEvent event) {
            String nombre = JOptionPane.showInputDialog("Ingrese su nombre: ");
            int score = Integer.parseInt(lbRebotes.getText());
            u = new Usuario(score, nombre);
            s.addPlayer(u);
    }
    
    @FXML
    void StartGame(ActionEvent event) {
            if (cargado) {
                
                //figuras.clear();
                System.out.println("1");
                    for (int i = 0; i < figuras.size(); i++) {
                        System.out.println("2");
                        System.out.println(figuras.get(i).toString());
//                        parado = false;                   
//                        CircleMove movePac = new CircleMove(st, this, figuras.get(i));
//                        ChoqueDevueta threadColision = new ChoqueDevueta(this);                   
//                        movePac.setDaemon(true);
//                        threadColision.setDaemon(true);
//                        movePac.start();
//                        threadColision.start();
//                        
                        //paneJuego.getChildren().add(figuras.get(i).getEl());
                    }

            } else {
                    lbMensajes.setText("Se debe cargar una partida antes de jugar");
                    
            }
    }
      
    

    
//    public void ColisionBordes() {
//
//            double distancia = 0;
//            double cx1 = 0;
//            double cy1 = 0;
//            double r1 = 0;
//            double cx2 = 0;
//            double cy2 = 0;
//            double r2 = 0;
//        for (int i = 0; i < figuras.size(); i++) {
//            for (int j = 0; j < figuras.size(); j++) {
//                if (figuras.get(i) != figuras.get(j)) {
//                    if (figuras.get(i).getEl().getCenterX() > figuras.get(j).getEl().getCenterX()&& figuras.get(i).getEl().getCenterY() > figuras.get(j).getEl().getCenterY()) {
//                        cx1 = figuras.get(i).getEl().getLayoutX();
//                        cy1 = figuras.get(i).getEl().getLayoutY();
//                        r1 = figuras.get(i).getEl().getRadiusX();
//                        cx2 = figuras.get(j).getEl().getLayoutX();
//                        cy2 = figuras.get(j).getEl().getLayoutY();
//                        r2 = figuras.get(j).getEl().getRadiusX();
//                    } else {
//                        cx1 = figuras.get(j).getEl().getLayoutX();
//                        cy1 = figuras.get(j).getEl().getLayoutY();
//                        r1 = figuras.get(j).getEl().getRadiusX();
//                        cx2 = figuras.get(i).getEl().getLayoutX();
//                        cy2 = figuras.get(i).getEl().getLayoutY();
//                        r2 = figuras.get(i).getEl().getRadiusX();
//                    }
//                    distancia = Math.sqrt((cx1 - cx2) * (cx1 - cx2) + (cy1 - cy2) * (cy1 - cy2));
//                    if (distancia < r1 + r2) {
//                        if (figuras.get(i).getDireccion().equals(Figura.ARRIBA)) {
//                                figuras.get(i).getEl().setLayoutY(figuras.get(i).getEl().getLayoutY()
//                                                - (figuras.get(i).getEl().getRadiusY() + 6));
//                        }
//                        if (figuras.get(i).getDireccion().equals(Figura.ABAJO)) {
//                                figuras.get(i).getEl().setLayoutY(figuras.get(i).getEl().getLayoutY()
//                                                + (figuras.get(i).getEl().getRadiusY() + 6));
//                        }
//                        if (figuras.get(i).getDireccion().equals(Figura.DERECHA)) {
//                                figuras.get(i).getEl().setLayoutX(figuras.get(i).getEl().getLayoutX()
//                                                + (figuras.get(i).getEl().getRadiusX() + 6));
//                        }
//                        if (figuras.get(i).getDireccion().equals(Figura.IZQUIERDA)) {
//                                figuras.get(i).getEl().setLayoutX(figuras.get(i).getEl().getLayoutX()
//                                                - (figuras.get(i).getEl().getRadiusX() + 6));
//                        }
//                        if (figuras.get(j).getDireccion().equals(Figura.ARRIBA)) {
//                                figuras.get(j).getEl().setLayoutY(figuras.get(i).getEl().getLayoutY()
//                                                - (figuras.get(i).getEl().getRadiusY() + 6));
//                        }
//                        if (figuras.get(j).getDireccion().equals(Figura.ABAJO)) {
//                                figuras.get(j).getEl().setLayoutY(figuras.get(i).getEl().getLayoutY()
//                                                + (figuras.get(i).getEl().getRadiusY() + 6));
//                        }
//                        if (figuras.get(j).getDireccion().equals(Figura.DERECHA)) {
//                                figuras.get(j).getEl().setLayoutX(figuras.get(i).getEl().getLayoutX()
//                                                + (figuras.get(i).getEl().getRadiusX() + 6));
//                        }
//                        if (figuras.get(j).getDireccion().equals(Figura.IZQUIERDA)) {
//                                figuras.get(j).getEl().setLayoutX(figuras.get(i).getEl().getLayoutX()
//                                                - (figuras.get(i).getEl().getRadiusX() + 6));
//                        }
//                        figuras.get(i).setDireccion(figuras.get(i).direccionContraria(figuras.get(i).getDireccion()));
//                        figuras.get(j).setDireccion(figuras.get(j).direccionContraria(figuras.get(j).getDireccion()));
//                    }
//                }
//            }
//        }
//    } 
    
    public boolean isParado() {
        return parado;
    }

    public ArrayList<Figura> getFiguras() {
        return figuras;
    }

    public int getNivel() {
        return nivel;
    }
    

    
    
    @FXML
    void Exit(ActionEvent event) {
            System.exit(0);
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

    public void setS(Stage s) {
        this.st = s;
    }
     
    
}
