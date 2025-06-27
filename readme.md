# API de Usuários e Produtos (Monolito com Stack Profissional)

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3.1-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)
![Docker](https://img.shields.io/badge/Docker-gray?logo=docker)

Este projeto é uma API RESTful monolítica desenvolvida como parte de um estudo aprofundado sobre a construção de aplicações back-end robustas, seguras e escaláveis. O objetivo é demonstrar o domínio sobre todo o ciclo de vida de uma API profissional, desde a arquitetura e desenvolvimento até a automação de testes e deploy.

---

## 📋 Funcionalidades

- [x] CRUD (Create, Read) de Usuários
- [ ] CRUD completo de Produtos
- [ ] Autenticação de usuários com JWT (JSON Web Tokens)
- [ ] Sistema de cache com Redis para otimização de performance
- [ ] Tratamento de exceções padronizado
- [ ] Containerização da aplicação com Docker
- [ ] Pipeline de Integração e Entrega Contínua (CI/CD) com GitHub Actions

---

## 🛠️ Tecnologias Utilizadas

A seguir, as principais tecnologias e ferramentas utilizadas na construção do projeto:

* **Back-end:**
  * **Java 17:** Versão LTS mais recente do Java.
  * **Spring Boot 3:** Framework principal para a construção da API.
  * **Spring Web:** Para a criação de endpoints RESTful.
  * **Spring Data JPA:** Para a persistência de dados de forma simplificada.
  * **Spring Security:** Para a implementação da camada de segurança e autenticação.
  * **Lombok:** Para a redução de código boilerplate.
  * **Maven:** Gerenciador de dependências e build do projeto.

* **Banco de Dados:**
  * **PostgreSQL:** Banco de dados relacional para persistência principal.

* **Cache:**
  * **Redis:** Banco de dados em memória para caching de alta performance.

* **DevOps:**
  * **Docker & Docker Compose:** Para containerização da aplicação e dos serviços.
  * **GitHub Actions:** Para automação de CI/CD (build e testes automatizados).

---

## 🚀 Como Executar o Projeto

Siga os passos abaixo para executar o projeto localmente.

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:
* [Java 17 (JDK)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* [Maven](https://maven.apache.org/download.cgi)
* [PostgreSQL](https://www.postgresql.org/download/)
* [Docker](https://www.docker.com/products/docker-desktop/) (para rodar o banco e o Redis de forma mais fácil)

### Rodando o Back-end

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/seu-usuario/userproductapi.git](https://github.com/seu-usuario/userproductapi.git)
   ```

2. **Configure o `application.properties`:**
   Navegue até `src/main/resources/` e configure o arquivo `application.properties` com suas credenciais do PostgreSQL.
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/userproduct_db
   spring.datasource.username=seu-usuario
   spring.datasource.password=sua-senha
   ```

3. **Execute a aplicação:**
   Na raiz do projeto, execute o seguinte comando:
   ```bash
   ./mvnw spring-boot:run
   ```

A API estará disponível em `http://localhost:8080`.

---

## Endpoints da API

Aqui estão os endpoints disponíveis até o momento.

### Usuários (`/api/users`)

* #### Criar um novo usuário
  * **Método:** `POST`
  * **URL:** `/api/users`
  * **Body (Exemplo):**
    ```json
    {
      "name": "Nome do Usuário",
      "email": "usuario@email.com",
      "password": "senha123"
    }
    ```
  * **Resposta de Sucesso (201 Created):**
    ```json
    {
        "id": 1,
        "name": "Nome do Usuário",
        "email": "usuario@email.com"
    }
    ```

* #### Buscar um usuário por ID
  * **Método:** `GET`
  * **URL:** `/api/users/{id}`
  * **Resposta de Sucesso (200 OK):**
    ```json
    {
        "id": 1,
        "name": "Nome do Usuário",
        "email": "usuario@email.com"
    }
    ```

---

## 👨‍💻 Autor

**Pedro Viena**

* GitHub: [Seu GitHub](https://github.com/pedroviena)
* LinkedIn: [Seu LinkedIn](https://www.linkedin.com/in/pedro-arian-viena)