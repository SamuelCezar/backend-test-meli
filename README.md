# 📦 Backend Test - Samuel Chagas

## 📖 Sobre o projeto

Este projeto é um backend em Java 21 com Spring Boot que expõe uma API RESTful para consulta de itens, simulando a página de produto do Mercado Livre.  
Os dados são armazenados localmente em um arquivo JSON, sem uso de banco de dados real.

A API está documentada via Swagger/OpenAPI e fornece endpoints para buscar detalhes de itens por ID.

---

## 🚀 Tecnologias utilizadas

- Java 21
- Spring Boot 3.2.5
- Spring Web
- Lombok
- SpringDoc OpenAPI 2.3.0
- Gradle 8+

---

## ⚙️ Como rodar

Veja o arquivo [run.md](run.md) para instruções completas sobre como compilar e executar o projeto.

---

## 📖 Endpoints disponíveis

| Método | Endpoint           | Descrição                          | Respostas             |
|--------|--------------------|----------------------------------|-----------------------|
| GET    | `/api/items/{id}`  | Busca detalhes de um item pelo ID | 200 OK / 404 Not Found |

---

## 📄 Exemplo de resposta para 200 OK

```json
{
  "id": "1",
  "title": "Notebook Dell Inspiron",
  "description": "Notebook Dell com processador i7, 16GB RAM, 512GB SSD",
  "price": 4500.0,
  "paymentMethods": ["Credit Card", "Boleto", "Pix"],
  "seller": {
    "name": "Loja Exemplo",
    "rating": 4.5,
    "reviewsCount": 120
  },
  "stock": 15
}
```
## 📄 Exemplo de resposta para 404 Not Found

```json
{
  "timestamp": "2025-07-02T15:00:00",
  "status": 404,
  "error": "Item Not Found",
  "message": "Item com id 123 não encontrado"
}
```
---

## 📂 Estrutura de dados
#### Os dados dos itens a serem retornados na api estão armazenados em:
src/main/resources/data/items.json
#### Este arquivo simula a base de dados local e pode ser editado para adicionar ou modificar itens.

---

## 📖 Documentação da API
### A documentação interativa está disponível em:

http://localhost:8080/swagger-ui/index.html

---
## Contato:
#### Samuel Chagas
#### Linkedin: https://www.linkedin.com/in/samuel-chagas-fullstack-developer/



