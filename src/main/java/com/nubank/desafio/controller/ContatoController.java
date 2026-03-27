package com.nubank.desafio.controller;

import com.nubank.desafio.dto.ContatoDTO;
import com.nubank.desafio.model.Clientes;
import com.nubank.desafio.model.Contato;
import com.nubank.desafio.repository.ClientesRepository;
import com.nubank.desafio.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/Contatos")
@RestController
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private ClientesRepository clientesRepository;

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody ContatoDTO dto) {

        Optional<Clientes> clientesOpt = clientesRepository.findById(dto.getClienteId());
        if(clientesOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CLIENTE NAO ENCONTRADO");
        }

        Contato contato = new Contato();
        contato.setTelefone(dto.getTelefone());
        contato.setEmail(dto.getEmail());
        contato.setClientes(clientesOpt.get());

        contatoRepository.save(contato);

        return ResponseEntity.status(HttpStatus.CREATED).body(contato);
    }
}
