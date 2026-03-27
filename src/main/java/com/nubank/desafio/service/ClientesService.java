package com.nubank.desafio.service;


import com.nubank.desafio.dto.ClientesDTO;
import com.nubank.desafio.dto.ClientesResponseDTO;
import com.nubank.desafio.dto.ContatoResponseDTO;
import com.nubank.desafio.model.Clientes;
import com.nubank.desafio.model.Contato;
import com.nubank.desafio.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    //(POST/clientes)
    public Clientes salvarClientes(ClientesDTO dto) {
        Clientes clientes = new Clientes();
        clientes.setNome(dto.getNome());

        //verifica se recebeu os contatos
        if(dto.getContatos() != null && dto.getContatos().size() > 0) {
            List<Contato> contatos = dto.getContatos().stream().map(c -> {
                Contato contato = new Contato();
                contato.setTelefone(c.getTelefone());
                contato.setEmail(c.getEmail());
                contato.setClientes(clientes);
                return contato;
            }).collect(Collectors.toList());
            clientes.setContatos(contatos);
        }
        return clientesRepository.save(clientes);
    }


    public List<ClientesResponseDTO> listarTodos(){
        return clientesRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<ContatoResponseDTO> listarContatosPorCliente(Long clienteId){
        Clientes clientes = clientesRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente nao encontrado"));
        return clientes.getContatos().stream().map(c ->{
            ContatoResponseDTO dto = new ContatoResponseDTO();
            dto.setId(c.getId());
            dto.setTelefone(c.getTelefone());
            dto.setEmail(c.getEmail());
            return dto;
        }).collect(Collectors.toList());
    }

    private ClientesResponseDTO toDTO(Clientes clientes) {
        ClientesResponseDTO dto = new ClientesResponseDTO();
        dto.setId(clientes.getId());
        dto.setNome(clientes.getNome());

        List<ContatoResponseDTO> contatos = dto.getContatos().stream().map(c -> {
            ContatoResponseDTO contatoDTO = new ContatoResponseDTO();
            contatoDTO.setId(c.getId());
            contatoDTO.setTelefone(c.getTelefone());
            contatoDTO.setEmail(c.getEmail());
            return contatoDTO;
        }).collect(Collectors.toList());
        dto.setContatos(contatos);

        return dto;
    }
}