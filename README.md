Packages:

This project follows a clean, decoupled MVC (Model-View-Controller) layered architecture pattern. Each package has a strict single-responsibility boundary to ensure modularity, maintenance simplicity, and clean data isolation:

1. config(Configuration Layer)
Houses classes that define system-wide beans and override framework configurations. This package is used to set up database connections, security access control lists (ACLs), password encoders, and Cross-Origin Resource Sharing (CORS) mappings to allow web apps to communicate with our API.

2. controller(Presentation Layer)
The primary entry point of our application. Classes in this package expose public HTTP rest endpoints (URLs). They capture client request bodies, handle basic request parameters, map them to standard verbs (`GET`, `POST`, `PUT`, `DELETE`), and pass the requests onward to the business layer.

3. service(Business Logic Layer)
The brain of the food ordering system. This layer sits cleanly between the presentation endpoints and the data storage models. It contains the transactional business logic, orchestrates data updates, coordinates order validation rules, and handles algorithmic computations.

4. repository(Data Access Layer)
Contains the data handling interfaces. These files extend Spring Data's `JpaRepository` or `CrudRepository`. By doing this, they automatically generate database transactions behind the scenes, allowing the application to read, save, and update records in our MySQL instance without writing manual SQL strings.

5. entity(Data Model Layer)
Defines our database schema layout using Object-Relational Mapping (ORM). Each Java class in this package is decorated with annotations like `@Entity` and `@Table` to serve as a direct mirror reflection of a relational table inside our `food_ordering_db` database.

6. dto(Data Transfer Object Layer)
Houses lightweight, sterile data containers used to transport data between application boundaries. DTOs prevent raw, sensitive database entities from being leaked directly to the client API response, acting as a presentation shield for our core models.

7. exception(Global Error Handling Layer)
Manages central global error interceptors across the backend. Instead of letting raw Java system stack traces crash or show up on the client's screen, classes here trap active failures, format them into readable JSON payload shapes, and attach meaningful HTTP status codes.

Project Investigation

1. What is Spring Boot?
Springboot is an open-source java framewrok used to build standalone apps that are ready for production in a short period of time. you donthave to deal with complex configurations and servers. Which enables developers to run the java applications immediately

2. What is Maven?
Maven is a powerful project management and build automation tool primarily used for Java applications. It manages a project's lifecycle, handles compilation, packages the code into executable formats, and automatically downloads all external code libraries (dependencies) from a central internet repository.

3. What is the purpose of pom.xml?
The `pom.xml` (Project Object Model) file is the heart of a Maven project. It is an XML file that defines the configuration details for building the project, including the project version, compiler settings, plugins, and the exact list of external dependencies (such as the MySQL Driver or Spring Web starter) that the application requires to run.

4. What is the purpose of application.properties?
The application.properties file is a configuration file in a Spring Boot application. It is used to define environment-specific variables and framework behavior without changing the actual Java code. Developers use it to specify database connection strings, server port settings, log styles, and security profiles.

5. What does @SpringBootApplication do?
@SpringBootApplication is a cornerstone annotation placed above the main application class. It acts as a convenient bundle of three critical annotationssuch as @SpringBootConfiguration which Marks the class as a source of bean configurations, @EnableAutoConfiguration which tells Spring Boot to guess and configure beans automatically based on the libraries present on your classpath, and the @ComponentScan whichdirects Spring to scan the current package and sub-packages to find and register controllers, services, and other components.

6. Why do developers use dependency management tools such as Maven?
Developers use dependency management tools to eliminate manual library handling. Without Maven, a developer would have to manually find, download, update, and link `.jar` files from various websites, as well as track down "transitive dependencies" (libraries that those libraries depend on). Maven completely automates this tracking, version updating, and downloading process.

7. What is a REST API?
A Representational State Transfer API is an architectural style for designing networked applications. It relies on a stateless, client-server communication model where the client uses standard HTTP methods (`GET` to read, `POST` to create, `PUT` to update, and `DELETE` to remove) to interact with resources on the server via unique web addresses (URLs).

8. What is JSON?
JSON JavaScript Object Notation is a lightweight, human-readable format used for data interchange. It organizes data in simple key-value pairs and ordered lists. Because it is independent of any programming language, it has become the universal standard format for sending data back and forth between frontend user interfaces and backend APIs.

9. What is Dependency Injection?
Dependency Injection is a software design pattern used to achieve Inversion of Control (IoC) between classes and their dependencies. Instead of a Java class manually creating an instance of another helper class using the `new` keyword, the Spring framework creates the object beforehand and automatically passes (injects) it into the class when needed (often using the `@Autowired` annotation).

API Response Format

All API endpoints return a standardized, unified JSON wrapper. This ensures a consistent structure for frontend consumers, providing explicit status codes, operational messaging, data payloads, and ISO timestamps.

Sample Success Response (`GET /api/categories/1`)
json
{
  "statusCode": 200,
  "message": "Category retrieved",
  "data": {
    "id": 1,
    "name": "Burgers",
    "description": "Flame-grilled gourmet beef and chicken burgers"
  },
  "timestamp": "2026-06-18T21:14:32"
}


Sample Empty/Action Response (`DELETE /api/categories/1`)

{
  "statusCode": 200,
  "message": "Category deleted successfully",
  "timestamp": "2026-06-18T21:15:04"
}


