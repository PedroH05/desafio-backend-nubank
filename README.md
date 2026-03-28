Esse projeto é a minha resolução à um teste técnico criado pela NUBANK.

## Introdução
Construa uma API REST para gerenciamento de clientes e seus contatos. Cada cliente pode ter um ou mais contatos associados.

Requisitos Técnicos
A aplicação deve conter:

- Cadastro de Cliente: POST /clientes
- Cadastro de Contato associado a um cliente existente: POST /contatos
- Listagem de todos os clientes com seus contatos: GET /clientes
- Listagem de contatos de um cliente específico: GET /clientes/{id}/contatos
- Uso do Spring Boot + Spring Data JPA
- Banco de Dados PostgreSQL
- Entidades Cliente e Contato com relacionamento @OneToMany / @ManyToOne

## Requisitos de Código
Esperamos que o código siga boas práticas de desenvolvimento, incluindo:

- Separação de responsabilidades (controller, service, repository)
- Uso de DTOs para entrada e saída de dados
- Tratamento adequado de erros
- Uso de Lombok

## Diferenciais (Não obrigatórios)
- Uso de Docker para subir o PostgreSQL
- Testes automatizados
- Documentação com Swagger

## Tecnologias Usadas
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)  ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-%236DB33F.svg?style=for-the-badge&logo=spring-boot&logoColor=white) ![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![PostgreSQL](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)  ![Lombok](https://img.shields.io/badge/lombok-%23BC4521.svg?style=for-the-badge&logoColor=white) ![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
