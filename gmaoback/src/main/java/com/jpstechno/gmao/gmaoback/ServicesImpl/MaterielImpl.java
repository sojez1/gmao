package com.jpstechno.gmao.gmaoback.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jpstechno.gmao.gmaoback.modeles.Materiels;
import com.jpstechno.gmao.gmaoback.repositories.MaterielDao;
import com.jpstechno.gmao.gmaoback.services.MaterielServ;

@Service
public class MaterielImpl implements MaterielServ {

    @Autowired
    private MaterielDao materielDao;

    @Override
    public Materiels insertMateriel(Materiels materiel) {
        return materielDao.save(materiel);
    }

    @Override
    public Materiels updateMateriel(Materiels materiel, long id) {
        Materiels oldValue = materielDao.findById(id).get();
        oldValue.setAppelation(materiel.getAppelation());
        oldValue.setCategorie(materiel.getCategorie());
        oldValue.setDescription(materiel.getDescription());
        return materielDao.save(oldValue);
    }

    @Override
    public Materiels findMaterielById(long id) {
        return materielDao.findById(id).get();
    }

    @Override
    public Materiels findMaterielByCode(String code) {
        return null;
    }

    @Override
    public List<Materiels> getAllMateriels() {
        Sort trie = Sort.by(Sort.Direction.ASC, "Appelation");
        return materielDao.findAll(trie);
    }

    @Override
    public void deleteMateriel(long id) {
        materielDao.deleteById(id);
    }

}
