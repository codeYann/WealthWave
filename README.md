# WealthWave

WealthWave is a secure and efficient online banking system built using Java and Spring Boot. It allows users to manage their bank accounts, perform transactions, and view transaction history.

## Features

- User authentication and authorization
- Account management (create, view, update, delete accounts)
- Transaction management (deposit, withdraw, transfer)
- View transaction history
- Secure password storage using BCrypt
- JWT-based stateless authentication

## Tech Stack

- **Backend**: Java, Spring Boot
- **Database**: PostgreSQL
- **Security**: Spring Security /  Security, JWT, BCrypt
- **Frontend**: (Optional) Angular / React / Vue.js

## Getting Started

### Prerequisites

- Java 21
- Maven or Gradle
- Docker (optional, for containerization)
- Node.js and npm (if using a frontend framework)

### Installation

1. **Clone the repository**:
    ```sh
    git clone https://github.com/codeYann/WealthWave.git
    cd WealthWave
    ```

2. **Configure the database**:
    - Update the `src/main/resources/application.properties` file with your database configuration.
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/WealthWave
    spring.datasource.username=root
    spring.datasource.password=password
    spring.jpa.hibernate.ddl-auto=update
    ```

3. **Build and run the application**:
    ```sh
    ./mvnw spring-boot:run
    ```

### API Endpoints

#### User Authentication

- `POST /auth/register`: Register a new user
- `POST /auth/login`: Authenticate a user and receive a JWT

#### Account Management

- `POST /accounts`: Create a new account
- `GET /accounts/{id}`: Get account details by ID
- `PUT /accounts/{id}`: Update account details
- `DELETE /accounts/{id}`: Delete an account

#### Transaction Management

- `POST /transactions/deposit`: Deposit money into an account
- `POST /transactions/withdraw`: Withdraw money from an account
- `POST /transactions/transfer`: Transfer money between accounts
- `GET /transactions/account/{accountId}`: Get all transactions for a specific account

### Running Tests

- **Unit Tests**: Run unit tests using JUnit and Mockito
    ```sh
    ./mvnw test
    ```

- **Integration Tests**: Run integration tests to test the entire flow
    ```sh
    ./mvnw verify
    ```

### Docker (Optional)

1. **Build the Docker image**:
    ```sh
    docker build -t WealthWave .
    ```

2. **Run the Docker container**:
    ```sh
    docker run -p 8080:8080 WealthWave
    ```

## Frontend (Optional)

If you choose to implement a frontend, follow these steps:

1. **Navigate to the frontend directory**:
    ```sh
    cd frontend
    ```

2. **Install dependencies**:
    ```sh
    npm install
    ```

3. **Run the frontend application**:
    ```sh
    npm start
    ```

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any enhancements or bug fixes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements

- [Spring Boot](https://spring.io/projects/spring-boot)
- [JWT](https://jwt.io/)
- [BCrypt](https://bcrypt-generator.com/)
# WealthWave

WealthWave is a secure and efficient online banking system built using Java and Spring Boot/. It allows users to manage their bank accounts, perform transactions, and view transaction history.

## Features

- User authentication and authorization
- Account management (create, view, update, delete accounts)
- Transaction management (deposit, withdraw, transfer)
- View transaction history
- Secure password storage using BCrypt
- JWT-based stateless authentication

## Tech Stack

- **Backend**: Java, Spring Boot
- **Database**: PostgreSQL
- **Security**: Spring Security /  Security, JWT, BCrypt
- **Frontend**: (Optional) Angular / React / Vue.js

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven or Gradle
- Docker (optional, for containerization)
- Node.js and npm (if using a frontend framework)

### Installation

1. **Clone the repository**:
    ```sh
    git clone https://github.com/yourusername/WealthWave.git
    cd WealthWave
    ```

2. **Configure the database**:
    - Update the `src/main/resources/application.properties` file with your database configuration.
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/WealthWave
    spring.datasource.username=root
    spring.datasource.password=password
    spring.jpa.hibernate.ddl-auto=update
    ```

3. **Build and run the application**:
    ```sh
    ./mvnw spring-boot:run
    ```
    Or, if using :
    ```sh
    ./mvnw quarkus:dev
    ```

### API Endpoints

#### User Authentication

- `POST /auth/register`: Register a new user
- `POST /auth/login`: Authenticate a user and receive a JWT

#### Account Management

- `POST /accounts`: Create a new account
- `GET /accounts/{id}`: Get account details by ID
- `PUT /accounts/{id}`: Update account details
- `DELETE /accounts/{id}`: Delete an account

#### Transaction Management

- `POST /transactions/deposit`: Deposit money into an account
- `POST /transactions/withdraw`: Withdraw money from an account
- `POST /transactions/transfer`: Transfer money between accounts
- `GET /transactions/account/{accountId}`: Get all transactions for a specific account

### Running Tests

- **Unit Tests**: Run unit tests using JUnit and Mockito
    ```sh
    ./mvnw test
    ```

- **Integration Tests**: Run integration tests to test the entire flow
    ```sh
    ./mvnw verify
    ```

### Docker (Optional)

1. **Build the Docker image**:
    ```sh
    docker build -t WealthWave .
    ```

2. **Run the Docker container**:
    ```sh
    docker run -p 8080:8080 WealthWave
    ```

## Frontend (Optional)

If you choose to implement a frontend, follow these steps:

1. **Navigate to the frontend directory**:
    ```sh
    cd frontend
    ```

2. **Install dependencies**:
    ```sh
    npm install
    ```

3. **Run the frontend application**:
    ```sh
    npm start
    ```

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any enhancements or bug fixes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements

- [Spring Boot](https://spring.io/projects/spring-boot)
- [JWT](https://jwt.io/)
- [BCrypt](https://bcrypt-generator.com/)

