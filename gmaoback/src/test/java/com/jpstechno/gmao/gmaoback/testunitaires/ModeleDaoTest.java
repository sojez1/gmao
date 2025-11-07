package com.jpstechno.gmao.gmaoback.testunitaires;

import org.h2.engine.Mode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.jpstechno.gmao.gmaoback.modeles.Modeles;
import com.jpstechno.gmao.gmaoback.repositories.ModeleDao;

@DataJpaTest
@DisplayName("Tests unitaires pour les modèles")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ModeleDaoTest {

    @Autowired
    private ModeleDao modeleDao;

    @Test
    @DisplayName("Test de creation du moelele Highlander XLE")
    @Order(1)
    public void creerModele1() {
        Modeles modele1 = new Modeles();
        modele1.setLibemodele("Highlander xle");
        modele1.setMarqueFk(null);

        Modeles result = modeleDao.save(modele1);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.getId());

    }

}
