
package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Pacman.fxml"));
                BorderPane root = (BorderPane)loader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
                VentanaController vc = loader.getController();
                vc.setS(stage);
		stage.setMaximized(true);
		stage.show();
	}

}