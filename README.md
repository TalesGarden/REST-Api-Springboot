# REST-Api-Springboot, implementations of explorer design patterns in the Lab "Exploring Design Patterns in Practice with Java". Using the Spring Framework
## Rest API example with Spring Boot, JPA, Swagger UI, OPEN API,  Hibernate

 - API's that register students, schools and the relationship between them.


## tools used
- FeignClient
- h2database
- springdoc-openapi-ui
- JPA 
- Maven

## Design Pattern
 - Facade
 - Strategy
 - Singleton
 - Repository
 
 ## Rest API created - Endpoint

### Escola-rest-controller
**GET**
/escolas/{id}

**PUT**
/escolas/{id}

**DELETE**
/escolas/{id}

**GET**
/escolas

**POST**
/escolas

### cliente-rest-controller
**GET**
/alunos/{id}

**PUT**
/alunos/{id}

**DELETE**
/alunos/{id}

**GET**
/alunos

**POST**
/alunos

### aluno-escola-controller

**GET**
/alunos-escolas/{id}

**PUT**
/alunos-escolas/{id}

DELETE
/alunos-escolas/{id}

**GET**
/alunos-escolas

**POST**
/alunos-escolas

