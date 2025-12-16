/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jakarta.udb.jackartamission.bean;

/**
 *
 * @author eliel
 */
import com.jakarta.udb.jackartamission.business.LieuEntrepriseBean;
import com.jakarta.udb.jackartamission.entities.Lieu;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped; // Changement ici
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Named("lieuBean")
@ViewScoped // Permet de conserver le bean pendant la vue
public class LieuBean implements Serializable {

    private String nom;
    private String description;
    private double latitude;
    private double longitude;
    private int idLieu;

    @Inject
    private LieuEntrepriseBean lieuEntrepriseBean;

    // Getters et Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public int getIdLieu() { return idLieu; }
    public void setIdLieu(int idLieu) { this.idLieu = idLieu; }

    public List<Lieu> getLieux() {
        return lieuEntrepriseBean.listerTousLesLieux();
    }

    // Ajouter un lieu
    public void ajouterLieu() {
        if (nom != null && !nom.isEmpty()) {
            lieuEntrepriseBean.ajouterLieuEntreprise(nom, description, latitude, longitude);
            resetForm();
        }
    }

    // Ajouter ou modifier selon l'id
    public void enregistrerLieu() {
        if (idLieu == 0) {
            ajouterLieu();
        } else {
            modifierLieu();
        }
    }

    // Préparer le formulaire pour modification
    public void preparerModification(Lieu lieu) {
        this.idLieu = lieu.getId();
        this.nom = lieu.getNom();
        this.description = lieu.getDescription();
        this.latitude = lieu.getLatitude();
        this.longitude = lieu.getLongitude();
    }

    // Modifier un lieu existant
    public void modifierLieu() {
        Lieu lieu = lieuEntrepriseBean.trouverLieuParId(idLieu);
        if (lieu != null) {
            lieu.setNom(nom);
            lieu.setDescription(description);
            lieu.setLatitude(latitude);
            lieu.setLongitude(longitude);
            lieuEntrepriseBean.modifierLieu(lieu);
            resetForm();
        }
    }

    // Supprimer un lieu
    public void supprimerLieu(int id) {
        lieuEntrepriseBean.supprimerLieu(id);
    }

    // Réinitialiser le formulaire
    public void resetForm() {
        nom = "";
        description = "";
        latitude = 0;
        longitude = 0;
        idLieu = 0;
    }
}
