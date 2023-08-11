package com.github.LocadoraVeiculos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.LocadoraVeiculos.model.Carro;
import com.github.LocadoraVeiculos.model.Condutor;

@Repository
public interface condutorRepository extends JpaRepository<Condutor, Long>{ 
    Iterable<Condutor>findByCarro(Carro carro);
	Condutor findById(long id);
	List<Condutor>findByNomeCondutor(String nome);
    
}
