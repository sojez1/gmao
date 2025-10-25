package com.jpstechno.gmao.gmaoback.modeles;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Column;
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
public class Employes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NaturalId(mutable = true)
    private String matricule;

    @Column(length = 50)
    private String nom;

    @Column(length = 50)
    private String prenoms;

    @NaturalId(mutable = true)
    private String courriel;

    @Column(length = 15)
    private String telephone;

    private String motDePasse;

    private boolean actif = true;

}
