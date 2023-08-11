package com.github.LocadoraVeiculos.repository;
import com.github.LocadoraVeiculos.model.Carro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface carroRepository extends JpaRepository<Carro, Long>{ 
    Carro findByCodigo(long codigo);
	List<Carro> findByMarca(String marca);
}
