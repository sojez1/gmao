package com.jpstechno.gmao.gmaoback.services;

import java.util.List;

import com.jpstechno.gmao.gmaoback.modeles.Marques;

public interface MarqueServ {

    public List<Marques> getAllMarques();

    public Marques createMarque(Marques marque);

    public Marques getMarqueById(Long id);

    public Marques updateMarque(Long id, Marques marqueDetails);

    public void deleteMarque(Long id);

    public boolean isMarqueExist(String libemarque);

    public List<Marques> getMarqueByNameContaining(String libemarque);

}
