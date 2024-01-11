# Spring Boot API for Role-Based Authentication

## Technologies used

### Java Spring Boot 
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
<br>**Dependencies**
  <ul>
    <li>Spring Data JPA</li>
    <li>Validation</li>
    <li>Lombok</li>
    <li>Spring Web</li>
    <li>PostgreSQL Driver</li>
    <li>Spring Boot Dev Tools</li>
    <li>Spring Security</li>
  </ul>
  
### PostgresSQL Database
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

### JWT - JSON Web Tokens - Authentication via tokens
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

## What does the API do?

This API provides endpoints for user authentication and authorization, using JWT tokens. The available endpoints are:

* **/auth/login** - Method POST - authenticates the user and generates a JWT token.
* **/auth/register** - Method POST - register new user.
* **/auth/buscar** - Method GET - lists all users.
* **/product** - POST and GET.


## Recommendations for testing

To test the API, it is recommended to use **Postman** or **Insomnia**. Here are some examples of requests:

**/auth/login**

