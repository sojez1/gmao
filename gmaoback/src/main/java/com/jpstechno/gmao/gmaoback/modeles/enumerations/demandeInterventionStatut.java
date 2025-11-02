package com.jpstechno.gmao.gmaoback.modeles.enumerations;

public enum demandeInterventionStatut {
    OUVERT,
    ANNULE, // cancelled by the creator or its manager or collaborator
    REJETE, // rejected by the mainteance team
    EN_COURS, // being processed by the maintenance team
    RESOLU, // issue resolved, waiting for validation by the creator
    CLOTURE // validated and closed by the creator or automatically closed after a period of
            // time

}
