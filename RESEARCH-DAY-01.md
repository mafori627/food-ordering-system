Question 1:What does CRUD stand for?

Create: Insert Rows
Read: Select/Retrieve rows
Update: Modify rows
Delete: Remove rows

Question 2:Difference between HTTP methods POST, PUT, PATCH, DELETE?

The POST method is used to create a brand new record
The PUT method is used to replace an existing record. If a field i missing from a payload, they are wiped out or reset to null
The PATCH method is used for partial updates. It modifies only the specific fields you pass in, leaving the rest of the record unmodified
The DELETE method is used TO permanently remove a resource from the system

Question 3:Give the correct HTTP status code for each:

a. A new category was created: 201 Created
A category was deleted successfully: 204 No Content
The id requested does not exist: 404 Not Found
The request body is missing a required field: 400 Bad Request
The user is logged in but not allowed: 403 Forbidden

Question 4:Difference between @RequestBody, @RequestParam,@PathVariable - with one tiny example of each

The @RequestBody Extracts the main incoming data payload from the transmission body.its a json oject most of the time
Example: public void add(@RequestBody CategoryDTO dto) ➔ Reads {"name": "Pizza"} from the request body

The @RequestParam: Grabs query parameters at the end of a URL string after a question mark.
Example: public List<Category> search(@RequestParam String name) ➔ Extracts "Fast" from /api/categories?name=Fast

The @PathVariable: Extracts a dynamic segment variable built directly inside the URL path itself.
Example:public Category get(@PathVariable Long id) ➔ Extracts 5 from /api/categories/5

Question 5: What is Jakarta Bean Validation? Explain @Valid, @NotBlank, @Size.

Jakarta Bean Validation is the standard java validation framework interace.It allows developers to declare constraints on model properties using data annotations instead of writing long, if-else validation checks
@Valid is Placed on controller arguments to trigger the automatic validation scanning process when a request arrives
@NotBlank Ensures a text string is not null, not empty, and contains at least one non-whitespace character.
@Size Forces a target collection or string length to remain within specified minimum and maximum boundaries

Question 6: Why return a DTO and not the entity itself? Give 2 reasons.

Security and Data Encapsulation: Entities match database table's information directly. Returning this information risks exposing sensitive internal layout attributes such as database Id's and passwords to the public internet view
Performace optimization and Decoupling: Circular entity relationships cause memory serialization infinite loop crashes which DTO'S are able to prevent. DTO's let you flattern the message structure  to send only what the interface requires

Question 7: What is Optional<T>? Why does findById return Optional?
Optional<T> is a container object which was created in java 8 that may or may not contain a non-null value. It acts as a type-safe wrapper to represent the possibiliy of a data not found without resorting to a risky null pointer returns.
FindById returns Optional because a database search for a specific key identifier can easily result in nothing found. Returning an Optional requires you to handle the empty state using convinient safe fallback methods like the .orElseThrow
