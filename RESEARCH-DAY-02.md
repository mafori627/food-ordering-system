 Q1. What is a Java generic type? Why is <T> useful?
 A Java generic type is a feature that allows classes, interfaces, and methods to operate on parameters of any data type while ensuring strict compile-time type safety.
 Why <T> is useful: The <T> acts as a placeholder for a Type that will be specified later. In our project, it makes our Response<T> envelope completely reusable. Instead of writing separate response wrapper files for categories, products, or user accounts, a single Response<T> class can safely wrap a CategoryDTO, a List<ProductDTO>, or an empty Void object without losing type safety or forcing risky object type-casting.
 
 Q2. What does Lombok @Builder generate behind the scenes?
 Lombok's @Builder annotation automatically writes a separate, hidden inner class called ResponseBuilder during compilation. 
 Behind the scenes, it generates:A private constructor on the target Response class that accepts all fields.A public static builder() method that returns an instance of the inner ResponseBuilder class.Chainable setter-like methods for each field (statusCode(), message(), etc.) inside the builder that return the builder object itself.A final build() method that executes the private constructor, compiling all the chained data parameters together to instantiate the immutable Response object.
 
 Q3. What is the Builder design pattern? When to use it?
 The Builder design pattern is a creational design pattern designed to separate the construction of a complex object from its actual representation. It allows you to build an object step by step using readable, chainable method calls instead of massive constructors.
 When to use it: Use it when an object contains a large number of fields, when many parameters are optional or default to null, or when you want to avoid "telescoping constructors" (having multiple confusing constructors with varying parameter counts). It makes code highly readable and prevents accidental parameter placement bugs (such as swapping two string values in a constructor call).
 
 Q4. What is LocalDateTime? How is it different from Date?
 LocalDateTime is a modern date-time class introduced in Java 8 (part of the java.time package) that represents an immutable date and time without a time-zone context (e.g., 2026-06-18T20:58:11).
 How it differs from java.util.Date:Immutability: LocalDateTime is completely thread-safe and immutable. Date is mutable, meaning its values can be modified on the fly, which frequently leads to concurrency bugs.API Quality: Date counts years starting from 1900 and numbers months starting from 0 (January is 0), which is highly confusing. LocalDateTime uses standard calendar numbering.Precision: LocalDateTime supports modern nanosecond precision, whereas Date only supports milliseconds.
 
 Q5. Why does a consistent response format matter to frontend developers?
 A consistent response format is critical for frontend engineers (building in React, Angular, or Vue) because it allows them to construct standardized data interceptors and reusable HTTP client logic.If every single backend route returns an identical outer envelope shape (statusCode, message, data, timestamp), the frontend developer only needs to write their response exception handling, alert notifications, and loading spinner state logic once. They don't have to guess or rewrite code blocks to handle varying JSON shapes from different API controllers.
 
 Q6. What does @JsonInclude(JsonInclude.Include.NON_NULL) do?
 This Jackson serialization annotation ensures that any object fields holding a value of null are completely left out of the final JSON text string sent to the client.Why it's useful: In our project, when a category is successfully deleted, our Response<Void> endpoint passes null into the data field. Instead of wasting network bandwidth sending "data": null over the internet, this annotation suppresses the field completely. It makes our API response payloads much cleaner and prevents frontend apps from accidentally tripping over null payload properties.
 
Q7. What is a static factory method? Why use Response.success(...) instead of new Response<>()?
A static factory method is a public static method inside a class that encapsulates object creation logic and returns an instance of that class.
Why use Response.success(...) over new Response<>():Readability: The name Response.success(...) clearly and explicitly states the intent and context of the object being created. The keyword new gives no context.Encapsulation: It hides the underlying instantiation details (like automatically stamping the current LocalDateTime.now() behind the scenes) so the controller doesn't have to type out redundant boilerplate settings every single time.Type Inference: It minimizes type verbosity, cleaning up long controller returns into short, highly expressive lines of code.
