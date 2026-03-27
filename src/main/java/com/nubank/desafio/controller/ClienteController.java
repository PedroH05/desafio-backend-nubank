package com.nubank.desafio.controller;

import com.nubank.desafio.dto.ClientesDTO;
import com.nubank.desafio.dto.ClientesResponseDTO;
import com.nubank.desafio.dto.ContatoResponseDTO;
import com.nubank.desafio.model.Clientes;
import com.nubank.desafio.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClientesService clientesService;

    @PostMapping
    public ResponseEntity<Clientes> criar(@RequestBody ClientesDTO dto) {
        Clientes clienteSalvo = clientesService.salvarClientes(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @GetMapping
    public ResponseEntity<List<ClientesResponseDTO>> listar() {
        return ResponseEntity.ok(clientesService.listarTodos());
    }

    @GetMapping("/{id}/contatos")
    public ResponseEntity<List<ContatoResponseDTO>> listarContatos(@PathVariable long id) {
        return ResponseEntity.ok(clientesService.listarContatosPorCliente(id));
    }

}