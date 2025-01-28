# 🛠️ Transaction API - Itau Challenge

This repository contains a **Transaction API** built with **Spring Boot** to handle financial transactions, including storing, clearing, and calculating transaction statistics.

---

The following link has more details about this challenge - <a href="https://github.com/rafaellins-itau/desafio-itau-vaga-99-junior">desafio-itau-vaga-99-junior</a>
## 📋 Endpoints Overview

### 1️⃣ **Receive Transactions**: `POST /transaction/`
#### Description:
This endpoint receives transactions, each containing a value and a timestamp.

#### Request Body:
```json
{
  "valor": 123.45,
  "dataHora": "2020-08-07T12:34:56.789-03:00"
}
````

### 2️⃣ **Receive Transactions**: `DELETE /transaction/`
#### Description:
Deletes all stored transactions.

#### Response
````text
200 - OK
````

### 3️⃣ **Receive Transactions**: `GET /statistics/`
#### Description:
Returns statistics for transactions that occurred in the last 60 seconds.

#### Response
````json
{
  "count": 10,
  "sum": 1234.56,
  "avg": 123.456,
  "min": 12.34,
  "max": 123.56
}
````
