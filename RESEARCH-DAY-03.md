 Q1.  What is JPA? What is Hibernate? How are they related?

Jakarta Persistence API is a standard specification or blueprint for managing relational data in Java applications. It defines the rules, interfaces, and annotations but contains no actual working code
Hibernate is a framework that provides the real, concrete implementation of the JPA specification
The relationship between JPA and Hibernate is that JPA is the interface or contract, while Hibernate is the engine under the hood that executes the database operations

 Q2.  What is the difference between @Entity and @Table?

 @Entity is a core JPA annotation that tells the Java compiler and Hibernate that this class represents a database row and should be managed by the entity manager
 @Table is an optional configuration annotation used to customize the database table details, such as changing the actual database table name for example @Table(name = "menus")

 Q3.  What is a foreign key? What is @ManyToOne? Give 2 real-world examples.

 A Foreign Key is a column in one database table that links directly to the primary key column of another table to establish a relationship.
 @ManyToOne is JPA annotation that indicates multiple rows of the current entity can link to one single row of the target entity.
 The first real world exmple is multiple menu i such astems Cheese Burger and Chicken Wings belong to one Category which is Fast Food
 The second real world exampleis that multiple orders placed on different days belong to one User Account.

 Q4.  What does @JoinColumn(name = "category_id") do?

 This instructs Hibernate to create a physical foreign key column named category_id inside a current table, like the one named menus.It handles the work of linking that column directly to the primary key of the target table name categories

Q5.  Why store price as BigDecimal and not double?

Floating-point types like double and float lose precision during math operations due to how binary decimals work. BigDecimal unlike the double and float maintains absolute decimal precision, preventing rounding bugs like R29.99 becoming R29.98999999 which is mandatory for money

Q6.  What does FetchType LAZY vs EAGER mean? What is the default for @ManyToOne?

EAGER automatically fetches the related object from the database immediately when you load the main object.
LAZY postpones fetching the related data until your cod calls a getter method 
The default fetch type for @ManyToOne relationships is EAGER.

Q7.  What is the N+1 query problem?

 The problem occurs when an application runs 1 initial query to fetch a list of N records, and then runs N individual separate queries to fetch the related object for each record. An example of this is if you fetch 100 menus, your database is hit with 1 + 100 = 101 separate queries, drastically dragging down system speed

 Q8.  What is dependency injection? Constructor injection vs field injection — which is preferred and why?

 Dependency Injection is a design pattern where an external environment like the Spring Framework container creates and delivers dependent objects to a class, rather than the class creating them manually with the new keyword
 Field Injection injects dependencies directly into fields using reflection.
 Constructor Injection njects dependencies via a class constructor method. It is the preffered method because it allows fields to be marked final which guarantees the class cannot be initialized with missing or null components, and makes writing unit tests easier without spinning up a Spring container

  Q9.  What does @RequiredArgsConstructor (Lombok) do?

  It automatically generates a compiled Java constructor containing parameters for all class fields marked as final or annotated with @NonNull.

  Q10. What is the role of the SERVICE layer? Why must it be separate from the controller?

  The role of the service layer is to acts as the brain of the application, hosting core business logic, validation rules, and transactional boundaries.
  It should seperate from the controller layer because the controller layer should only be responsible for monitoring the routing HTTP requests and returning statuses. Separation keeps code reusable, highly organized, and easy to isolate during unit testing.

  Q11. Why MUST you validate that categoryId exists before saving a menu?

  Saving a menu item referencing a missing categoryId will cause a relational database crash due to foreign key violations.

  Q12. Difference between save() and saveAndFlush()?

  save() saves changes to the local memory cache buffer but delays synchronization with the actual database until the current transaction commits.
  saveAndFlush() forces the application to execute changes and write them to the database disk immediately within the active pipeline step.

   Q13. Why write private mapper methods (entity <-> dto)?

   Database schemas (Entities) should remain hidden from external API clients for security and decoupling.
   DTOs shape exactly what data is transferred over the network ,exposing categoryName but ignoring raw database metadata for example, keeps layers clean and independent.
