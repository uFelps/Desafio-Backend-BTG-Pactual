<p align="center" width="100%">
    <img width="50%" src="https://static.poder360.com.br/2022/02/logo-btg-848x477.png"> 
</p>


<h3 align="center">
  Desafio Backend do BTG Pactual
</h3>

Repositório dedicado para a resolução do desafio backend do banco BTG Pactual.
Você pode conferir o enunciado completo, [clicando aqui](https://github.com/buildrun-tech/buildrun-desafio-backend-btg-pactual/blob/main/problem.md).

Foi utilizado como material de apoio para entendimento do desafio o [video](https://www.youtube.com/watch?v=e_WgAB0Th_I) do canal [Build & Run](https://www.youtube.com/@buildrun-tech).

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data MongoDB
- MongoDB
- Lombok
- AMQP
- RabbitMQ


### Clonando o Repositório

```bash
git clone https://github.com/uFelps/
cd Desafio Backend BTG
```

### Rodando o Docker-Compose

```bash
docker-compose up
```

## Utilizando as API's

### 1º Passo

Voce pode começar enviando uma mensagem para a fila `btg-pactual-order-created`
no RabbitMQ que está disponível na url: `http://localhost:15672`, com user e senha definidos como `guest`

Payload
```bash
{
    "orderId": 1001,
    "clientId": 1,
    "itens": [
        {
            "product": "lápis",
            "quantity": 100,
            "price": 1.10
        },
        {
            "product": "caderno",
            "quantity": 10,
            "price": 1.0
        }
    ]
}
```
Após isso, o API irá processar o novo pedido, e salvar no banco de dados

Caso ocorra tudo OK, você pode conferir se o pedido foi salvo no MongoDB

### 2º Passo

Você pode conferir todos os pedidos de um cliente atráves da URL `http://localhost:8080/clients/{id}/orders`

Deve ser retornado algo parecido com isso:
```bash
{
    "totalPages": 1,
    "totalElements": 1,
    "size": 20,
    "content": [
        {
            "orderId": 1001,
            "clientId": 1,
            "total": 120.00,
            "itens": [
                {
                    "product": "lápis",
                    "quantity": 100,
                    "price": 1.10
                },
                {
                    "product": "caderno",
                    "quantity": 10,
                    "price": 1.0
                }
            ]
        }
    ],
    ...
}
```
### 3º Passo

Você tambem pode conferir quantos pedidos um cliente possui atráves da URL:
`http://localhost:8080/clients/{id}/orders/quantity`

A API deve retornar:
```bash
{
  "numberOfOrders": 1
  
}
```