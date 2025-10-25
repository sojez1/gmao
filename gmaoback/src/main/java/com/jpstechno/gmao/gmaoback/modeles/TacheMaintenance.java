package com.jpstechno.gmao.gmaoback.modeles;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class TacheMaintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private MaterielModele modele;

    private String nomTache;

    private long dureeTache; // duree de la tache en minute;

    private String commentaires;

    // necessaires pour la preparation de la tache

    private List<Outils> outillage;
    private List<Pieces> listeDesPieces;
    private String ficheDescriptive; // chemin d'acces au fichier decrivant la realisation de la tache

}
