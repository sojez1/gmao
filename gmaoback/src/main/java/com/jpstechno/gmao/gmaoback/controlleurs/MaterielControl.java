package com.jpstechno.gmao.gmaoback.controlleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpstechno.gmao.gmaoback.ServicesImpl.CategorieImpl;

import com.jpstechno.gmao.gmaoback.ServicesImpl.MaterielImpl;
import com.jpstechno.gmao.gmaoback.modeles.Categories;
import com.jpstechno.gmao.gmaoback.modeles.Materiels;

@RestController
@RequestMapping("/materiels")
@CrossOrigin("http://localhost:8085")
public class MaterielControl {

    @Autowired
    private CategorieImpl categorieImpl;

    @Autowired
    private MaterielImpl materielImpl;

    @GetMapping("/categories")
    public List<Categories> getAllCategories() {
        return categorieImpl.getAllCategories();
    }

    @PostMapping("/categories")
    public Categories saveNewCategorie(@RequestBody Categories categorie) {
        return categorieImpl.createCategorie(categorie);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategorie(@PathVariable Long id) {
        categorieImpl.deleteCategorie(id);
    }

    @GetMapping("/materiels/add")
    public Materiels ajoutMateriel(@RequestBody Materiels materiel) {
        return materielImpl.insertMateriel(materiel);
    }

    @GetMapping("/materiels/all")
    public List<Materiels> getAllMateriels() {
        return materielImpl.getAllMateriels();
    }

}
