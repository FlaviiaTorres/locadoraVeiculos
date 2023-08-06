package com.github.LocadoraVeiculos.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
public class Condutor {
    
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private int cpf;

    @NotEmpty
    private int idade;

    @NotEmpty
    private String sexo;

    @ManyToOne
    private Carro carro;
}
