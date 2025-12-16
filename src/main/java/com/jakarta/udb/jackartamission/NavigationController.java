package com.jakarta.udb.jackartamission;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("navigationController")
@RequestScoped
public class NavigationController implements Serializable {

    public String voirApropos() {
        return "/pages/apropos?faces-redirect=true";
    }

    public String listeLieux() {
        return "/pages/lieu?faces-redirect=true";
    }

    public String ajouterLieu() {
        return "/pages/ajouterLieu?faces-redirect=true";
    }

    public String home() {
        return "/home?faces-redirect=true";
    }
}
