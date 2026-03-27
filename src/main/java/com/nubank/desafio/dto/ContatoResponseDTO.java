package com.nubank.desafio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContatoResponseDTO {

    private Long id;
    private String telefone;
    private String email;
    private Long clienteId;

}
