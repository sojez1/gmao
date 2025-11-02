package com.jpstechno.gmao.gmaoback.modeles;

import java.time.LocalDate;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("Preventive")
public class MaintenancePreventive extends Intervention {

    @ManyToOne
    private Materiels materiel;

    private LocalDate realiseLe = LocalDate.now();

}
