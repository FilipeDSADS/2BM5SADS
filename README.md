# 2BM5SADS

- Programação Avançada.
- Filipe Augusto dos Santos de Siqueira.
- RA: 23234462-2.

--------------------
# Projeto JWT com Spring Boot
Este projeto é uma API REST com autenticação JWT utilizando Spring Boot e Spring Security. Possui controle de acesso baseado em roles (ADMIN e USER). O banco de dados utilizado é o H2, um banco em memória para facilitar testes.

A aplicação vai subir em http://localhost:8080.

Endpoints Principais:  

Método	Endpoint	Descrição	Acesso

POST	/auth/login	Login e obtenção do token	Público

GET	/admin/users	Listar usuários	Somente ADMIN

GET	/user/profile	Perfil do usuário logado	USER e ADMIN

Testando com Postman ou Curl

Login e obter token JWT

Request:

POST http://localhost:8080/auth/login

Content-Type: application/json
{
  "login": "admin",
  "password": "senha123"
}


Response:

{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}

Adicione no header da requisição:

Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...

Exemplo usando curl para buscar perfil:

curl -H "Authorization: Bearer SEU_TOKEN_AQUI" http://localhost:8080/user/profile

Banco de dados H2

O banco é configurado para ser em memória, para testes e desenvolvimento.

Console Web disponível para consulta:

Acessar:

http://localhost:8080/h2-console
Configurações para login no console H2:

JDBC URL: jdbc:h2:mem:testdb
User: sa
Password: (deixe vazio)


