package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{
    @Query("select o from Operation o where o.compte.codeCompte=:x order by o.dateOperation desc")
	public Page<Operation> listOperation(String codeCpte,Pageable pageable);
}