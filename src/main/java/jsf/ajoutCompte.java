/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package jsf;

import ejb.GestionnaireCompte;
import entities.CompteBancaire;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/**
 *
 * @author walid
 */
@Named(value = "ajoutCompte")
@RequestScoped
public class ajoutCompte {

    /**
     * Creates a new instance of ajoutCompte
     */
    public ajoutCompte() {
    }
    @EJB
    private GestionnaireCompte gestionnaireCompte;

    private String nom;
    private int solde;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String creer() {
        gestionnaireCompte.creerCompte(new CompteBancaire(nom, solde));
        return "listeComptes?faces-redirect=true";
    }
}
