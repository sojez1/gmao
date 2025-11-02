package com.jpstechno.gmao.gmaoback.modeles;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.jpstechno.gmao.gmaoback.modeles.enumerations.MaterielStatut;
import com.jpstechno.gmao.gmaoback.modeles.enumerations.NiveauPriorite;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private long numDI;

    @ManyToOne
    private Materiels materielEnPanne;

    private String description; // to describe the issue reported

    @Enumerated(EnumType.STRING)
    private NiveauPriorite priorite; // to indicate the level of priority

    @Enumerated(EnumType.STRING)
    private MaterielStatut statut; // to indicate if the material is running fine, degraded or out of service.

    @ManyToOne
    private Employes DIcreePar;

    @CreationTimestamp
    private LocalDateTime dateCreation;

    @OneToMany(mappedBy = "numDI")
    private List<MaintenanceCurative> maintenceCurative;

}