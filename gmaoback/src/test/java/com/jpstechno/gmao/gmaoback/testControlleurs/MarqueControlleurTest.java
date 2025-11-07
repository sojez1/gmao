package com.jpstechno.gmao.gmaoback.testControlleurs;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.jpstechno.gmao.gmaoback.ServicesImpl.MarqueImpl;
import com.jpstechno.gmao.gmaoback.controlleurs.MarqueControlleur;
import com.jpstechno.gmao.gmaoback.modeles.Marques;

@WebMvcTest(MarqueControlleur.class)
@DisplayName("Tests du controleur Marque")
public class MarqueControlleurTest extends CommonControlleurTestConfig {

    @MockitoBean
    private MarqueImpl marqueServ;

    @Test
    @DisplayName("Test controleur pour creer une marque")
    public void creerMarqueControlleurTest1() throws Exception {

        // Preparation des donnees pour le test
        Marques marq = new Marques();
        marq.setLibemarque("Kia");
        marq.setId(1L);

        // Utilisation de ObjectMapper pour convertir l'objet en JSON
        String marqJson = new ObjectMapper().writeValueAsString(marq);

        // Mock du service MarqueImpl
        when(marqueServ.createMarque(marq)).thenReturn(marq);

        // Execution du test
        mockMvc.perform(post("/marques/new")
                .with(csrf())
                .contentType("application/json")
                .content(marqJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.libemarque").value("Kia"));
    }

    @Test
    @DisplayName("Test controleur pour afficher toutes les marques ")
    public void listeMarquesControlleurTest() throws Exception {

        // Preparation des donnees pour le test
        Marques marq1 = new Marques();
        marq1.setLibemarque("Kia");
        marq1.setId(1L);

        Marques marq2 = new Marques();
        marq2.setLibemarque("Ford");
        marq2.setId(2L);

        List<Marques> listeMarques = new ArrayList<>();
        listeMarques.add(marq1);
        listeMarques.add(marq2);

        // Mock du service MarqueImpl
        when(marqueServ.getAllMarques()).thenReturn(listeMarques);

        // Execution du test
        mockMvc.perform(get("/marques/all")
                .with(csrf())
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].libemarque").value("Kia"))
                .andExpect(jsonPath("$[1].libemarque").value("Ford"));
    }

}
