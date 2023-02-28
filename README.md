# JavaSpringTemplate

## Build status

[![CircleCI](https://dl.circleci.com/status-badge/img/gh/voquanghoa/JavaSpringTemplate/tree/main.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/voquanghoa/JavaSpringTemplate/tree/main)

## Test coverage

[![codecov](https://codecov.io/gh/voquanghoa/JavaSpringTemplate/branch/main/graph/badge.svg?token=KXPWZ8UT3Q)](https://codecov.io/gh/voquanghoa/JavaSpringTemplate)

# Requirements

## Introduction

_The goal of this exercise is to write a web API using Spring Boot Framework. The API allows a frontend to handle books
in a library._

## Models

_This section describes the models used in the application. Feel free to modify them if you believe there is a better
definition_

### Role

| Property | Required |
|:--------:|:--------:|
|    id    |    ✓     |
|   name   |    ✓     |

**We have fixed 2 roles:**

- Admin
- Contributor

### User

| Property  | Required |
|:---------:|:--------:|
|    id     |    ✓     |
| username  |    ✓     |
| password  |    ✓     |
| firstName |    ✗     |
| lastName  |    ✗     |
|  enabled  |    ✓     |
|  avatar   |    ✗     |
|  role_id  |    ✓     |

### Book

|  Property   | Required |
|:-----------:|:--------:|
|     id      |    ✓     |
|    title    |    ✓     |
|   author    |    ✓     |
| description |    ✗     |
| created_at  |    ✓     |
| updated_at  |    ✓     |
|    image    |    ✗     |
|   enabled   |    ✓     |
|   user_id   |    ✓     |

## Endpoints

### Auths

Base URL: `api/v1/auths`

- POST: (Allow anonymous)
    - Login with username/password
    - Request: username/password
    - Response
        - Success: An object with JWT token
        - Failed: 401 error
- GET (Required authenticated)
    - Get the current user's information

### Users

Base URL: `api/v1/users`. All endpoints required ADMIN role

- POST: Create user
- GET: Get all users
- GET `{id}` Get user by id
- PUT: Update user information
- DELETE: Delete a specific user

### Books

Base URL: `api/v1/books`.

- GET: Get all available books (allow anonymous)
- GET: Get book by ID (allow anonymous)
- POST: create a book (require Contributor OR ADMIN)
- PUT: Update a book
    - If user is ADMIN --> Allow
    - If user is Contributor --> Check if the user is the book's owner
- DELETE: delete a book (Check role like PUT)