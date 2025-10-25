package com.jpstechno.gmao.gmaoback.modeles;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DemandeIntervention {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Materiels materielFk;

    private NiveauPriorite priorite; // to indicate the level of priority

    private String description; // to describe the issue you have

    private MaterielStatut statut; // to indicate if materiel is running bad, available, or fully immobiliser

    private Employes creePar;

    private LocalDateTime dateCreation;

}