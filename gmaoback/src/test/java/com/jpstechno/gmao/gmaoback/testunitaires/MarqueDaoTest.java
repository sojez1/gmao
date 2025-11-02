package com.jpstechno.gmao.gmaoback.testunitaires;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.jpstechno.gmao.gmaoback.modeles.Marques;
import com.jpstechno.gmao.gmaoback.repositories.MarqueDao;

@DataJpaTest
@ActiveProfiles("test")
public class MarqueDaoTest {

    @Autowired
    private MarqueDao marqueDao;

    @Test
    @DisplayName("Test creation marque Toyota")
    public void testcreateMarque1() {
        Marques marque1 = new Marques();
        marque1.setLibemarque("Toyota");

        Marques result = marqueDao.save(marque1);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.getId());
        Assertions.assertEquals("Toyota", result.getLibemarque());

    }

}
