package com.antoinepc.travailsessionandroidautomne2020;

public class Infos_Utilisateur {

    String  id_personne,
            courriel,
            mdp,
            nom,
            prenom,
            noTelephone;

    public Infos_Utilisateur() {
        this.id_personne = "-";
        this.courriel = "-";
        this.mdp = "-";
        this.nom = "-";
        this.prenom = "-";
        this.noTelephone = "-";
    }

    public Infos_Utilisateur(String id_personne, String courriel, String mdp, String nom, String prenom, String noTelephone) {
        this.id_personne = id_personne;
        this.courriel = courriel;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.noTelephone = noTelephone;
    }

    public String getId_personne() {
        return id_personne;
    }

    public void setId_personne(String id_personne) {
        this.id_personne = id_personne;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNoTelephone() {
        return noTelephone;
    }

    public void setNoTelephone(String noTelephone) {
        this.noTelephone = noTelephone;
    }
}
