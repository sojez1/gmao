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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import com.jpstechno.gmao.gmaoback.modeles.Marques;
import com.jpstechno.gmao.gmaoback.repositories.MarqueDao;

@DataJpaTest
@ActiveProfiles("test")
@DisplayName("Tests unitaires pour les marques")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MarqueDaoTest {

    @Autowired
    private MarqueDao marqueDao;

    @Test
    @DisplayName("Test creation marque Toyota")
    @Order(1)
    @Rollback(false)
    public void testcreateMarque1() {
        Marques marque1 = new Marques();
        marque1.setLibemarque("Toyota");

        Marques result = marqueDao.save(marque1);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.getId());
        Assertions.assertEquals("Toyota", result.getLibemarque());

    }

    @Test
    @DisplayName("Test creation marque Hyndai")
    @Order(2)
    @Rollback(false)
    public void testcreateMarque2() {
        Marques marque2 = new Marques();
        marque2.setLibemarque("Hyundai");

        Marques result = marqueDao.save(marque2);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.getId());
        Assertions.assertEquals("Hyundai", result.getLibemarque());

    }

    @Test
    @DisplayName("Test selection toutes les marques")
    @Order(3)
    @Rollback(false)
    public void testGetAllMarques() {
        List<Marques> marques = marqueDao.findAll();
        Assertions.assertNotNull(marques);
        Assertions.assertEquals(2, marques.size());
    }

}
