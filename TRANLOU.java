/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tran.lou;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author clarisse.lou
 */
public class TRANLOU extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TRANLOU.class.getResource("authentification.fxml"));
            BorderPane rootLayout = (BorderPane) loader.load();
            
            AuthentificationController controller = loader.getController();
            Contexte contexte = new Contexte(new Personnes());
            controller.setContexte(contexte);
            
            Scene scene = new Scene (rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
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
