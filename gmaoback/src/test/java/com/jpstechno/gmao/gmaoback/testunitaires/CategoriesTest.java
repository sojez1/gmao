package com.jpstechno.gmao.gmaoback.testunitaires;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.annotation.Rollback;

import com.jpstechno.gmao.gmaoback.modeles.Categories;
import com.jpstechno.gmao.gmaoback.repositories.CategorieDao;

@DataJpaTest
@DisplayName("Tests unitaires pour les catégories")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test") // tell springboot to use application-test.properties file for test
public class CategoriesTest {

    @Autowired
    private CategorieDao categorieDao;

    @Test
    @DisplayName("Test création catégorie 1")
    @Rollback(false)
    @Order(1)
    public void testCreateCategorie1() {
        Categories cat1 = new Categories();
        cat1.setCode("ALM");
        cat1.setDesignation("Alimentation");
        Categories result = categorieDao.save(cat1);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.getId());

    }

    @Test
    @DisplayName("Test création catégorie 2")
    @Rollback(false)
    @Order(2)
    public void testCreateCategorie2() {
        Categories cat2 = new Categories();
        cat2.setCode("SEA");
        cat2.setDesignation("Saisonnier");
        Categories result = categorieDao.save(cat2);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.getId());

    }

    @Test
    @DisplayName("Liste des categories")
    @Rollback(false)
    @Order(3)
    public void listeCategorie() {
        List<Categories> listecat = categorieDao.findAll();
        Assertions.assertNotNull(listecat);
        Assertions.assertEquals(2, listecat.size());
    }

    @Test
    @DisplayName("update catégorie 2")
    @Rollback(false)
    @Order(4)
    public void updateCategorie() {
        // Mise a jour de la catégorie 2
        Categories cat3 = categorieDao.findById(2L).get();
        String oldCode = cat3.getCode();
        cat3.setCode("SAI");
        Categories catUpdated = categorieDao.save(cat3);
        Assertions.assertNotNull(catUpdated);
        Assertions.assertNotEquals(oldCode, catUpdated.getCode());
        Assertions.assertEquals("SAI", catUpdated.getCode());

    }

}
