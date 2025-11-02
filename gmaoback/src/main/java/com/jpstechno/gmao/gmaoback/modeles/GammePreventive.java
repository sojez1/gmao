package com.jpstechno.gmao.gmaoback.modeles;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GammePreventive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int frequenceHeure;

    private Date frequenceJours;

    @OneToMany(mappedBy = "")
    private List<TacheMaintenance> listeTaches;
}
