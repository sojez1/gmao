package com.jpstechno.gmao.gmaoback.controlleurs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaterielControl {

    @GetMapping("/materiels")
    public String getAllMateriels() {
        return "Liste de tous les matériels";
    }

}
