package com.jpstechno.gmao.gmaoback.testunitaires;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.jpstechno.gmao.gmaoback.modeles.Categories;
import com.jpstechno.gmao.gmaoback.modeles.Materiels;
import com.jpstechno.gmao.gmaoback.repositories.MaterielDao;

@DataJpaTest
@ActiveProfiles("test")
public class MaterielsRepositoryTest {

    @Autowired
    private MaterielDao mateRepo;

    @Test
    void testAllMateriels() {
        List<Materiels> mesMateriels = mateRepo.findAll();
        assertEquals(1, mesMateriels.size());
    }

    @Test
    @DisplayName("Ajout materiel 1")
    void insertMateriels1() {
        Categories cat1 = new Categories();
        cat1.setCode("GP01");
        cat1.setDesignation("Grue portuaire");
        Materiels mat1 = new Materiels();
        mat1.setAppelation("engins de levage STS PPM");
        mat1.setCategorie(cat1);
        mat1.setCodeInterne("PPM-0125");
        mat1.setNumeroSerie("0012124244445");
        mat1.setEtat("ok");
        Materiels savedMateriel = mateRepo.save(mat1);

        assertNotNull(savedMateriel);
        assertEquals("PPM-0125", savedMateriel.getCodeInterne());

    }

}
