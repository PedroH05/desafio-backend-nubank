package com.nubank.desafio.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;

    private String nome;


    @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL,  orphanRemoval = true)
    @JsonManagedReference
    private List<Contato> contatos = new ArrayList<Contato>();

}
