# Sistema de controle de Jobs/Tasks 
Sistema de serviços/Spring boot para controle de Jobs/Tasks. 

## Descrição
Este projeto utiliza o Spring Boot e o banco de dados In-Memory H2. Usando serviços/end-points para diferentes operações como:
GET- `/bancointer/jobs` - Retorna todos os registros de Jobs criados no banco de dados em memória H2.
POST- `/bancointer/jobs` - Inclui os registros de Jobs passados no banco de dados em memória H2.
GET- `/bancointer/jobs/{id}` - Retorna um Job pelo id.
DELETE- `/bancointer/jobs/{id}` - Deleta um Job pelo id.
PUT- `/bancointer/jobs/{id}` - Atualiza/PUT um Job pelo id.
GET- `/bancointer/tasks` - Retorna todos os registros de Tasks criados no banco de dados em memória H2.
POST- `/bancointer/tasks` - Inclui os registros de Task passados no banco de dados em memória H2.
GET- `/bancointer/tasks/{id}` - Retorna um Task pelo id.
DELETE- `/bancointer/tasks/{id}` - Deleta um Task pelo id.
PUT- `/bancointer/tasks/{id}` - Atualiza/PUT um Task pelo id.

## Tecnologias utilizadas
- Spring Boot
- Spring Configuration
- Spring REST Controller
- Spring JPA
- H2
- Development Tools

## Compilation Command
- `mvn clean install`  
