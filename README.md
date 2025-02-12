# Spring_mngdb
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
[![Licence](https://img.shields.io/github/license/Ileriayo/markdown-badges?style=for-the-badge)](./LICENSE)

# Sobre o projeto

Este **projeto** é um projeto desenvolvido em **Spring Boot** durante meus estudos pessoais, por meio do curso **Java COMPLETO: Programação Orientada a Objetos, UML, JDBC, Spring Boot, JPA, Hibernate, MySQL e MongoDB**.

A aplicação consiste em um sistema de gerenciamento de posts e comentários, utilizando o banco de dados **MongoDB**. A estrutura do projeto é composta por entidades como **Usuário**, **Postagem** e **Comentário**. 

A relação entre essas entidades pode ser resumida da seguinte forma:

- O **Usuário** realiza uma **Postagem**.
- Uma **Postagem** contém agregação aos **Comentários** e aos **Usuários**.
- Cada **Comentário** agrega a um **Usuário**.

## Modelo conceitual
![Modelo Conceitual](https://github.com/EduardoBmAguiar/assets/blob/main/Modelo%20Conceitual%20mongd.png)

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- Maven
- Postman

## Implantação em produção
- Banco de dados: [MongoDB](https://www.mongodb.com/pt-br)

# Como executar o projeto

### Pré-requisitos
- Java [21](https://www.oracle.com/java/technologies/downloads/#jdk21-windows)

---

# API Endpoints

## Users

### Listar todos os usuários (GET)
```bash
GET | http://localhost:8080/users
```
#### Exemplo da resposta:
``` json
[
    {
        "id": "67acad979892910664d8aa78",
        "name": "Maria Brown",
        "email": "maria@gmail.com"
    },
    {
        "id": "67acad979892910664d8aa79",
        "name": "Alex Green",
        "email": "alex@gmail.com"
    },
    {
        "id": "67acad979892910664d8aa7a",
        "name": "Bob Grey",
        "email": "bob@gmail.com"
    }
]
```

### Obter um usuário por ID (GET)

```bash
GET | http://localhost:8080/users/67acad979892910664d8aa78
```
#### Exemplo da resposta:
``` json
{
    "id": "67acad979892910664d8aa78",
    "name": "Maria Brown",
    "email": "maria@gmail.com"
}
```

### Obter posts do usuário (GET)
```bash
POST | http://localhost:8080/users/67acad979892910664d8aa78/posts
```
#### Exemplo da resposta:
``` json
[
    {
        "id": "67acad979892910664d8aa7b",
        "date": "2024-03-21",
        "title": "Partiu viagem",
        "body": "Vou viajar para São Paulo. Abraços!",
        "author": {
            "id": "67acad979892910664d8aa78",
            "name": "Maria Brown"
        },
        "comments": [
            {
                "text": "Boa viagem mano",
                "date": "2024-03-21",
                "author": {
                    "id": "67acad979892910664d8aa79",
                    "name": "Alex Green"
                }
            },
            {
                "text": "Aproveite",
                "date": "2024-03-22",
                "author": {
                    "id": "67acad979892910664d8aa7a",
                    "name": "Bob Grey"
                }
            }
        ]
    },
    {
        "id": "67acad979892910664d8aa7c",
        "date": "2024-03-23",
        "title": "Bom dia",
        "body": "Acordei feliz hoje!",
        "author": {
            "id": "67acad979892910664d8aa78",
            "name": "Maria Brown"
        },
        "comments": [
            {
                "text": "Tenha um Ótimo dia!",
                "date": "2024-03-23",
                "author": {
                    "id": "67acad979892910664d8aa79",
                    "name": "Alex Green"
                }
            }
        ]
    }
]
```

### Criar um novo usuário (POST)
```bash
POST | http://localhost:8080/users
```
#### Exemplo da requisição:
``` json
{
    "name" : "Maria Eduarda",
    "email" : "Mama@gmail.com"
}
```

### Atualizar um usuário existente (PUT)
```bash
PUT | http://localhost:8080/users/67acad979892910664d8aa78
```
#### Exemplo da requisição:
``` json
{
    "name" : "Eduardo Benjamin",
    "email" : "dudu@gmail.com"
}
```

### Excluir um usuário (DELETE)
```bash
DELETE | http://localhost:8080/users/67acae5d9892910664d8aa7d
```

## Posts

### Obter um post por ID (GET)
```bash
GET | http://localhost:8080/posts/67acad979892910664d8aa7c
```
#### Exemplo de resposta:
``` json
{
    "id": "67acad979892910664d8aa7c",
    "date": "2024-03-23",
    "title": "Bom dia",
    "body": "Acordei feliz hoje!",
    "author": {
        "id": "67acad979892910664d8aa78",
        "name": "Maria Brown"
    },
    "comments": [
        {
            "text": "Tenha um Ótimo dia!",
            "date": "2024-03-23",
            "author": {
                "id": "67acad979892910664d8aa79",
                "name": "Alex Green"
            }
        }
    ]
}
```

### Obter posts pelo titulo [titleSearch] (GET)
```bash
GET | http://localhost:8080/posts/titlesearch?text=bom dia
```
#### Exemplo de resposta:
``` json
[
    {
        "id": "67acad979892910664d8aa7c",
        "date": "2024-03-23",
        "title": "Bom dia",
        "body": "Acordei feliz hoje!",
        "author": {
            "id": "67acad979892910664d8aa78",
            "name": "Maria Brown"
        },
        "comments": [
            {
                "text": "Tenha um Ótimo dia!",
                "date": "2024-03-23",
                "author": {
                    "id": "67acad979892910664d8aa79",
                    "name": "Alex Green"
                }
            }
        ]
    }
]
```

### Obter posts independente se pelo titulo, corpo ou comentário [fullSearch] (GET)
```bash
GET | http://localhost:8080/posts/fullsearch?text=tenha
```
#### Exemplo de resposta:
``` json
[
    {
        "id": "67acad979892910664d8aa7c",
        "date": "2024-03-23",
        "title": "Bom dia",
        "body": "Acordei feliz hoje!",
        "author": {
            "id": "67acad979892910664d8aa78",
            "name": "Maria Brown"
        },
        "comments": [
            {
                "text": "Tenha um Ótimo dia!",
                "date": "2024-03-23",
                "author": {
                    "id": "67acad979892910664d8aa79",
                    "name": "Alex Green"
                }
            }
        ]
    }
]
```

### Obter posts com fullSearch/data miníma (GET) 
```bash
http://localhost:8080/posts/fullsearch?text=aproveite&minDate=2024-03-21
```
#### Exemplo de resposta:
``` json
[
    {
        "id": "67acad979892910664d8aa7b",
        "date": "2024-03-21",
        "title": "Partiu viagem",
        "body": "Vou viajar para São Paulo. Abraços!",
        "author": {
            "id": "67acad979892910664d8aa78",
            "name": "Maria Brown"
        },
        "comments": [
            {
                "text": "Boa viagem mano",
                "date": "2024-03-21",
                "author": {
                    "id": "67acad979892910664d8aa79",
                    "name": "Alex Green"
                }
            },
            {
                "text": "Aproveite",
                "date": "2024-03-22",
                "author": {
                    "id": "67acad979892910664d8aa7a",
                    "name": "Bob Grey"
                }
            }
        ]
    }
]
```

### Obter posts com fullSearch/data miníma/data máxima (GET) 
```bash
http://localhost:8080/posts/fullsearch?text=aproveite&minDate=2024-03-21&maxDate=2025-02-15
```
#### Exemplo de resposta:
``` json
[
    {
        "id": "67acad979892910664d8aa7b",
        "date": "2024-03-21",
        "title": "Partiu viagem",
        "body": "Vou viajar para São Paulo. Abraços!",
        "author": {
            "id": "67acad979892910664d8aa78",
            "name": "Maria Brown"
        },
        "comments": [
            {
                "text": "Boa viagem mano",
                "date": "2024-03-21",
                "author": {
                    "id": "67acad979892910664d8aa79",
                    "name": "Alex Green"
                }
            },
            {
                "text": "Aproveite",
                "date": "2024-03-22",
                "author": {
                    "id": "67acad979892910664d8aa7a",
                    "name": "Bob Grey"
                }
            }
        ]
    }
]
```

# Autor

Eduardo Benjamin Mattos Aguiar

https://www.linkedin.com........
