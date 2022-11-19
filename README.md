# CISS

Foi proposto criar um CRUD com informações de funcionários em uma empresa.

Pode listar um novo funcionário, cadastrar, deletar e atualizar. Traz também uma lista de todos os funcionários cadastrados.

Alguns requisitos para o cadastro do funcionário foram implementados, como nome, sobrenome, email e nispis.

Swagger configurado para teste

Banco de dados PostgreSQL foi usado para os registros

## Passos a serem executados na máquina 
Após acessar a pasta local do projeto,

Comandos para compilar maven e executar:
 - mvn clean install -DskipTests
 - cd target
 - java -jar .\funcionarios-0.0.1-SNAPSHOT.jar

## Swagger
http://localhost:8080/swagger-ui/index.html#

## exemplo de endpoint
POST /v1/funcionario/

## JSON request Body
```json
{
  "nome": "string",
  "sobrenome": "string",
  "email": "string@gmail.com",
  "nisPis": 0
}
```




