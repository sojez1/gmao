package com.jpstechno.gmao.gmaoback.testunitaires;

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
    @DisplayName("Test de création d'une catégorie")
    @Rollback(false)
    @Order(1)
    public void testCreateCategorie() {
        Categories cat1 = new Categories();
        cat1.setCode("ALM");
        cat1.setDesignation("Alimentation");
        Categories result = categorieDao.save(cat1);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.getId());

    }

}
