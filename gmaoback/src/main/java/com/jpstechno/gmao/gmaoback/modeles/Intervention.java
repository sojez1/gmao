package com.jpstechno.gmao.gmaoback.modeles;

import java.time.LocalDate;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class Intervention {

    protected long interventionId;
    protected Materiels materiel;
    protected LocalDate dateIntervention;
}
