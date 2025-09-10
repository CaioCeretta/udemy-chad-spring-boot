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

    ● Code and comments are mostly going to be located in IntelliJ.

    ● Code steps

      ○ First of all, we are going to the initializr website and utilize those dependencies of the mysql and jpa and
      generate it.       

      ○ After generating, if we try to run the code runner, it will throw an error due to datasource misconfiguration
      so in /src/resources/application.properties, set the url, username, and password of the db connection

      ○ To prevent application to show the banner on every launch we can simply:
        spring.main.banner-mode=off

      ○ And to reduce logging level only to warnings and errors
        logging.level.root=warn

        ■ This is only being done because we are using a standalone application, in bigger applications, the logs depend
          on application requirements

  ## Lesson 9 - JPA Dev Process - To Do List

    ● Steps

      1. Annotate Java Class
      2. Develop Java Code to perform database operations
   
    ● Let's just say "JPA"

      ○ As mentioned, Hibernate is the default JPA implementation in Spring Boot

      ○ Going forward in this course, the instructor will simply use the term `JPA`
        ■ Instead of saying "JPA Hibernate" 

      ○ We know that by default, Hibernate is used behind the scenes.

    ● Terminology

      ○ Entity Class

        ■ Java class that is mapped to a database table 

        ■ At a minimum, the Entity Class
          □ Must be annotated with @Entity
          □ Must have a public or protected no-argument constructor
            . The class can have other constructors

      ○ ORM

        ■ Java Class (with its attributes commonly in camelCase) talks to the JPA that talks to the database (same attributes
        but with its attribute names in snake_case, e.g. firstName is equal to first_name)

      ○ Constructors in Java - Refresher

        ■ Remember about constructors in Java

        ■ If you don't declare any constructors
          □ Java will provide a no-argument constructor for free
        
        ■ If we declare constructors with arguments
          □ Then we do not get one for free
          □ In this case, we have to explicitly declare a no-argument constructor

      ○ Java Annotations

        ■ Step 1: Map class to database table

          ```java
            @Entity
            @Table(name="student")
            public class Student {
              ...
            }
          ```
          

        ■ Step 2: Map fields to database columns

          ```java
                     
            @Entity
            @Table(name="student")
            public class Student {
              
              @Id
              @Column(name="id")
              private int id;

              @Column(name="first_name")
              private String firstName;

            }
            
          ```

          □ Map these given fields to the appropriate database columns. This is done by making use of the @Column annotation.

        ■ @Column - Optional

          □ One thing to be aware of is that the @Column annotation is actually optional
          □ If not specified, the column name is the same as the Java field

          □ In general, this approach is not recommended, since if we refactor the Java code, then it will not match
          existing database column
          □ This is a breaking change and we will need to update database column
          □ Same applies to @Table, database table name is same as the class

        ■ Primary Key

          □ Uniquely identifies each row in a table
          □ Must be a unique value
          □ Cannot contain NULL values

      ○ Auto Increment

        ■ MySQL: we can make use of auto increment with, e.g `id int NOT_NULL AUTO_INCREMENT`. in this
        case we would need at the end of the table PRIMARY KEY (id), but it could also de before after the type
        
        ■ JPA Identity - Primary Key:

          ```java
            // class creation
            @Id
            @GeneratedValue(strategy=GenerationType.IDENTITY)
            @Column(name="id")
            private int id; 
            // rest of class
          ```

          □ ID Generation Strategies

            ▢ .AUTO: Pick an appropriate strategy for the particular database
            ▢ .IDENTITY: Assign primary keys using database identity column
            ▢ .SEQUENCE: Assign primary keys using a database sequence
            ▢ .TABLE: Assign primary keys using an underlying database table to ensure uniqueness
            ▢ .UUID: Assign primary keys using a globally unique identifier to ensure uniqueness

            ▢ In general, IDENTITY is recommended and that should cover most of the use cases, unless the are some
            really specific use cases

      ● Bonus

        ○ Our company and our project may require some specific requirement for generating the id and nothing provided
        by JPA out-of-the-box matches this requirement

          ■ We can define our CUSTOM generation strategy for our ID
          ■ Create implementation of `org.hibernate.id.IdentifierGenerator`
          ■ Override the method: public Serializable generate(...) and inside this generate method we provide our custom
          business logic or corporate logic for generating a given ID.

    ● Coding

      some comments should be placed in intellij code

      1. Open cruddemo application we just created inside intellij 
      2. create new package entity under the artifact name package
      3. inside entity, create a `Student` class
      4. map the class to a database table, using the @Entity, @Table(name="student"), and @ColumnName annotations
      5. define a no-argument constructor and also create a constructor that accepts argument

      ○ Why sometimes we don't need to specify the `this` keyword when calling a parameter inside a class

        ■ This question arose when creating getters in intellij, such as public String getEmail() { return email; }
        ■ If email is a private attribute, why on the getter we didn't have to specify this.email ?

        ■ In Java, and many OOP languages, the this keyword refers to the current object instance. But we don't always
        need to write it explicitly, depending on the context
          □ Why we don't need `this` in this case? 
            ▢ the firstName, for instance, is a field class. Inside an instance method, Java automatically looks for
            variables in this order: 
              1. Local variables/parameters of the method
              2. Fields of the current object (`this.field`)

            Since there's no local variable called id inside the method. Java knows we mean the field of the class. So
            writing return id; is a shorthand for `return this.id;` 

        ■ When we must use `this`? 

          □ We need `this` when there's ambiguity — for example, if a local variable or parameter has the same name as
          the field, such as the case of a setter
            ▢ private int id;
              public void setId(int id) {
                  this.id = id;  // left side = field, right side = parameter
              }

          □ without `this` java would think both `id` refer to the method parameter, which makes the assignment
  
  ## Lesson 10 ~ 11: Saving a Java Object with JPA - Overview

    ### Part 1

      ● Sample App Features

        ○ _Create_ a new Student
        ○ _Read_ a Student
        ○ _Update_ a Student
        ○ _Delete_ a Student

        ○ Which is basically a CRUD app

      ● Student Data Access Object

        ○ DAO is responsible for interfacing with the database
        ○ This is a common design pattern
        
        ○ Cruddemo app <-> Student DAO <-> Database
          
          ■ Which is basically a multidirectional communication where the app talks with the Dao, who talks to db, and
          vice versa

          ■ This is kind of like a helper class for communicating with the database.

        ○ The Data Access will have a number of methods, such as save, finders, update, delete, and others.

        ○ It also needs a JPA entity manager, which is the main component for saving / retrieving entities, which the DAO
        talks to, and it communicates with one or more steps until reaching the database

      ● JPA Entity Manager

        ○ Our JPA Entity Manager needs a Data Source
        ○ The Data Source defines database connection info
        ○ Entity Manager and Data Source are automatically created by `SP`
          ■ Based on the file: application.properties (JDBC URL, user_id, password, etc)

        ○ Student DAO <-> Entity Manager <-> Data Source <-> database
          ■ We have our DAO, that is going to make use of an entity manager, which in turn make use of a given data source.
          ■ And we'll actually inject the entity manger into our Student DAO

        ○ But what about JpaRepository?
        
          ■ Some people may have already heard or read something about JpaRepository, and at this point of the course, we
          may wonder: "Well, what about JpaRepository? Why are we not using it?"

          ■ Spring Data JPA has JpaRepository interface

            □ It provides JPA database access with minimal coding, but there were some questions made by other students
            to the teacher asking about the JpaRepository in place of entityManager, so which one is better?

              . The short answer to this question is: Yes, we will use JpaRepository in the course
              . It will be covered later in the course
              . In this course, the instructor wants to show various techniques for using JPA
              . Knowing BOTH entityManager and JpaRepository will help us on future projects
              . And developers who know both entityManager and JpaRepository can solve more issues and contribute more on
              a team, different from who knows only one of these.

          ■ In simple terms, when to use which? 

            □ If we need low-level control and flexibility, use EntityManager
            □ If we want high-level of abstraction, use JpaRepository

          ■ Use Case

            □ Entity Manager

              . Need low-level control over the database operations and want to write custom queries
              . Provides low-level access to JPA and work directly with JPA entities
              . Complex queries that require advanced features such as native SQL queries or stored procedure calls.
              . When we have custom requirements that are not easily handled by higher-level abstractions.

            □ JpaRepository

              . Provides commonly used CRUD operations out of the box, reducing the amount of code we need to write
              . Additional features such as pagination, sorting
              . Generate queries based on Java method names
              . Can also create custom queries using @Query

            □ Instructor Recommendation

              . Choice depends on the application requirements and developer preference
              . We can use both in the same project 

              . For learning purposes, it is recommended learning EntityManager first then learn JpaRepository
              . This will help us understand the low-level coding behind the scenes and then we can use JpaRepository for
              some of the more additional features there.
              . Knowing BOTH EntityManager and JpaRepository will help us on future projects

    ### Part 2

      ● Development Process for Student DAO

        ○ Step 1: Define DAO interface

          ■ Define a save method such as

            ```java
              public interface StudentDAO {
                void save(Student theStudent)
              }
            ```

          ■ This Student class is an entity mapped to a given database table

        ○ Step 2: Define DAO implementation

          ■  Define the implementation class, like

            ```java
              public interface StudentDAOImpl implements StudentDAO {
                  private EntityManager entityManager;

                  public StudentDAOImpl(EntityManager theEntityManager) {
                    entityManager = theEntityManager
                  }

                  @Override
                  @Transactional
                  public void save(Student theStudent) {
                    entityManager.persist(theStudent)
                  }
              }
            ```
          
            □ We use the implementation to inject the entity manager into our DAO and we make the assignment accordingly
            within the constructor

            □ The implementation for the save method use the JPA entity manager to actually save this java object, which
            is accomplished by saying `entityManager.persist(theStudent)`

            □  By adding the @Transactional annotation to this method, it will handle the transaction management



        ○ Step 3: Update main app

          ■ Code will be explicit on the intellij code, here we will cover the basics

            ```java

              private void createStudent(StudentDAO studentDAO) {

                // create the student object
                Student tempStudent = new Student("Caio", "Ceretta", "caioceretta@gmail.com")

                // save the object
                studentDAO.save(tempStudent)


              }
            ``` 

        ○ DAO

          Student DAO <-> Entity Manager <-> Data Source <-> DB

        ○ Spring @Transactional

          ■ Spring provides an @Transactional annotation

          ■ Automagically begin and end a transaction for our JPA code
            □ No need for us to explicitly do this in our code

          ■ This Spring magic happens behind the scenes

        ○ Specialized Annotation for DAOs

          ■ Spring provides the @Repository annotation that is basically a "sub" annotation of @Component

          ■ @RestController, @Repository, and others, all point to the @Component annotation

          ■ This annotation is applied to DAO implementations and Spring will automatically register the DAO implementation
            □ Thanks to component-scanning

          ■ Spring also provides translation of any JDBC related exceptions, and by translation i mean that if we have
          any checked JDBC exceptions and then Spring translates them to unchecked exceptions and it make the coding
          easier for interfacing with a given database

        ○ Updated Version of DAO implementation

          ```java
              // imports

              @Repository
              public interface StudentDAOImpl implements StudentDAO {
                  private EntityManager entityManager;

                  public StudentDAOImpl(EntityManager theEntityManager) {
                    entityManager = theEntityManager
                  }

                  @Override
                  @Transactional
                  public void save(Student theStudent) {
                    entityManager.persist(theStudent)
                  }
              }
          ```
          
          ■ @Repository is an specialized annotation for repositories and DAOs, it gives us support to component scanning
          and also translating JDBC exceptions
          
  ## Lesson 12 ~ 13: Saving a Java Object with JPA - Coding

    ● For this lesson, we will also use the same crud demo application

    ● Coding steps

      ○ Step 1 - Define DAO Interface
        ■ Create new package under thr artifact name called dao and create a StudentDAO interface
          □ define a save method

      ○ Define DAO implementation
        ■ Define a StudentDAOImpl in the same package as the Dao
          □ Type this as a @Repository for jean to know which bean of the StudentDAO type to inject
          □ Override the save method from the interface 
          □ Use a @Transaction annotation in the save method since it performs an update to the database
          □ Define field for entity manager
          □ Inject entity manager using constructor injection

      ○ Update main app

        ■ On the Command line runner constructor, inject the StudentDAO
        ■ Call the createStudent method with the studentDao just injected
        ■ Since createStudent method does not exist, but the IDE understands its purposes, use the generate method and let
        the IDE to create this createStudent method which receives the student as property
        ■ Implement this createStudent method to persist a student object
          □ We can see that we are making use of the StudentDAO to communicate with the database, which is our helper/dependency.

  ## Lesson 14 ~ 15: Primary Keys

    ● In IntelliJ, alter the save method to save multiple students
      ○ After executing and refreshing the database we are able to see how mysql handles the auto increment of the id column

    ● How do we change the AUTO_INCREMENT values? 
      ○ For example, if i don't want to start the auto increment at number 1, i'd like to start it in a different number,
      like 1000, 5000... How can i do that? 
        ■ e.g. ALTER TABLE student_tracker.student AUTO_INCREMENT=3000

      ○ How do i reset the AUTO_INCREMENT value back to 1
        ■ e.g. TRUNCATE student_tracker.student, this will reset the database and reset the index to 1

  ## Lesson 16: Reading Objects with JPA - Overview

    ● Retrieving a Java Object with JPA

      ○ Retrieve/read a student from the database using the primary key of 1

        ```java
          Student myStudent = entityManager.find(Student.class, 1)
        ```

        ■ First parameter is the entity class, and the second one is the primary key
      
      ○ The example above is for the path where it finds a Student with that id, but if it doesn't find any, it returns
      null
    
    ● Development Process

      ○ 1. Add new method to DAO interface

        ```java
          // imports

          public interface StudentDAO {
            Student findById(Integer id);
          }
        ```

      2. Add a new method to DAO implementation

        ```java
          // imports

          public class StudentDAOImpl implements StudentDAO {
            private EntityManager entityManager/
            ...

            @Override
            public Student findById(Integer id) {
              return entityManager.find(Student.class, id)
            }
          }
        ```

          ■ Again, if it is not found, it returns null
          ■ We don't need to make use of the @Transaction annotation since we are only doing a query, not doing any
          updates or modifications to the db, it is simply read only

      3. Update main app

        ```java
          // imports

          @SpringBootApplication
          public class CruddemoApplication {
  
            @Bean
            public CommandLineRunner(StudentDao studentDAO) {
              return runner -> {
                readStudent(studentDAO)
              }
            };
          }
        ``` 

        and the code that will be created


        ```java
          // imports

        private void readStudent(StudentDAO studentDAO) {
          // create the student object
          System.out.println("Creating new student object");
          Student tmpStudent = new Student("Caio", "Ceretta", "caioceretta@gmail.com");

          // save the student object
          System.out.println("Saving the student object...");
          studentDAO.save(tmpStudent);

          // display id
          System.out.println("Saved student. Generated id: " + tmpStudent.getId());

          // Retrieve student based on the id: primary key
            System.out.println("\nRetrieving student with id: " + tmpStudent.getId())

          Student myStudent = studentDAO.findById(tmpStudent.getId())

          System.out.println("Found the student, " + myStudent)
      }
          
        ``` 

      . Since we have the id of the student, we can retrieve him based on that id and display then


    ● CommandRunner Recap

      ○  In this example

        ```java
          @Bean
            public CommandLineRunner(StudentDao studentDAO) {
              return runner -> {
                readStudent(studentDAO);
              };
            }
        ```

      runner is simply the parameter of the lambda function that CommandLineRunner exposes


      ○  CommandLineRunner is a Spring's functional interface

        □ It defines only one method

          void run(String ...args) throws Exception;
        
        □ This means that, whenever we create a CommandLineRunner, we are creating something that will be executed as
        soon as the app launches

        □ Which in this case, simply calls the readStudent method

        □ runner is only the name of the parameter that represent the arguments (String... args) that Spring passes when
        it initiates.

        □ It could also be written as

          . return args -> {
            readStudent(studentDAO)
          }

          . and it would have the same effect. `runner` is not a Spring's special variable — it is just the name we
          passed as the lambda's parameter         

      ○ In summary

        ■ CommandLineRunner runs after the Spring Boot is initialized
        ■ The parameter (runner, args, ou whatever name we choose) contains the arguments passed in the command line
        (String... args)
        ■ Inside the lambda's body we define what we want to execute on initialization (in this case, call readStudent)

  ## Lesson 17: Reading Objects with JPA - Coding

    ● For this lesson, we will use the same code as before

    ● Steps

      ○  1 - Add findId method to the DAO
      ○  2 - Add new method to DAO implementation and implement it public Student findById(Integer id) return
      entityManager.find(Student.class, id)
      ○  3 - Update main app

  ## Lesson 18 - Querying Objects with JPA - Overview

    ● JPA Query Language (JPQL)

      ○ Query language for retrieving objects

      ○ Similar in concept to SQL
        . where, like, order by, join, in, etc

      ○ However, JPQL is based on `entity name` and `entity fields`

      ○ Retrieving all Students

        ```java
          TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

          List<Student> students = theQuery.getResultsList();
        ```

        ■ Note: This is NOT the name of the database table (FROM Student), which mean that JPQL uses the name of the java
        entity
          □ All JPQL syntax is based on entity name and entity fields

      ○ Retrieving Students: lastName = 'Doe'

        ```java
          TypedQuery<Student> theQuery =  entityManager.createQuery(
                                                "FROM Student WHERE lastName=´Doe´", Student.class);
        
          List<Student> students = theQuery.getResultList();

        ```

        ■ lastName is the JPA name, the property from the @Column() annotation:
          □ @Column(name = "last_name")
          private String lastName < this one

      ○ Retrieving Students using OR predicate

        ```java
           TypedQuery<Student> theQuery =  entityManager.createQuery(
                                                "FROM Student WHERE lastName=´Doe´ OR firstName=´Daffy´", Student.class);

            List<Student> students = theQuery.getResultList();

        ```

      ○ Retrieving Students Using LIKE predicate

        ```java
           TypedQuery<Student> theQuery =  entityManager.createQuery(
                                                "FROM Student WHERE ´email´ LIKE ´%luv2code.com", Student.class);

            List<Student> students = theQuery.getResultList();
        ```

    ● JPQL - Named Parameters

      ○ In the previous examples, we hard-coded some of the data like, lastName = 'Doe' or email LIKE luv2code. However,
      we may want to use this as a parameter. A user may write something as Doe for a lastName form field and we may want
      to use it as a parameter, since we may want to read that information and search for the users name accordingly.

      ○ With JPQL we can make use of named parameters.

        ■ Example        
  ```java
            public List<Student> findByLastName(String theLastName) { 
              TypedQuery<Student> theQuery =  entityManager.createQuery(
                                                  "FROM Student WHERE lastName=:theData", Student.class);
                                                  
              theQuery.setParameter("theData", theLastName);

              return theQuery.getResultList();
            }
  ```

          □ In this example above, we defined a findByLastName which receives as parameter theLastName. We can now set
          a :theData name, prefixed by colons, which will show Java that it is a placeholder to be set later on.
            After creating the query, we are calling that constant we assigned the query to with .setParameter and set as
            parameter for `theData`, the argument received to be its value

    ● JPQL - select clause

      ○ The query examples so far did not specify a "select" clause 

      ○ That's because the Hibernate implementation is lenient and allows Hibernate Query Language (HQL)

      ○ For strict JPQL, the "select" clause is required
        ■ Example n. 1: 

        ```java
            TypedQuery<Student> theQuery = entityManager.createQuery(
                      "select s from Student s WHERE s.email LIKE ´%luv2code.com", Student.class)
        ```

          □ To follow JPQL standards strictly, we have to write our query such as /\

            . Where s is an "identification variable" / alias
              - Provides a reference to the Student entity object being returned
            . s - Can be any name
              - Useful for when we have complex queries 

        ■ Other examples, for strict JPQL

        ```java
          TypedQuery<Student> theQuery =
              entityManager.createQuery("select s from Student s WHERE s.lastName=':theData'", Student.class)
        ```

          □ Here, s is a reference to the Student entity 
          □ lastName is an actual field of the Java class

  ## Lesson 19 ~ 20 - Querying Objects with JPA - Coding

    ● For this lesson, we will use the same code as before

    ● Code steps - Lesson 1


      ○ Step 1 - Go to the StudentDao and implement the new findAll() method to the DAO
      ○ Step 2 - Create it in the StudentDao implementation
      ○ Step 3 - Update main app to use this 
        ■ Inside the main app, create a method named queryForStudents(studentDAO); which will call the new DAO findAll()
        method
      
    ● Code steps - Lesson 2

      ○ Finding a student by their last name

        ■ Step 1 - Add the findLastName method to the Dao interface, this method will receive a theLastName parameter
        ■ Step 2 - Inside the implementation, implement this findLastName method using JPQL variables

## Lesson 21: Updating Objects with JPA - Overview

  ● Update (U in CRUD)

    ○ Example code would be:

      ```java

        Student student = entityManager.find(Student.class, 1);

        // change first name to "Scooby"
        theStudent.setFirstName("Scooby")

        // update the entity
        entityManager.merge(theStudent)
      
      ```

      ■ In this we are simply finding the entity with entityManager.find. And calling a setter method in this object to
      change its value and perform a entityManager.merge, which tells the entity manager to update this given object or
      update the entity.
    
    ○ Update last name for all students

      ```java
        int numRowsUpdated = entityManager.createQuery(
                                  "UPDATE Student SET lastName=´Tester´")
                                  .executeUpdate()
      ```

      ■ Here we are updating the lastName for all students by making use of the entityManager.createQuery, we perform an
      update student lastName equal to "Tester".
      ■ Remember, Student is the name of the JPA entity class name and lastName is the field of the JPA entity.
      ■ We finish the createQuery command with a `executeUpdate()` to execute the statement
      
      ■ This will return the numbers of rows that were updated and assign it to toe the variable

    ○ Development Process to add this in our DAO

      1. Add new method to DAO interface
  
        ```java
          // import ...

          public interface StudentDAO {
            void update(Student theStudent);
          }
        ```

      2. Add new method to DAO implementation

        ```java
          // import ...

          public interface StudentDAOImpl implements StudentDAO {

            private EntityManager entityManager;

            @Override
            @Transactional
            public void update(Student theStudent) {
              entityManager.merge(theStudent);
            }
          }
        ```

        - Since we are are updating the database, and not just querying, there was no need for this annotation, but here
        we are performing an update 

      3. Update main app
      
        ```java
          // import ...

          @SpringBootApplication
          public class CruddemoApplication {
            ...

            @Bean
            public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
              return runner -> {
                updateStudent(studentDAO)
              }
            }

            private void updateStudent(StudentDAO studentDAO) {

              //retrieve student based on the id: primary key
              int studentId = 1
              System.out.println("Getting student with id: " + studentId);

              Student myStudent = studentDAO.findById(studentId);

              System.out.println("Updating Student...")

              //change first name to Scooby
              myStudent.setFirstName("Scooby");
              studentDAO.update(myStudent); 

              //display updated student
              System.out.println("Updated student: " + myStudent)

            }

            ...
          }
        ```

## Lesson 22: Updating Objects with JPA - Coding

  ● For this lesson, we will continue our cruddemo app and apply to it what we just saw

## Lesson 23: Deleting Objects with JPA - Overview

    ● Delete (D in CRUD): 

      ○ Simple Delete Example:

        ```java

          // retrieve the student
          int id = 2;
          Student theStudent = entityManager.find(Student.class, id);

          // delete the student
          entityManager.remove(theStudent);
        ```

          ■ Here we are simply finding the object via entityManager, assigning it to the student, and calling the remove
          method from entityManager with the existing object, which deletes the student from the database

      ○ Delete based in a condition:

        ```java
          
          int numRowsDeleted = entityManager.createQuery(
                        "DELETE FROM Student WHERE lastName=´Smith´")
                        .executeUpdate();
        
        ```

      ○ executeUpdate()

        ■ We may think, if we are executing a delete, why the command to run the query is to executeUpdate?

          □ In the API, the update method is simply a generic term, so it means that we are simply modifying the database

      ○ Delete all students

        ```java
          
          int numRowsDeleted = entityManager.createQuery(
                        "DELETE FROM Student ")
                        .executeUpdate();
        
        ```

        it will return the number of rows deleted

      ○ Development Process

        1. Add a new method to DAO interface

          ```java
            // ...
              void delete(Integer id);
            // ...
          ``` 

        2. Add new method to DAO implementation

          ```java
            // ...
              @Override
              @Transactional
              public void delete(Integer id) {
                Student theStudent = entityManager.find(Student.class, id);
                entityManager.remove(theStudent)
              }
            // ...
          ```

        3. Update main app

          ```java
            // ...
            // public Command Line Runner block
            {
              deleteStudent(studentDAO)
            }

            private void deleteStudent(StudentDAO studentDAO) {
              // delete student
              int studentId = 3;
              System.out.println("Deleting student id: " + studentId);
              
              studentDAO.delete(studentId)
            }

            // ...
          ``` 

## Lesson 23: Deleting Objects with JPA - Coding 1

  ● For this lesson, we will continue our cruddemo app and apply to it what we just saw

## Lesson 24: Deleting Objects with JPA - Coding 2

  ● In this lesson, in the intellij, we're going to play with the other mentioned types of deletion

    ○   int numRowsDeleted = entityManager.createQuery(
              "DELETE FROM Student WHERE lastName=´Smith´")
              .executeUpdate();

        return numRowsDeleted

      ■ This method may look ok, but intellij suggested that numRowsDeleted is redundant, so we simply returned:

        return entityManager.createQuery("Delete FROM Student").executeUpdate();

## Lesson 25: Create Database Tables from Java Code

  ● Previously, we created database tables by running a SQL script... But there's another option

    ○ JPA/Hibernate provides an option to 'automagically' create database tables

      ■ Create tables based on Java code with JPA / Hibernate annotations

      ■ Which is useful for development and testing

        Java Code -> JPA / Hibernate -> SQL -> Database

        . Meaning that there is no need for us to write any of SQL, it will generate and apply it "on the fly".
      
    ○ Configuration

      ■ In Spring Boot configuration file: application.properties, we are going to give this property

        □ spring,jpa.hibernate.dll-auto=create

        □ When we run our application, hibernate will drop the tables and create them again from scratch, and this is 
        all based on the JPA/Hibernate annotations that are in our java code

      ■ Java Code: 

        ```java

          @Entity 
          @Table(name="student")
          public class Student {
          
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "id")
            private int id;

            @Column(name = "first_name")
            private String firstName;

            @Column(name = "last_name")
            private String lastName;

            @Column(name = "email")
            private String email;

            // constructors, getters / setters 
          }
        ```

        □ This will create a table student, with the given column names, and hibernate will use this information to
        generate the SQL and execute it on the given database.
    
      ■ spring.jpa.hibernate.ddl-auto=PROPERTY-VALUE options

        . none -> no action will be performed
        . create -> Database tables are dropped followed by database tables creation (all data is lost)
        . create-drop -> Drops the databases tables and recreate on start up. On application shutdown, drop the databases,
                        so there will be nothing on the application, this is primarily used for unit testing
        . validate -> Validate the database tables schema
        . update -> Update the database tables schema
    
  ● Basic Projects
      
    ○ For ease of development and testing, we are going to use the auto configuration property "create"

    ○ Database tables are dropped first and then created from scratch. This will cause all data to be lost, but this is
    fine just for dev and testing.

    ○ If we want to create tables once and keep data, make use of the update config

    ○ However, we need to be aware it will alter the database schema based on latest code updates. We need to be careful
    and only use it for database projects. 

  ● Warning

    ○ Don't use the config property "create" on Production databases. 

    ○ We don't want to drop our production data.

    ○ Instead for Production, we should have DBAs run SQL scripts, and stay hands-off as much as possible.

  ● Use case

    ○ The use case for the create configuration, is useful for

      ■ Database integration testing with in-memory databases
      ■ Basic, small hobby projects

  ● Recommendation

    ○ In general, the instructor does not recommend auto generation for enterprise, real-time projects

      ■ Because we can very easily drop production data if we are not careful 

    ○ Instead, he recommend using SQL scripts

      ■ Corporate DBAs prefer SQL scripts for governance and code review.

      ■ The SQL scripts can be customized and fine-tuned for complex database designs.

      ■ We can also work with schema migration tools such as Liquibase and Flyway







