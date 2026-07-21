# 🚀 API REST com Spring Boot

Este projeto foi desenvolvido com o objetivo de praticar os principais conceitos do **Spring Boot** e da construção de APIs REST. A aplicação demonstra como estruturar uma API utilizando a arquitetura em camadas, aplicando recursos como Injeção de Dependência, gerenciamento de Beans, mapeamento de rotas e tratamento de requisições HTTP.

## 📚 Objetivo

O objetivo deste projeto é consolidar os fundamentos do desenvolvimento de APIs com Spring Boot, compreendendo como o framework gerencia componentes, realiza o mapeamento de endpoints e organiza a comunicação entre as diferentes camadas da aplicação.

---

# 🛠️ Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web
- Maven
- Lombok

---

# 📁 Estrutura do projeto

```text
src
└── main
    ├── java
    │   └── com.ana.demo
    │       ├── configuration
    │       │   └── HelloConfiguration.java
    │       ├── controller
    │       │   └── HelloWordController.java
    │       ├── service
    │       │   └── HelloWordService.java
    │       ├── user
    │       │   └── User.java
    │       └── DemoApplication.java
    │
    └── resources
        └── application.properties
```

---

# ⚙️ Configuração da aplicação

As configurações principais da aplicação estão no arquivo `application.properties`.

```properties
spring.application.name=demo
server.port=3000
```

- `spring.application.name`: define o nome da aplicação no contexto do Spring Boot.
- `server.port`: altera a porta padrão da aplicação de **8080** para **3000**.

Após iniciar o projeto, a API estará disponível em:

```text
http://localhost:3000
```

---

# 🧩 Conceitos do Spring Boot utilizados

## `@RestController`

Define a classe responsável por receber requisições HTTP e retornar respostas da API.

---

## `@RequestMapping`

Define a rota base do controller.

```java
@RequestMapping("/hello-word")
```

Todos os endpoints do controller terão como prefixo:

```text
/hello-word
```

---

## `@GetMapping`

Mapeia requisições do tipo **GET**.

### Endpoint

```http
GET /hello-word
```

### Resposta

```text
Hello, World!
```

---

## `@PostMapping`

Mapeia requisições do tipo **POST**.

Neste projeto o endpoint recebe simultaneamente:

- Um parâmetro pela URL (`@PathVariable`)
- Um parâmetro de consulta (`@RequestParam`)
- Um objeto JSON (`@RequestBody`)

---

## `@PathVariable`

Captura valores enviados diretamente na URL.

Exemplo:

```http
POST /hello-word/1
```

O valor `1` será recebido pelo método através do parâmetro:

```java
@PathVariable("id")
String id
```

---

## `@RequestParam`

Captura parâmetros enviados na Query String da URL.

Exemplo:

```http
POST /hello-word/1?filter=admin
```

No controller:

```java
@RequestParam(value = "filter", defaultValue = "nenhum")
String filter
```

- Caso o parâmetro seja informado:

```text
filter = admin
```

- Caso não seja informado:

```text
filter = nenhum
```

Neste projeto, o parâmetro possui finalidade demonstrativa para exemplificar o funcionamento do `@RequestParam`.

---

## `@RequestBody`

Converte automaticamente um JSON enviado pelo cliente em um objeto Java.

Exemplo:

```json
{
  "name": "Ana",
  "email": "ana@email.com"
}
```

O Spring converte esse JSON em uma instância da classe `User`.

---

## `@Service`

Representa a camada de regras de negócio da aplicação.

```java
@Service
public class HelloWordService {
}
```

O Spring cria automaticamente uma instância dessa classe para ser utilizada pelo controller.

---

## `@Autowired`

Realiza a Injeção de Dependência entre os componentes da aplicação.

```java
@Autowired
private HelloWordService helloWordService;
```

Dessa forma, não é necessário instanciar a classe manualmente utilizando `new`.

---

## `@Configuration`

Indica que a classe contém configurações da aplicação.

```java
@Configuration
public class HelloConfiguration {
}
```

---

## `@Bean`

Define objetos que serão gerenciados pelo Spring.

```java
@Bean
public String helloWorld() {
    return "HelloWorld";
}
```

Esse objeto passa a fazer parte do contexto da aplicação e pode ser injetado em outros componentes quando necessário.

---

## Lombok

Para reduzir código repetitivo, o projeto utiliza Lombok.

Anotações utilizadas:

- `@Getter`
- `@Setter`
- `@AllArgsConstructor`

> **Observação:** Para projetos reais, também é recomendado utilizar `@NoArgsConstructor` em classes que serão desserializadas pelo Spring a partir de um JSON.

---

# ▶️ Como executar o projeto

### Clone o repositório

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

### Acesse a pasta do projeto

```bash
cd demo
```

### Execute a aplicação

Pelo Maven:

```bash
./mvnw spring-boot:run
```

Ou execute diretamente a classe:

```text
DemoApplication.java
```

A aplicação ficará disponível em:

```text
http://localhost:3000
```

---

# 🧪 Testando a API

## GET

### Requisição

```http
GET http://localhost:3000/hello-word
```

### Resposta

```text
Hello, World!
```

---

## POST

### Requisição

```http
POST http://localhost:3000/hello-word/1?filter=admin
```

### Body

```json
{
  "name": "Ana",
  "email": "ana@email.com"
}
```

### Resposta

```text
Hello World Ana, id: 1
```

---

# 📖 Fluxo da requisição

```text
Cliente
   │
   ▼
HelloWordController
   │
   ▼
HelloWordService
   │
   ▼
Resposta da API
```

1. O cliente envia uma requisição HTTP.
2. O `HelloWordController` recebe a requisição.
3. O Spring converte automaticamente o JSON em um objeto `User`.
4. O Controller chama o `HelloWordService`.
5. O Service executa a lógica da aplicação.
6. O Controller retorna a resposta ao cliente.

---

# 📚 Conceitos praticados

Durante o desenvolvimento deste projeto foram praticados os seguintes conceitos:

- APIs REST
- Spring Boot
- Injeção de Dependência (Dependency Injection)
- Inversão de Controle (IoC)
- Beans
- Component Scan
- Controllers
- Services
- `@RequestBody`
- `@PathVariable`
- `@RequestParam`
- `@Configuration`
- `@Bean`
- Lombok
- Organização em camadas (Layered Architecture)

---

# 🚀 Próximos passos

Como evolução deste projeto, os próximos objetivos são:

- Implementar um CRUD completo
- Integrar com banco de dados (MySQL ou PostgreSQL)
- Utilizar Spring Data JPA e Hibernate
- Criar DTOs
- Adicionar validações com Bean Validation
- Implementar tratamento global de exceções
- Documentar a API com Swagger/OpenAPI
- Desenvolver testes unitários e de integração
- Implementar autenticação e autorização com Spring Security

---

# 👩‍💻 Autora

Desenvolvido por **Ana Flávia Covre** como projeto de estudos para aprofundamento em **Java** e **Spring Boot**, com foco na construção de APIs REST e boas práticas de desenvolvimento Back-end.
