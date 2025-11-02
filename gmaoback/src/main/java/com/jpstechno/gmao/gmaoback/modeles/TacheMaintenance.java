package com.jpstechno.gmao.gmaoback.modeles;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TacheMaintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Modeles modele;

    private String nomTache;

    private long dureeTache; // duree de la tache en minute;

    private String ficheDescriptive; // chemin d'acces au fichier decrivant la realisation de la tache

    private String commentaires;

    // necessaires pour la preparation de la tache

    @OneToMany
    private List<Outils> outillage;

    @OneToMany
    private List<Pieces> listeDesPieces;

}
