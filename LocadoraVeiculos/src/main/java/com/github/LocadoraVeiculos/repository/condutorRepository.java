package com.github.LocadoraVeiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.LocadoraVeiculos.model.Condutor;

@Repository
public interface condutorRepository extends JpaRepository<Condutor, Long>{ 
    
}
