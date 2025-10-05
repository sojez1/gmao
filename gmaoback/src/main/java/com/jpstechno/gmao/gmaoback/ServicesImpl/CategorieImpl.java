package com.jpstechno.gmao.gmaoback.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpstechno.gmao.gmaoback.modeles.Categories;
import com.jpstechno.gmao.gmaoback.repositories.CategorieDao;
import com.jpstechno.gmao.gmaoback.services.CategorieServ;

@Service
public class CategorieImpl implements CategorieServ {

    @Autowired
    private CategorieDao categorieDao;

    @Override
    public Categories createCategorie(Categories categorie) {
        return categorieDao.save(categorie);
    }

    @Override
    public Categories updateCategorie(Categories categorie, Long id) {
        return null;
    }

    @Override
    public void deleteCategorie(Long id) {

    }

    @Override
    public List<Categories> getAllCategories() {
        return null;
    }

    @Override
    public Categories getCategorieById(Long id) {
        return null;
    }

    @Override
    public Categories getCategorieByCode(String code) {
        return null;
    }

    @Override
    public List<Categories> getCategorieByDesignation(String designation) {
        return null;
    }

    @Override
    public boolean CategoriesExistById(Long id) {
        return false;
    }

    @Override
    public boolean CategoriesExistByCode(String code) {
        return false;
    }

}
