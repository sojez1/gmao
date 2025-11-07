package com.jpstechno.gmao.gmaoback.controlleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpstechno.gmao.gmaoback.ServicesImpl.MarqueImpl;
import com.jpstechno.gmao.gmaoback.modeles.Marques;

@RestController
@RequestMapping("/marques")
public class MarqueControlleur {

    @Autowired
    private MarqueImpl marqueImpl;

    @PostMapping("/new")
    public ResponseEntity<Marques> newMarque(@RequestBody Marques marque) {
        Marques newMarq = marqueImpl.createMarque(marque);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMarq);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Marques>> getAllMarques() {
        List<Marques> allMarques = marqueImpl.getAllMarques();
        return ResponseEntity.ok(allMarques);
    }

}
