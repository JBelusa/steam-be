# Java Backend Project

This repository contains the Java backend code for the Steam-like application.

Frontend for this project is a [React applicaton](https://github.com/JBelusa/steam-fe).

## Table of Contents

- [About](#about)
- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)


## About

This project is a Java backend for a Steam-like application, which manages game and developer data in a database.

## Getting Started

These instructions will help you set up the project on your local machine for development and testing.

### Prerequisites

- Java Development Kit (JDK) 11 or later
- Apache Maven 3.6 or later
- An IDE like IntelliJ IDEA or Eclipse
- MySQL database

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/JBelusa/steam-be.git
    cd steam-be
    ```
2. Set up the MySQL database:
    - Create a database named `steam`.
    - Update the `application.properties` file with your database credentials.
3. Build the project:
    ```sh
    mvn clean install
    ```

### Usage

1. Run the application:
    ```sh
    mvn spring-boot:run
    ```
2. Access the application at `http://localhost:8080`.


3. Use frontend application or API testing application such as Postman to call the API endpoints located in AppController file
   ```sh
    src/main/java/com/example/first_app/controller/AppController.java
    ```
