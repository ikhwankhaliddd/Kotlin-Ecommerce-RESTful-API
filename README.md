# Kotlin Spring Boot Ecommerce RESTful API Project

Welcome to the Kotlin Spring Boot Ecommerce RESTful API project! This project serves as the backend for an Ecommerce application, providing RESTful APIs for managing products, orders, users, and more.

## Table of Contents

- [Technologies](#technologies)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)

## Technologies

- **Kotlin:** The project is developed using the Kotlin programming language.
- **Spring Boot:** We leverage Spring Boot to build robust and scalable RESTful APIs.
- **Spring Data JPA:** For working with the database and data persistence.
- **Database:** PostgreSQL
- **Gradle:** We use Gradle as a build tool for managing project dependencies.
- **Swagger:** Swagger is integrated to provide API documentation and testing. (TODO)
- **Docker:** We use docker to containerized the 

## Getting Started

### Prerequisites

Before you begin, ensure you have met the following requirements:

- Describe any prerequisites or system requirements here (e.g., Java 11, Docker).

### Installation

1. Clone this repository:

   ```shell
   git clone https://github.com/ikhwankhaliddd/Kotlin-RESTful-API-Ecommerce.git
   cd Kotlin-RESTful-API-Ecommerce
   ```
2. Configure your application properties in src/main/resources/application.properties or src/main/resources/application.yml as needed for your environment.
**src/main/resources/application.properties** or **src/main/resources/application.yml** as needed for your environment.

3. Build and run the application using Gradle:
   ```shell
    ./gradlew bootRun
   ```
   Or you can build a JAR file and run it:
   ```shell
   ./gradlew build
    java -jar build/libs/<your-app-name>.jar
   ```
Now, your Kotlin Spring Boot Ecommerce RESTful API should be up and running.

## Contributing
If you would like to contribute to this project, please follow these guidelines:

1. Fork the repository and create a new branch.
2. Make your changes and test thoroughly.
3. Ensure your code follows best practices and is well-documented.
4. Create a pull request with a clear description of your changes.