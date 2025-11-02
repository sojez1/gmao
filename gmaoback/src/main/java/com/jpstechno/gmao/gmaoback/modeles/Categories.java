package com.jpstechno.gmao.gmaoback.modeles;

import java.util.List;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId(mutable = true)
    private String code;

    @Column(length = 50, unique = true, name = "designaition", nullable = false)
    private String designation;

    @OneToMany(mappedBy = "categorie", fetch = FetchType.LAZY)
    private List<Materiels> listeMateriel;

}
