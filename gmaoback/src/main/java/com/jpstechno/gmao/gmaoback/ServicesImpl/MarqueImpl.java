package com.jpstechno.gmao.gmaoback.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jpstechno.gmao.gmaoback.modeles.Marques;
import com.jpstechno.gmao.gmaoback.repositories.MarqueDao;
import com.jpstechno.gmao.gmaoback.services.MarqueServ;

@Service
public class MarqueImpl implements MarqueServ {

    @Autowired
    private MarqueDao marqueDao;

    @Override
    public List<Marques> getAllMarques() {
        Sort sortByLibeMarqueAsc = Sort.by(Sort.Direction.ASC, "libeMarque");
        return marqueDao.findAll(sortByLibeMarqueAsc);
    }

    @Override
    public Marques createMarque(Marques marque) {
        return marqueDao.save(marque);
    }

    @Override
    public Marques getMarqueById(Long id) {
        return marqueDao.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Pas de marque ayant l<identifiant " + id));
    }

    @Override
    public Marques updateMarque(Long id, Marques marqueDetails) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateMarque'");
    }

    @Override
    public void deleteMarque(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteMarque'");
    }

    @Override
    public boolean isMarqueExist(String libemarque) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isMarqueExist'");
    }

    @Override
    public List<Marques> getMarqueByNameContaining(String libemarque) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMarqueByNameContaining'");
    }

}
