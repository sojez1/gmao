package com.jpstechno.gmao.gmaoback.services;

import java.util.List;

import com.jpstechno.gmao.gmaoback.modeles.Materiels;

public interface MaterielServ {

    Materiels insertMateriel(Materiels materiel);

    Materiels updateMateriel(Materiels materiel, long id);

    Materiels findMaterielById(long id);

    Materiels findMaterielByCode(String code);

    List<Materiels> getAllMateriels();

    void deleteMateriel(long id);

}
