package com.jpstechno.gmao.gmaoback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpstechno.gmao.gmaoback.modeles.Employes;

public interface EmployeDao extends JpaRepository<Employes, Long> {

}
