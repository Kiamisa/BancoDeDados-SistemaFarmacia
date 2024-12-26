
# API RESTful em Java com MySQL

## Descrição

Esta é uma API RESTful desenvolvida em Java, que realiza operações de CRUD (Create, Read, Update, Delete) em um banco de dados MySQL. O objetivo do projeto é criar um serviço simples para manipulação de dados de um banco, com todas as operações essenciais de um CRUD, permitindo a interação com o banco de dados via requisições HTTP.

## Funcionalidades

A API oferece as seguintes funcionalidades:

- **Create**: Adiciona um novo registro no banco de dados.
- **Read**: Recupera registros existentes do banco de dados.
- **Update**: Atualiza dados de registros existentes no banco de dados.
- **Delete**: Remove registros do banco de dados.

## Tecnologias Utilizadas

- **Java 17** (ou versão superior)
- **Spring Boot** (framework para desenvolvimento de APIs RESTful)
- **JPA (Java Persistence API)** com **Hibernate** (para a interação com o banco de dados)
- **MySQL** (banco de dados relacional)
- **Maven** (para gerenciamento de dependências)

## Pré-requisitos

Antes de rodar a API, certifique-se de que você tem as seguintes ferramentas instaladas:

- **Java 17** (ou versão superior)
- **Maven**
- **MySQL** (ou outro banco de dados relacional)
- **IDE** (IntelliJ IDEA, Eclipse, etc.)

## Instalação

1. **Clonar o repositório**

   Clone este repositório para o seu ambiente local:

   ```bash
   git clone https://github.com/usuario/repo.git
   cd repo

2. **Configurar o banco de dados**

   Crie um banco de dados no MySQL com o nome desejado. Aqui está um exemplo de como criar um banco de dados:

   ```sql
   CREATE DATABASE api_crud;
   ```

3. **Configurar as credenciais do banco de dados**

   No arquivo `src/main/resources/application.properties`, configure as credenciais do banco de dados:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/api_crud
   spring.datasource.username=root
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   ```

4. **Instalar dependências**

   Execute o comando Maven para baixar as dependências:

   ```bash
   mvn clean install
   ```

5. **Executar a aplicação**

   Para rodar a aplicação, use o comando:

   ```bash
   mvn spring-boot:run
   ```

   A API estará disponível no endereço: `http://localhost:8080`.

## Estrutura do Projeto

```plaintext
.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── exemplo
│   │   │           ├── controller
│   │   │           ├── model
│   │   │           ├── repository
│   │   │           └── service
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── com
│               └── exemplo
│                   └── controller
└── pom.xml
```

- **controller**: Contém as classes responsáveis por gerenciar as requisições HTTP e fazer a comunicação com o serviço.
- **model**: Contém as entidades do banco de dados (modelos).
- **repository**: Interface responsável pela interação com o banco de dados.
- **service**: Contém a lógica de negócios.
- **application.properties**: Arquivo de configuração do Spring Boot, onde estão as configurações do banco de dados.

## Contribuição

Este projeto foi desenvolvido por:

- **Aluno 1** - JULYANNA SILVA CACAU
- **Aluno 2** - NILSON LUCAS PEREIRA ABRANTES
- **Aluno 3** - SILAS HENRIQUE DE MATOS CERQUEIRA

Se você deseja contribuir para o projeto, basta fazer um fork do repositório, realizar as alterações necessárias e enviar um pull request.
