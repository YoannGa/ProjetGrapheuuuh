/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tran.lou;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author clarisse.lou et lino.tran
 */
public class AuthentificationController implements Initializable {
    
    @FXML
    private TextField loginField;
    
    @FXML
    private PasswordField passwordField;
    
    private Contexte contexte;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    void processCancel(ActionEvent event) {
        loginField.textProperty().set("");
        passwordField.textProperty().set("");
    }
    
    @FXML
    void processOK(ActionEvent event) {
        //System.out.println("Le login est " + contexte.loginUtilisateurConnecteProperty().getValue() + " et le password est " + contexte.passwordUtilisateurConnecteProperty().getValue());
        System.out.println("◘ TENTATIVE DE CONNEXION - login : " + contexte.loginUtilisateurConnecteProperty().getValue() + " password : " + contexte.passwordUtilisateurConnecteProperty().getValue());

        
        Personne p = contexte.identification();
        if(p!=null) {
            System.out.println("◘ Utilisateur connecté !!!!!");
        } else {
            System.out.println("◘ Identifiant et/ou mot de passe incorrect !");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Connection refusée");
            alert.setHeaderText(null);
            alert.setContentText("Identifiant et/ou mot de passe incorrect");

            alert.showAndWait();
        }
    }
    
    public void setContexte(Contexte contexte) {
        this.contexte = contexte;
        contexte.loginUtilisateurConnecteProperty().bind(loginField.textProperty());
        contexte.passwordUtilisateurConnecteProperty().bind(passwordField.textProperty());
    }
    
}
