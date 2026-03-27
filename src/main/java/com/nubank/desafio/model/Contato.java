package com.nubank.desafio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String telefone;

    private String email;

    @ManyToOne
    //Ligação das tabelas(JoinColumn)
    @JoinColumn(name = "cliente_id")
    //para não ficar em looping (JsonBack...)
    @JsonBackReference
    private Clientes clientes;

}
