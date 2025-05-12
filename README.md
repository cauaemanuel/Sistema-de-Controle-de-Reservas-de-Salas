
# Sistema de Controle de Reservas de Salas

Este projeto é um sistema de controle de reservas de salas, com funcionalidades para criação, atualização, remoção e visualização de salas e reservas.

## Endpoints da API

### 🔹 **Salas**

#### 1. **Listar todas as salas**

* **Método**: `GET /salas`
* **Descrição**: Retorna uma lista de todas as salas.
* **Resposta**:

  * Código: `200 OK`
  * Corpo: Lista de salas

  ✅ **Exemplo**:

  ```http
  GET http://localhost:8080/salas
  ```

#### 2. **Buscar uma sala específica**

* **Método**: `GET /salas/{id}`
* **Descrição**: Retorna os detalhes de uma sala específica identificada pelo `id`.
* **Resposta**:

  * Código: `200 OK`
  * Corpo: Sala encontrada

  ✅ **Exemplo**:

  ```http
  GET http://localhost:8080/salas/uuidSala
  ```

#### 3. **Criar uma nova sala**

* **Método**: `POST /salas`
* **Descrição**: Cria uma nova sala.
* **Corpo da requisição (JSON)**:

  ```json
  {
    "nome": "Sala de Reunião",
    "capacidadeMaxima": 20,
    "localizacao": "2º Andar"
  }
  ```
* **Resposta**:

  * Código: `201 Created`
  * Corpo: Sala criada

  ✅ **Exemplo**:

  ```http
  POST http://localhost:8080/salas
  Content-Type: application/json
  ```

#### 4. **Atualizar uma sala (campo `nome` apenas)**

* **Método**: `PUT /salas/{id}`
* **Descrição**: Atualiza o nome de uma sala existente, identificada pelo `id`.
* **Corpo da requisição (JSON)**:

  ```json
  {
    "nome": "Sala de Reunião A"
  }
  ```
* **Resposta**:

  * Código: `202 Accepted`
  * Corpo: Sala atualizada

  ✅ **Exemplo**:

  ```http
  PUT http://localhost:8080/salas/uuidSala
  Content-Type: application/json
  ```

#### 5. **Excluir uma sala**

* **Método**: `DELETE /salas/{id}`
* **Descrição**: Exclui uma sala existente.
* **Resposta**:

  * Código: `202 Accepted`

  ✅ **Exemplo**:

  ```http
  DELETE http://localhost:8080/salas/uuidSala
  ```

---

### 🔹 **Reservas**

#### 6. **Criar uma reserva para uma sala**

* **Método**: `POST /reservas/{idDaSala}`
* **Descrição**: Cria uma nova reserva para a sala identificada por `idDaSala`.
* **Corpo da requisição (JSON)**:

  ```json
  {
    "nomeResponsavel": "Maria Oliveira",
    "dataDeInicio": "15/05/2025 09:00",
    "dataDeTermino": "15/05/2025 11:00"
  }
  ```
* **Resposta**:

  * Código: `201 Created`
  * Corpo: Reserva criada

  ✅ **Exemplo**:

  ```http
  POST http://localhost:8080/reservas/uuidSala
  Content-Type: application/json
  ```

#### 7. **Listar todas as reservas futuras**

* **Método**: `GET /reservas/future`
* **Descrição**: Retorna todas as reservas futuras.
* **Resposta**:

  * Código: `200 OK`
  * Corpo: Lista de reservas

  ✅ **Exemplo**:

  ```http
  GET http://localhost:8080/reservas/future
  ```

#### 8. **Listar todas as reservas de uma sala**

* **Método**: `GET /reservas/sala/{id}`
* **Descrição**: Retorna todas as reservas de uma sala específica identificada pelo `id`.
* **Resposta**:

  * Código: `200 OK`
  * Corpo: Lista de reservas

  ✅ **Exemplo**:

  ```http
  GET http://localhost:8080/reservas/sala/uuidSala
  ```

#### 9. **Cancelar uma reserva**

* **Método**: `DELETE /reservas/{id}`
* **Descrição**: Cancela uma reserva existente identificada pelo `id`.
* **Resposta**:

  * Código: `202 Accepted`

  ✅ **Exemplo**:

  ```http
  DELETE http://localhost:8080/reservas/uuidReserva
  ```

---

## Como chamar os endpoints

1. Utilize um cliente HTTP, como o **Postman**, para fazer as chamadas.
2. Certifique-se de passar os parâmetros corretos no corpo da requisição, quando necessário (por exemplo, ao criar ou atualizar uma sala ou reserva).
3. As respostas incluem os códigos HTTP adequados para indicar sucesso (`200 OK`, `201 Created`, `202 Accepted`) ou falhas (como `404 Not Found` ou `400 Bad Request`).

---
