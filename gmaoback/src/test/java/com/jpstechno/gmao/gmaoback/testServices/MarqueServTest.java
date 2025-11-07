package com.jpstechno.gmao.gmaoback.testServices;

import static org.mockito.Mockito.when;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpstechno.gmao.gmaoback.ServicesImpl.MarqueImpl;
import com.jpstechno.gmao.gmaoback.modeles.Marques;
import com.jpstechno.gmao.gmaoback.repositories.MarqueDao;
import com.jpstechno.gmao.gmaoback.services.MarqueServ;

@SpringBootTest
@DisplayName("Tests unitaires pour le service Marque")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MarqueServTest {

    @Mock
    private MarqueDao marqueDao;

    @InjectMocks
    private MarqueImpl marqueServ;

    @Test
    @DisplayName("Test unitaire du service Marque")
    @Order(1)
    public void createMarqueServiceTest() {
        Marques marq1 = new Marques();
        marq1.setLibemarque("Honda");

        when(marqueDao.save(marq1)).thenReturn(marq1);
        Marques marqueCreated = marqueServ.createMarque(marq1);

        Assertions.assertNotNull(marqueCreated);
        Assertions.assertEquals("Honda", marqueCreated.getLibemarque());
    }

}
