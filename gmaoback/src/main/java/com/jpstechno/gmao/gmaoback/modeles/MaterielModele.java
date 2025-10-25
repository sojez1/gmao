package com.jpstechno.gmao.gmaoback.modeles;

import jakarta.persistence.ManyToOne;

public class MaterielModele {

    private long id;

    private String libemodele;

    @ManyToOne
    private Marques marqueFk;

}
