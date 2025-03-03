# Srpingboot crud Application

This is a Spring Boot application that demonstrates the use of Thymeleaf for building web applications. The application manages employee records, allowing users to add, update, delete, and list employees.

![employee](employee-dir)

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Thymeleaf
- Bootstrap
- Maven

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher
- A relational database (e.g., MySQL)

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/sudhirskp/thymeleafdemo.git
   cd thymeleafdemo
   ```

2. Configure the database:
   - Update the `application.properties` file in `src/main/resources` with your database connection details.

3. Build the project:
   ```sh
   mvn clean install
   ```

4. Run the application:
   ```sh
   mvn spring-boot:run
   ```

### Usage

- Access the application at `http://localhost:8080/employees/list`.
- Use the interface to add, update, delete, and list employees.

## Project Structure

- `src/main/java/skp/test/demo/ThymeleafdemoApplication.java`: Main class for running the Spring Boot application.
- `src/main/java/skp/test/demo/controller/EmployeeController.java`: Controller class for handling web requests.
- `src/main/java/skp/test/demo/entity/Employee.java`: Entity class representing an employee.
- `src/main/java/skp/test/demo/service/EmployeeService.java`: Service class for business logic related to employees.
- `src/main/java/skp/test/demo/dao/EmployeeRepository.java`: Repository interface for database operations.
- `src/main/resources/templates/employees/employee-form.html`: Thymeleaf template for the employee form.
- `src/main/resources/templates/employees/list-employees.html`: Thymeleaf template for listing employees.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.
