package com.jpstechno.gmao.gmaoback.modeles;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Corrective")
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceCurative extends Intervention {

    @ManyToOne
    private DemandeIntervention numDI;

    public DemandeIntervention getNumDI() {
        return numDI;
    }

    public void setNumDI(DemandeIntervention numDI) {
        this.numDI = numDI;
    }

}
