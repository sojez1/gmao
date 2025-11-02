package com.jpstechno.gmao.gmaoback.modeles;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Materiels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId(mutable = true)
    private String codeInterne;

    @ManyToOne
    @JoinColumn(name = "categorie_fk", nullable = false)
    private Categories categorie;

    @Column(nullable = false)
    private String appelation;

    @ManyToOne(optional = false)
    private Modeles modele;

    private String numeroSerie;

    private String description;

    private String etat;

    private LocalDate EnregistreLe = LocalDate.now();

    @OneToMany(mappedBy = "materielEnPanne", fetch = FetchType.LAZY)
    private List<DemandeIntervention> listeDemandeIntervention;

}
