
Lesson 1 -  Spring boot overview

### First of all, what is Spring?

Spring is a framework for the Java language, often used to develop web applications, REST APIs, corporate systems, etc

It provides multiple tools, like:

. Dependency Injection (to control objects other classes use)
. HTTP Requests Control (GET, POST, etc)
. DB Access (with JPA/Hibernate)
. Security (Authentication, Authorization)

But: it requires multiple manual configuration. It´s powerful, but it is verbose and with a high learning curve.


### Spring in a Nutshell

. Very popular framework for building Java applications
. Provides a large number of helper classes and annotations


### The Problem

. Building a traditional Spring application is really hard
  The issue is that some questions arise
    Q: Which JAR dependencies i need?
    Q: How do i set up configuration (xml or Java)? 
    Q: How do i install the server? (Tomcat, JBoss, etc...)

### Spring Boot Solution

Spring boot is a Springs's sub project created to easy Spring apps creation.

. Spring Boot make it easier to get started with Spring development
. Minimize the amount of manual configuration
  . Perform auto-configuration based on props files and JAR classpath
. Help to resolve dependency conflicts (Maven or Gradle)
. Provide an embedded HTTP server so we can get started quickly
  . Tomcat, Jelly, Undertow, ...


### Initializing a Spring project

Spring Boot provides us the Spring Initializr, which is a site used to quickly create a starter Spring project.

Where we select the options and dependencies, it will create a Maven/Gradle project for us which we can download and import
it inside our IDE, such as Eclipse, Intellij, Netbeans, etc., or we can simply use a plain text editor and use maven in
the command line and we are good to go.

### Spring Boot Embedded Server

. Spring Boot provides an embedded http server so we can get started quickly
. No need to install server separately, it would be something ass

mycode  <- JAR file, includes the application code and the server.
tomcat    

this means that tomcat (the embedded server) will be part of our JAR file. And the nice thing about this approach is that
it is a self contained unit, we don't have to install anything else, the application server is part of our code.


### Similarities to package.json

Similar to package.json from node projects, the main differences/similarities are: 

| Concept                     | `pom.xml` (Java + Maven)                                  | `package.json` (JavaScript + npm/yarn)                    |
|----------------------------|------------------------------------------------------------|-----------------------------------------------------------|
| **Dependency Manager**     | Uses **Maven** (or Gradle in some projects)                | Uses **npm** or **yarn**                                  |
| **File Format**            | **XML** (structured and verbose)                           | **JSON** (concise and readable)                           |
| **Declaring Dependencies** | Inside `<dependencies>` with `<dependency>` blocks         | Inside `"dependencies"` and `"devDependencies"`           |
| **Installing Dependencies**| Automatically during build or with `mvn install`           | Explicitly with `npm install` or `yarn install`           |
| **Running the App**        | `mvn spring-boot:run` (via Maven plugin)                   | `npm start` (defined in `"scripts"`)                      |
| **Build Process**          | `mvn package` (generates `.jar` or `.war` files)           | `npm run build` (depends on bundler: Webpack, Vite, etc.) |
| **Version Management**     | `<version>` defined manually per dependency                | Versions use semver symbols like `^`, `~`, `latest`, etc. |
| **Automation Scripts**     | Uses **Maven plugins** (e.g., `spring-boot-maven-plugin`)  | Uses `"scripts"` to define CLI commands                   |
| **Package Registry**       | Maven Central, JitPack, custom repositories                | npm registry (default), or custom with config             |
| **Removing Dependencies**  | Manually remove from `pom.xml`                             | `npm uninstall <package-name>`                            |
| **Typical Use Case**       | Enterprise back-end apps (Spring Boot), Android apps       | Front-end (React, Vue), Node.js APIs, full-stack JS apps  |


### Running Spring Boot Apps

. Spring Boot apps can be run standalone (includes embedded server)
. Run the Spring Boot app from the IDE or command-line

Therefore, in the example above, we would run in the command line: `java -jar mycoolapp.jar` 

### Deploying Spring Boot Apps

. Spring Boot can also be deployed in the traditional way 
. You can deploy a WAR file to an external server such as Tomcat, JBo, WebSphere, etc, and it it will work just like it 
it did in the past

  Let's consider an example: 
  Suppose we have a Tomcat server running in some corporate server. We can simply take our Spring Boot application, package
  its WAR file and deploy it inside that Tomcat server.
  In this case, since we're deploying the app in the traditional way, we don't need an embedded server — it's already
  provided by Tomcat. Also, our WAR file will typically include our application code as the server itself will handle the
  rest of the run environment.

  This Tomcat server can also host other WAR applications from other teams. The spring boot would run normally alongside
  the other traditional java apps

### Common Questions - Lesson 1

1. Does Spring Boot replace Spring MVC, Spring REST, etc...? 

. No, instead, Spring Boot actually uses those technologies in the background, such as Spring MVC, Spring REST, Spring Core,
etc. Spring boot can use all those technologies in the background, there's no competition, nor replacement. Spring Boot
is mainly about configuration, once we do our spring boot config, we can make use of regular Spring coding. It simply
helps us to start quickly with minimal configuration.

2. Does Spring Boot run code faster than regular Spring code? 

. No. Behind the scenes, Spring Boot uses same code of Spring Framework.
. Remember, Spring Boot is about making it easier to get started, minimizing configuration, etc.

3. Do we need special IDE for Spring Boot? 

. No. We can use any IDE for Spring Boot apps... even use plain text editor.
. The Spring team provides free Spring Tool Suite (STS) and a collection of IDE plugins
. Some IDEs provide fancy Spring tooling support, but it's not a requirement.

## Lesson 2 - Initializr

### Spring Initializr

. Quickly create a set Spring project
. Select your dependencies
. Creates a Maven/Gradle project, which we can download after generated.
. Import the project into our IDE
  . Eclipse, IntelliJ, Netbeans, etc..

### Quick Word on Maven

. When building our Java project, we may need additional JAR files
  . For example: Spring, Hibernate, Commons Logging, JSON, etc...
. One approach is to download the JAR files from each project website and manually add them to our build path

e.g. / classpath

. We simply tell `Maven` the projects we are working with (dependencies), such as Spring, Hibernate, etc.
. Maven will go out and download the JAR files for those projects for us.
. And maven will make those JAR available during compile / run
. We can think of Maven as our friendly helper/personal shopper, for example, we tell "Maven i need the dependencies
A, B, C and D" and maven will go out, grab those JAR files, add them to our class path and make them available during
compile and run.

### Development Process

1. Configure our project at Spring Initializr website: `http://start.spring.io`
2. Download the zip file
3. Unzip the file
4. Import the project into our IDE

.Group Id: Namespace used to identify who is creating the project, generally based on the org domain reversed, like
com.example
.Artifact: Project name

after setting these two, the package name will be `group.artifact`

### Most common dependencies

Spring Web: For creating REST APIs, MVC, etc. Includes controllers support, embedded tomcat, etc.

Database access: 

Spring Data JPA: Facilitate relation db integration using JPA and Hibernate
JDBC API: direct access via JDBC, in case we want manual queries
H2 Database: In-memory database (used for local tests)
PostgreSQL Driver or MySQL Driver: Database driver

Security and Authentication:

Spring Security: Adds authentication / authorization (login, roles, etc)

Tests:

Spring Boot Test: Included by default in many cases. It supports JUnit, Mockito, etc.

Tests Validation: 

Validation (JSR-380)

API Documentation

Springdoc OpenAPI or Swagger UI: Generates API rest interactive documentation.

E-mail Sending

Spring Boot Starter Mail: Sending e-mails with SMTP (ex: Gmail, Mailgun, etc.)

Useful Extras: 

Lombok: Avoids code repetition (getters, setters, @Builder, etc.)
Sprint Boot DevTools: automated refreshes, helps in local development
Actuator: Provides endpoints for app monitoring (/actuator/health, etc.)

***

#### Common combination for a REST API with database: 

. Spring Web
. Spring Data JPA
. PostgreSQL Driver
. Validation
. Lombok
. Spring Boot DevTools

***

However, for this first project, the instructor only added the web dependency for now.

### Application file

The main Java application file — typically named ArtifactNameApplication.java — is annotated with @SpringBootApplication.
Inside its main method, the application is bootstrapped using SpringApplication.run(ClassName.class). For testing purposes, 
we can simply right-click this file and run it as a Java application. There's no need for an external server, as Spring
Boot comes with an embedded server built-in.
 
## Lesson 3 - REST Controller

For initializing a Rest controller, we simply say the @RestController in a controller file .java

Now, we simply `expose` the / path and it returns hello world with

@GetMapping("/") <- Handle HTTP Get Requests
public String sayHello() { 
/* In Java, including Spring Boot, at this part public -> means the method is public | String -> the method returns a
string | sayHello() <- Module name *\

return "Hello World"

}

## Packages

### What are packages? 

In Java (and Spring Boot is a Java framework), a package is like a namespace that groups related classes together. It's
a logical structure used to organize our code.

#### Are packages similar to folders? 

Yes — but with a key difference

. A Java package (like com.example.project.service ) corresponds to a folder structure in our system, like `/com/example/project/service'
. So yes, they behave like folders on disk, but they also define a "scope" for classes in Java (accessibility, imports, etc).

Example: 

If we have this Java class: 

```java

  package com.example.demo.controller; 

  public class UserController {
    // Code here
  }

```

it must be saved in a file path like:

`src/main/java/com/example/demo/controller/UserController.java`

Otherwise, the project won't compile

#### Why are packages useful in Spring Boot? 

. They organize code into features or layers (like `controller`, `service`, `repository`, etc.)
. Spring Boot uses component scanning, which automatically finds beans/components inside our package (and subpackages).
  . So placing our classes inside the right package structure matters! 

#### Typical package structure in a Spring Boot project

com.example.demo
  ├── controller     // for @RestController and @Controller classes
  ├── service        // for business logic (@Service)
  ├── repository     // for database access (@Repository)
  ├── model          // for data classes (like @Entity, DTOs)
  └── config         // for @Configuration and security beans


In Summary

Concept	   Description
Package	   A logical namespace for organizing Java classes
Folder	   The physical directory that matches the package
Are they   similar?	Yes — each package maps to a corresponding folder


#### End packages explanation

To create a new package, simply double click the folder -> new package -> append to the path the name of the package we
want.

for a simple hello world example. inside the project package, we created another package named rest, inside a FunRestController
and used @RestController (To inform java this is a rest file and should respond to requests), and inside the controller
scope, we added a @GetMapping("/") and the method, GetMapping is used to expose that path

## Lesson 4 - Spring Projects

What are Spring "Projects"? 

. Additional Spring modules build-on top of the code Spring Framework
. Only use what you need...

  . Spring Could: For cloud development, Spring Data: For database integrations

  . Spring Batch: for batch processes, Spring Security: For securing our application
  . Spring Web Services: to create RESTful web services and SOAP.
  . Spring LDAP: Accessing LDAP Services
  . others...

These are some projects that we can use on our application development IF NEEDED. But. then again, these are all optional.

To get information about these projects we simply go to `www.spring.io` website, search projects, and see if any project
available online can be useful to us

## Lesson 5 - Maven

. When we generate projects using Spring Initializr: `start.spring.io`
  . It can generate a maven project to us

. In this section, we will learn the basics of maven
  . Viewing dependencies in the Maven pom.xml file
  . Spring boot Starters for Maven

### What is Maven? 

  . Maven is a Project Management tool
    . Most popular use of Maven is for build management and dependencies.

### What problems does Maven solve? 

  . When building our Java project, we may need additional JAR files
    . For example: Spring, Hibernate, Commons Loggings, JSON, etc...
  
  . One approach is to download the JAR files from each project web site.

  . Manually add the JAR files to our build path / classpath

### What is build path / classpath?

When developing using Java, "class path" and "build path" are ways of telling to the compiler (and after to the JVM) where
to find the classes and libraries that our code uses to run,

We don't need to configure them when using Maven or Gradle: Maven downloads everything, put them in a local folder, such
as `~/m2/repository`, updates the build path and class path automatically within the project.

If we are using a IDE like IntelliJ or Eclipse, it integrates to Maven and does this configuration internally

 The differences between them are

 . Class Path: 
    Path used in `execution time` (when the program is running) to locate classes, like our own or from external libraries
    (.jar for example)

 . Build Path: 
    Path used in `compilation time` (when we are building the project) to find  these same classes.

In practice, both paths usually are the same, but focuses on different moments of the application life-cycle.

#### Where does Maven enters in this?

  When we use Maven:

      . We declare the dependencies in the pom.xml
      . Maven automatically downloads them
      . He always configure the class path and the build path automatically

  This is, we don't need to worry about manually downloading .jar nor configuring them in Eclipse/IntelliJ. Maven does
  this to us.


### Our project without Maven would be

My Super Cool App
  Spring
  Hibernate
  Common Loggings
  JSON
  ...

let's say that those projects are needed for the app, and we as a developer, go to each of these projects website, download
its JAR files and manually add those to our build path.

### Maven Solution

. The Maven solution is to tell Maven the projects we are working with (dependencies)
  . Spring, Hibernate, etc...

. Maven will go out and download the JAR files for these projects for us.

. And Maven will make those JAR files available during compile / run

My Super Cool App
  Spring
  Hibernate
  Common Loggings
  JSON
  ...

Now with Maven it will simply go and download these JAR files for us and pull it to our computer. Instead of us, as developers
having to do all the manual work. 

### Maven - How it works behind the scenes

```
  Project Config File

  Spring
  Hibernate
  Commons Loggings
  JSON
  ...

  developer part
``` 

On the big picture, it works like this

Maven will read this and "go shopping": It will read our config file -> check our local repository that resides in our
computer -> if we don't have the files in our local repo, maven go out in the internet, into the central repository
(remote) -> pull those JAR files -> Save versions of those files in our local repository so we can build our local cache
-> Maven will use that to build and run our application 

### Handling JAR Dependencies

. When Maven retrieves a project dependency
  . It will also download supporting dependencies
  . For example: Spring depends on common-logging... 

### Building and Running

  . When we build and run our app...
  . Maven will handle class / build path for us
  . Based on config file, Maven will add JAR files accordingly


## Lesson 5 - Standard Directory Structure

  `The default folder structure is:
  src/main/java/<groupIdDomain>/<groupIdSubdomain>/<artifactId>

  For example, if your Group ID is example.com and your Artifact ID is lov2code,
  the structure becomes:
  src/main/java/com/example/lov2code`

. Normally, when joining a new project team:
  . Each development team dreams up their own directory structure
  . Not ideal for new comers and not standardized

. Maven solves this problem by providing a standard directory structure

Let's take an app named my-super-cool-app as example: 

my-super-cool-app/
  pom.xml
  src/
    java/
    resources/
    webapp/
  test/
    java/
    resources/
  target/

  where: 

    /pom.xml: maven configuration file
    src/main/java: Java source code
    src/main/resources: Properties / config files used by our app
    src/main/webapp: JSP files and web config files, other web assets (images, css, js, etc)
    src/test: Unit test code and properties
    target: Destination directory for compiled code. Automatically created by `Maven`

  Back to this example, src/main/java is where the source code will reside. Therefore, our controllers, dao, entities,\
  services are going to be inside the folder with the project name


  ### Web application Directory

  The structure here is similar, but there's going to be a webapp folder, where we're going to place our web assets in
  it: JSP files, any configuration files, css, images, and so on.

  ### Standard Directory Structure Benefits

  . For new developers joining a project
    . They can easily find code, properties files, unit tests, web files, etc. 
  
  . Most major IDEs have built-in support for Maven
    . Eclipse, IntelliJ, NetBeans, etc
    . IDES can easily read/import Maven projects 
  
  . Maven projects are portable
    . Developers can easily share projects between IDEs
    . No need to fight about which IDE is the best

  ### Advantages of Maven

    . Dependency Management
      . Maven will find JAR files for us
      . No more missing JARs

    . Building and Running our Project
      . No more build path / classpath issues
    
    . Standard Directory Structure

    . Learning maven allow us to run a project with minimal local configuration

## Lesson 6 - Maven key concepts

. POM File - pom.xml

  . Project Object Model file
  . Configuration file for out project
    . Basically our "shopping list" for Maven
  . Located in root of our Maven project

  - Structure

  . project metadata: information about our project — Project name, version, etc. Output file type: JAR, WAR,  ...
  . dependencies: list of projects that we depend on in order to run
  . plug ins: additional custom tasks to run: generate JUnit test reports, and so on.

  - Simple POM File

    <?xml version="1.0" encoding="UTF-8"?>
    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
      <modelVersion>4.0.0</modelVersion>
      <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.3</version>
        <relativePath/> <!-- lookup parent from repository -->
      </parent>
      <name>mycoolapp</name>
      <dependencies>
        <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <build>
          <plugins>
            <plugin>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
          </plugins>
        </build>

    </project>


  ### Project Coordinates

  . Project Coordinates Uniquely identify a project
    . Similar to GPS coordinates for our house: latitude / longitude
    . Precise information for finding our house (city, streets, house #)

    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.5.3</version>

  In a house address it would be like groupId is the city, the artifactId the street, and the version is the house number

  ### Project Coordinates - Elements

  Group Id: Company name, group or organization. Convention is to use reverse domain name com.luv2code (convention used
  for java package names)

  Artifact Id: Name for this project, the ID of the artifact

  Version: A specific release version like: 1.0, 1.6, 2.0
  If project is under active development then: 1.0-SNAPSHOT

  ### Example for project coordinates

    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>6.0.0</version>

    or

    <groupId>org.hibernate.orm</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>6.1.4.Final</version>

  
  ### Adding Dependencies

    If we want to add some support for Spring and Hibernate,

    <project ...>
      <dependencies>
        <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring.context</artifactId>
          <version>6.0.0</version>
        </dependency>
        <dependency>
          <groupId>org.hibernate.orm</groupId>
          <artifactId>hibernate-core</artifactId>
          <version>6.1.4.Final</version>
        </dependency>
      </dependencies>
    </project>
  
    Here we have references for the projects, a lot like the projects description from our pom.xml

  ### Dependency Coordinates

    . To add given dependency project, we need

      . Group ID, Artifact ID  
      . Version is optional
        . Best practice is to include the version (repeatable builds) — best practice for DevOps, we should be able to 
        say: "Hey, our project works with version x.y.z of a given project, this way we know that that part has been
        tested, verified, and work"

      . May see this referred to as GAV: Group Id, Artifact Id, Version

  ### How to find dependency coordinates

    Option 1: Visit the project page (sprig.io, hibernate.org, etc) — they will give the details that we'll need to add
    their project using maven

    Option 2: Visit `https://central,sonatype.com/` (easiest approach) — go to the maven central repository and search for
    the projects and also get those details

  ## Lesson 7 - Exploring Spring Boot Project Files - Part One

  ### Spring Initializr

  . Creates a Maven project for us 
  . Let's cover everything it created

  Spring Boot uses the main Java standard directory structure

  src/main/java - Where we place our Java source code
  src/main/resource - Default directory for resource files the application will use in execution time, such as .properties
  (ex: application.properties), .yml files, XML configuration files, static files, like templates, images or text files,
  .sql for database initialization, etc.
  src/test/java - unit testing source code

  ### Maven Wrapper Files

  mvnw and mvnw.cmd: Maven wrapper files, the mvnw allows us to run a project with no need to have Maven installed or
  present on our path, if the correct version of Maven is NOT found on our computer it automatically downloads correct
  version from internet and runs Maven

  Two files are provided
  
  . mvnw.cmd for MS windows <- mvnw clean compile test
  . mvnw.sh for Linux / Mac <- ./mvnw clean compile test

  That is the basic idea of these wrapper files, they will automatically download and run the correct Maven version for
  us
  Therefore, if we already have Maven installed previously, then we don't need the mvnw files, can even safely delete
  them, just use it as we would normally use, using commands like `mvn clean compile test`.

  ### Maven POM file

  The pom.xml includes info that we entered at Spring Initializr website, such as the groupId, artifactId and so on — that
  information is automatically in our generated pom file.

  We also have a collection of maven dependencies in the file too. We can notice that they are called starters, like: 
  `<groupId>org.springframework.boo</groupId>
  <artifactId>spring-boot-starter-web</artifactId>`

  These are spring boot starters, is just a collection of maven dependencies and these are the compatible version for
  these dependencies — the boot-starter-web is a collection of dependencies (spring-web, spring-webmvc, hibernate-validator
  tomcat, json, ...).
  
  Therefore, what this does is that it saves the developer from having to list all the individual
  dependencies and also makes sure we use compatible versions.

  #### Spring Boot Maven Plugin

  In the POM file there's also a section for Spring Boot Maven plugin, so we'll actually see it in the bottom of the POM
  file.

  `<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
  </plugin>`

  Here, this plugin is used to package an executable JAR file that we can run in the command file or to create a .war archive
  file. We can also use this plugin to easily run the application with

  `./mvnw package
   ./mvnw spring-boot:run`

  And this will run the application, and as we saw, if we already have Maven installed in our computer we don't need the
  ./mvnw stuff , but only mvn package. It's up to us.

  ### Java Source Code

  When we generate our actual project we have the main spring boot application class, created by the initializr, as, for
  example MycoolappApplication.java. When we created our rest controller test, inside the java app folder, we created a
  rest package and a controller inside, where we used this controller to expose a very simple API. 

  
  









   







    


