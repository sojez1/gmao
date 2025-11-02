package com.jpstechno.gmao.gmaoback.modeles;

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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Modeles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 30)
    @NaturalId(mutable = true)
    private String libemodele;

    @ManyToOne
    @JoinColumn(name = "marque_fk", nullable = false, updatable = true)
    private Marques marqueFk;

    @OneToMany(mappedBy = "modele", fetch = FetchType.LAZY)
    private List<TacheMaintenance> listeTacheMaintenance;

}
