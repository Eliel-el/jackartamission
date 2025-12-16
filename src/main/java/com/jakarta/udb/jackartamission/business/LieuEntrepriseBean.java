/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jakarta.udb.jackartamission.business;

/**
 *
 * @author eliel
 */
import com.jakarta.udb.jackartamission.entities.Lieu;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
@LocalBean
public class LieuEntrepriseBean {

    @PersistenceContext
    private EntityManager em;

    // Ajouter un lieu
    public void ajouterLieuEntreprise(String nom, String description, double latitude, double longitude) {
        Lieu lieu = new Lieu(nom, description, latitude, longitude);
        em.persist(lieu);
    }

    // Lister tous les lieux
    public List<Lieu> listerTousLesLieux() {
        return em.createQuery("SELECT l FROM Lieu l ORDER BY l.id", Lieu.class)
                 .getResultList();
    }

    // Trouver un lieu par ID
    public Lieu trouverLieuParId(int id) {
        return em.find(Lieu.class, id);
    }

    // Supprimer un lieu
    public void supprimerLieu(int id) {
        Lieu lieu = em.find(Lieu.class, id);
        if (lieu != null) {
            em.remove(lieu);
        }
    }

    // Modifier un lieu
    public void modifierLieu(Lieu lieu) {
        em.merge(lieu);
    }
}