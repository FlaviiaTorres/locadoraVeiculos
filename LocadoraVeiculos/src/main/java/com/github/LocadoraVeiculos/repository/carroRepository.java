package com.github.LocadoraVeiculos.repository;
import com.github.LocadoraVeiculos.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface carroRepository extends JpaRepository<Carro, Long>{ 
    
}
