/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package jsf;

import ejb.GestionnaireCompte;
import entities.CompteBancaire;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.io.Serializable;
import jdk.jshell.execution.Util;

/**
 *
 * @author walid
 */
@Named(value = "transfert")
@RequestScoped
public class transfert implements Serializable {

    /**
     * Creates a new instance of transfert
     */
    public transfert() {
    }
    
    @EJB
  private GestionnaireCompte gestionnaireCompte;

  private long idSource;
  private long idDestination;
  private int montant;

    public long getIdSource() {
        return idSource;
    }

    public void setIdSource(long idSource) {
        this.idSource = idSource;
    }

    public long getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(long idDestination) {
        this.idDestination = idDestination;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
  
  public String enregistrer(){
      CompteBancaire source = gestionnaireCompte.findById(idSource);
      
      CompteBancaire destination = gestionnaireCompte.findById(idDestination);
      
      gestionnaireCompte.transferer(source, destination, montant);
      return "listeComptes?faces-redirect=true";
  }
    
}
