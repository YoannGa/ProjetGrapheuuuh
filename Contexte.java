/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tran.lou;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author clarisse.lou
 */
public class Contexte {
    
    private Personnes personnes;
    private StringProperty loginUtilsateurConnecte;
    private StringProperty passwordUtilisateurConnecte;
    
    public Contexte(Personnes personnes) {
        this.personnes = personnes;
        loginUtilsateurConnecte = new SimpleStringProperty();
        passwordUtilisateurConnecte = new SimpleStringProperty();
        
    }

    public Personnes getPersonnes() {
        return personnes;
    }
    
    public StringProperty loginUtilisateurConnecteProperty() {
        return loginUtilsateurConnecte;
    }

    public String getLoginUtilisateurConnecte() {
        return loginUtilsateurConnecte.getValue();
    }

    public StringProperty passwordUtilisateurConnecteProperty() {
        return passwordUtilisateurConnecte;
    }

    public Personne identification() {
        return personnes.identification(loginUtilsateurConnecte.getValue(), passwordUtilisateurConnecte.getValue());
    }
    
}
