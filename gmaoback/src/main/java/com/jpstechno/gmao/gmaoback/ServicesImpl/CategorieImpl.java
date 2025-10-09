package com.jpstechno.gmao.gmaoback.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
        Categories existingCategorie = categorieDao.findById(id).orElse(null);
        if (existingCategorie != null) {
            existingCategorie.setCode(categorie.getCode());
            existingCategorie.setDesignation(categorie.getDesignation());
            return categorieDao.save(existingCategorie);
        } else {
            return null;
        }
    }

    @Override
    public void deleteCategorie(Long id) {
        try {
            categorieDao.deleteById(id);
        } catch (Exception e) {
            System.out.println("Erreur lors de la suppression de la catégorie : " + e.getMessage());
        }
    }

    @Override
    public List<Categories> getAllCategories() {
        Sort sortByDesignation = Sort.by(Sort.Direction.ASC, "designation");
        return categorieDao.findAll(sortByDesignation);
    }

    @Override
    public Categories getCategorieById(Long id) {
        return categorieDao.findById(id).orElse(null);
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
        return categorieDao.existsById(id);
    }

    @Override
    public boolean CategoriesExistByCode(String code) {
        return false;
    }

}
