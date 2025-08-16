  ## Lesson 1 - Hibernate / JPA Overview
    
    ● Hibernate

      ○ What is Hibernate? 

        ■ A framework for persisting / saving Java objects in a database

          □ Hibernate is a framework for persisting or saving Java objects into a database, it is a very popular framework
          that is used by a lot of enterprise Java Projects

          □ Basically, in a very high level, we will have our Java application, that will make use of a Hibernate framework
          and we can use it to saving and retrieving data from a database.

        ■ Benefits of Hibernate

          □ Hibernate handles low level SQL code
          □ Minimizes the amount of JDBC code you have to develop
          □ Hibernate can handle the Object-relational mapping and makes it really easy to create apps for storing and retrieving
          objects from a DB 

        ■ How does it work?

          □ As a developer, we need to define mapping between Java class and DB tables. By mapping our Java class to a
          given database table
          □ Java classes attributes usually have camelCase, while db tables usually use snake_case
          □ In the lesson example, we have a Java class student which points tro a student database table with a one to one
          mapping.
          □ We can set up the mappings through configuration files, using xml, or using Java Annotations which will be covered
          later on



      ○ JPA
        
        ■ What is JPA? 

          □ JPA is the Jakarta Persistence API, previously known as Java Persistence API
            . Standard API or Object-Relational-Mapping (ORM)
          
          □ Only a specification
            . Defines a set of interfaces
            . Requires an implementation to be usable

        ■ JPA - Vendor Implementations

          □ JPA Spec is just a list of interfaces and we need a implementations — e.g. Hibernate

          □ One implementation is the Hibernate, just like with Java coding they take those interfaces and provide an implementation
          of those given interfaces.

          □ Eclipse Link, again, they have their own implementation of the JPA specification

          □ There are a lot of implementations out there which we can look for. However, hibernate is probably the most popular
          implementation of the JPA specification and is also the default implementation using Spring Boot

      ○ Benefits of JPA

        ■ What are the benefits? 

          □ By having a standard API, we not locked to vendor's implementation

          □ This way we can maintain portable,  flexible code by coding to JPA spec (interfaces) 

          □ Theoretically we can switch vendor implementations
            . For example, if Vendor ABC stops supporting their product
            . You could switch to Vendor XYZ without vendor lock in
            . The reason for this, is because we're coding to the actual JPA specification or the standard API.
          
        ■ Swapping Vendor Implementation

          □ One example would be:

            . We have `My biz app`
            . And we are writing our DAO code based on JPA specifications
            . Version 1 of our project we're using EclipseLink
            . But for Version 2 we are using a different implementation, because EclipseLink is no longer around or there
            are some issues with that given vendor implementation
            . We can simply swap for a different Vendor implementation, such as Hibernate
            . Code is already up and running with minimal code changes to make, because we are writing code for the standard
            specification.
            . We simply have to change our configuration to tell which vendor implementation to use and that is basically
            it.
          
          □ So that's the main advantage we get by using JPA and coding to the standard API for ORM.
          

      ○ Code Snippets

        ■ Saving a Java Object with JPA

          ```java
            // Create the Java object
            Student theStudent = new Student("Caio", "Ceretta", "caioceretta@gmail.com")

            // Save it to the database
            entityManager.persist(theStudent)
          ```

          □ Here we are making use of the `entityManager` which is a special JPA object or JPA helper object
          □ What happens here on the background is that JPA will take this Java object, based on those mappings we defined
          earlier and JPA will take that information and store it in the appropriate table.

          □ In old days of JDBC we would have to manually write the SQL code, manually set those values, manually execute the
          SQL statement and so for. However, nowadays, JPA, with the help of hibernate, do all the work for us in the background.

        ■ Retrieving a Java Object

          □ There is a number of different options to retrieve them, one basic example would be:

            ```java
            // Create the Java object
            Student theStudent = new Student("Caio", "Ceretta", "caioceretta@gmail.com")

            // Save it to the database
            entityManager.persist(theStudent)

            // Now retrieve from db using primary key

            int theId = 1;
            Student myStudent = entityManager.find(Student.class, theId)
            ```

        ■ Querying for java objects

          □ Let's say that we want to retrieve all the students, not just one student, but a list of students

          □ JPA has a language for queries and in this snippet we are basically creating and executing a JPQL (Java Persistence
          Query Language) query to retrieve all Student entities from a database
            
            . It creates a typed JPQL query that selects every record rom the Student entity table.
            . theQuery.getResultList() executes the query and returns the results as a List<Student>      

            ```java
              TypedQuery<Student> theQuery = entityManager.createQuery("from Student", Student.class);

              List<Student> students = theQuery.getResultList()
            ```

            . TypedQuery<Student> means that this is a query configured to produce a result of type Student

            
      ○ TypedQuery vs Query

        ■ The difference between them is basically for type security and convenience

          □ 1. TypedQuery<Student> — Generic type

            . `TypedQuery<Student> theQuery`

            - `TypedQuery` is a generic interface of the `javax.persistence` package
            - <Student> is the parameter of the generic type — meaning that this query will return objects of the Student
            class
            - This generic type is important because
              - Forces typing by the compiling time
              - Avoids manual casting
              - Allow IDEs to suggest autocomplete for methods that return Student.

          □ 2. Creating the query

            . `entityManager.createQuery("from Student", Student.class)

              - Here we have two parameters for this method
      
                1. First Parameter "from Student"

                  - This is the query string in JPQL
                  - "from student" means: 
                    - Select every instance of Student entity mapped by JPA
                  - Important: We don't use the table name, but the entity class name
                  
                2. Second Parameter `Student.class`   

                  - This is the expected return type
                  - JPA uses it for
                    . To map each line of the result for a `Student` object
                    . Ensure that the query is typed as TypedQuery<Student>

                  - The result of this call is an instance of `TypedQuery<Student>`, assigned to the variable theQuery

            □ 3 - Executing the query 

                  . `theQuery.getResultList()`
                    
                    - This method executes the query in the database
                    - Since theQuery is a TypedQuery<Student>, the return is automatically a List<Student>

                  . This means that:

                    - Each registry found in the database is transformed(mapped) as a Student object
                    - No manual cast is necessary
                    - If the mapping isn't possible (for example, if the query do not return a Student), compiler, and/or the
                    execution will throw an error

          □ 4. Comparison to non-typed query

            Query query = entityManager.createQuery("from Student");
            List<Student> students = (List<Student>) query.getResultList()

            . This is not generic: compiler does not know what is going to be the result type
            . We need to manually cast it with `List<Student>` when retrieving the results
            . If the result is not really from type `Student`, error will only show on execution-time

          □ TypedQuery<Student> (typed)

  ## Lesson 2: Hibernate, JPA and JDBC          

    ● How does Hibernate / JPA relate to JDBC

      ○ Hibernate / JPA uses JDBC for all database communications
        ■ Therefore, they are just another layer of abstraction on top of JDBC
        ■ When the application uses the Hibernate/JDBC framework, the app will store/retrieve the objects using JPA API.
        ■ More will be covered later on

  ## Lesson 3: Setting up development environment

    ● MySQL Database Server
      ○ In this course, MySQL Database will be used
        ■ It consists of two component
          □ MySQL Database Server
          □ MySQL Workbench

        ■ MySQL Database Server:
          □ The MySQL Database Server is the main engine of the database
          □ Stores data for the database
          □ Supports CRUD features on the data

        ■ MySQL Workbench
          □ MySQL Workbench is a client GUI for interacting with the database
          □ Create database schemas and tables
          □ Execute SQL queries to retrieve data
          □ Perform insert, updates and deletes on data
          □ Handle administrative functions such as creating users
          □ Others...

  ## Lesson 4 & 5 - Setting up Database Table

    ● No specific coding for these lessons

  ## Lesson 6 - Setting up Spring Boot project

    ● Automatic Data Source Configuration

      ○ In Spring Boot, Hibernate is the default implementation of JPA
      ○ *EntityManager* is main component for creating queries, etc...  
      ○ *EntityManager* is from Jakarta Persistence API (JPA)

      ○ Based on config, Spring Boot will automatically create the beans
        ■ DataSource, EntityManager, ...
      ○ We can then inject these into our app, for example our DAO

    ● Setting up Project

      ○ At Spring Initializr website, `start.spring.io`
        ■ Add dependencies
          □ MySQL Driver
          □ Spring Data JPA

      ○ Spring Boot - Auto Configuration

        ■ Spring boot will _automatically configure_ our data source for us
        ■ Based on entries from Maven pom file
          □ JDBC Driver: mysql-connector-j
          □ Spring Data (ORM): spring-boot-sta

        ■ DB connection info from: application.properties file

      ○ application.properties

        host:port/database
        spring.datasource.url=jdbc:mysql://localhost:3306/student_tracker
        spring.datasource.username=springstudent
        spring.datasource.password=springstudent

        ■ One thing to be aware of is that there is no need to give JDBC driver class name, Spring Boot will automatically
        detect it based on the datasource URL

    ● Creating Spring Boot - Command Line App

      ○ This will allow us to focus on Hibernate / JPA coding
      ○ Later in the course, we will apply this to a CRUD REST API

      ○ Code example

        ```java
        // imports

        @SpringBootApplication
        public class CrudDemoApplication {

          // Default main method, args represent the command line commands passed when we start the program, therefore
          // if we use something like `java -jar app.jar foo bar`, args[0] will be 'foo' and args[1] will be 'bar'
          public static void main(String[] args) {
            SpringApplication.run(CrudDemoApplication.class, args)
          }

          /* args are also arguments from the command line, but passed from SP to the CommandLineRunner, CommandLineRuner
          is an interface SP executes after the application has already started.

          This CommandLineRunner is from the Spring framework and is basically a hook which allow us to execute code after
          the spring beans have been loaded into the application context
          */ 

          
          @Bean
          public CommandLineRunner commandLineRunner(String[] args) {
            /* this code block is a lambda expression and this is where we can basically add our own custom code, at the
            moment its simply printing a hello world but later on we will add some DAO code to interact with the db*/
            return runner -> {
              System.out.println("Hello World");
            }
          }

        }
        ```

          . Here we are simply setting up the infrastructure, the framework

    ● Command Line Runner and Lambda Code

      ○ Lambda is simply a concise form of writing the implementation of a functional interface, without the need of
      declaring a separate class.

        ■ In java, a normal function need a name, to be within a class and may have multiple uses

        ■ Lambda, in the oder hand, is a short expression which represent a piece of code to be executed (the implementation
        of a single method of a functional interface)

        ■ Lambda is pretty much like an arrow function used as a callback

      ○ What is command line runner?

        ■ In SP, this is a functional interface — i.e., it has one single abstract method (run(String... args)). e.g.

        ```java
          @FunctionalInterface
          public interface CommandLineRunner {
            void run(String... args) throws Exception;
          }
        ```

        ■ This mean that we can implement this method

          □ By creating a class which implements CommandLineRunner
          □ Creating an anonymous class
          □ Or using a lambda expression, which is shorter and more readable

        ■ That same code without lambda would be something like

        ```java
                @Bean
        public CommandLineRunner commandLineRunner(String[] args) {
            return new CommandLineRunner() {
                @Override
                public void run(String... args) {
                    System.out.println("Hello World");
                }
            };
        }
        ```

  ## Lesson 7 ~ 8 - Setting up Spring Boot project - Coding

    ● Initial Steps

      ○ First of all, we are going to the initializr website and utilize those dependencies of the mysql and jpa and
      generate it.       

    ● Proceed to IntelliJ and comments will be located there.
      





  





