/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tran.lou;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author clarisse.lou
 */
public class Personnes {
    private final ObservableList<Personne> liste;
    
    public Personnes(){
        this.liste = FXCollections.observableArrayList();
        this.liste.add(new Personne("clarisse.lou", "clarisse", "clarisse lou", "adr1", "adr2", "tel1", "tel2"));
        this.liste.add(new Personne("lino.tran", "lino", "lino tran", "adr1", "adr2", "tel1", "tel2"));
    }
    
    public Personnes(List<Personne> liste){
        this.liste = FXCollections.observableArrayList(liste);
    }

    public Personne identification(String login, String password) {
        for (Personne p: liste) 
            if (p.checkPassword(login, password)) return p;
        return null;
    }
    
}
