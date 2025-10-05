package com.jpstechno.gmao.gmaoback.services;

import java.util.List;

import com.jpstechno.gmao.gmaoback.modeles.Categories;

public interface CategorieServ {

    Categories createCategorie(Categories categorie);

    Categories updateCategorie(Categories categorie, Long id);

    void deleteCategorie(Long id);

    List<Categories> getAllCategories();

    Categories getCategorieById(Long id);

    Categories getCategorieByCode(String code);

    List<Categories> getCategorieByDesignation(String designation);

    boolean CategoriesExistById(Long id);

    boolean CategoriesExistByCode(String code);

}
