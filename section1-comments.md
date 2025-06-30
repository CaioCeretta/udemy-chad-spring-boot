
## Lesson 1 -  Spring boot overview

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


## Lesson 6 - Standard Directory Structure

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

## Lesson 7 - Maven key concepts

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

  ## Lesson 8 - Exploring Spring Boot Project Files - Part One

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

  ## Lesson 9 - Exploring Spring Boot Project Files - Part Two

  ### Application Properties

  . By default, Spring Boot will load properties from: application.properties, which is created by default by the Spring
  Initializr, it starts empty, but it usually consist of application properties such as: 

  . server.port=8585: This changes the default behavior of starting the server on 8080, but to listen to different ports
  . coach.name=John Doe  
  . coach.team=random name -- Which are custom properties and we can give as many properties as we would like. ---

  ### Read data from: application.properties

  We know application properties is under src/resources/ folder and we can read data from it making use of `injections`.

  Let's use the FunRestController we created, in the class scope we use, for example

  @Value("${coach.name}")
  private String coachName;

  We are now injecting this coach.name from our application.properties and assigning it to the attribute coachName, then
  for the order property we would simply

  @Value("${coach.team}")

  private String coachTeam;

  ### Static Content

  By default, Sprint Boo twill load static resources from the /static directory (such as html files, css, js, images, etc).

  We simply place them in the static directory and Spring Boot will load it automatically in the application.

  ### WARNING WE NEED TO BE AWARE OF

  Do not use src/main/webapp directory if our application is packaged as a JAR.

  Although this is a standard Maven directory, it works only with WAR packaging.

  It is silently ignored by most build tools if we generate a JAR

  ### Templates

  . Spring Boot includes auto-configuration for following template engines

  . FreeMarker, Thymeleaf, Mustache

  By default, Spring Boot will load templates from "/templates" directory, inside the resources directory.

  ### Unit Tests

  Spring Initializr already creates one, in our src directory, it will create a test/ directory inside src/, it will
  include a file named, for example, `MycoolappApplicationTests.java`. Initially this file is very basic, there is no
  real code, we add our own custom tests in this file. 

## Lesson 10 - Spring Boot Starters

### The Problem

Building a Spring application is really hard

. FAQ: Which maven dependencies do i need? 

### WHy is it so Hard?

. It would be great if there was a simple list of Maven dependencies.
. Collected as a group of dependencies... as a one-stop-shop
. So i don't have to search for each dependency and see what is available

¨There should be an easier solution¨ 

### Solution - Spring Boot Starters

. A curated list of Maven dependencies
. A collection of dependencies grouped together
. Tested and verified by the Spring Development team
. Makes it much easier for the developer to get started with Spring
. Reduces the amount of Maven configuration


### Spring MVC

. For example, when building a Spring MVC app, you normally need to add the springframework, hibernate-validator, thymeleaf
on our Maven dependencies. So, a lot of stuff we need to do individually, as for as listing out the dependencies.

### Solution: Spring Boot Started - Web

. Spring Boot provides: spring-boot-starter-web

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>

. By simply adding this single entry into our maven file, it is a spring boot starter, which is a collection of maven
dependencies with compatible versions
. This starter dependency contains: spring-web, spring-webmvc, hibernate-validator, json, tomcat, etc. A lot of stuff
"for the price of one"
. Saves the developer from having to list all of the individual dependencies, also makes you have compatible version

### Spring Initializr

. In spring initializr simply selected *Web* dependency
. We automatically get `spring-boot-starter-web` in `pom.mxl`
. Once we select `Spring Web`  on the list, we can notice that this web starter, will give support to Tomcat and Spring MVC.


#### Example: We are building a Spring App that needs Web and Security

. Simply select the dependencies in the Spring Initializr, such as:
  - Spring Web, Spring Security, Spring Data JPA, Thymeleaf

. When generating, it will add the appropriate Spring Boot starters to our pom.xml

#### End

There are more than 30 Spring Boot Starters from the Spring Development Team, such as

. spring-boot-starter-web: Building web apps, includes validation, REST, uses Tomcat as default embedded server
. spring-boot-starter-security: Adding Spring Security support
. spring-boot-starter-data-jpa: Spring database support with JPA and Hibernate
. ...

For a full list of spring boot starters, we can go to `www.luv2code.com/spring-boot-starters` that will redirect to the
Spring documentation that will list all the spring boot starters.

### What is a Starter? 

. FAQ: What is spring-boot-starter-xyz?

. 1st Approach
To know what is inside of it, we must first check its `pom.xml`, but it normally references other starters, so we have
to dig a bit and is quite cumbersome to work through it.

. 2nd Approach
Make use of the IDE (Most IDEs have a Dependency Management / View feature), and this is much easier to navigate, here's
how: 

1. For Eclipse Users

. Open pom.xml
. Select the tab "dependency hierarchy" at the bottom
. Expand the desired starter and we can see everything it includes

2. For IntelliJ Users

. Click on View > Tool Windows > Maven Projects > Dependencies
. Expand whichever starter we want.

## Lesson 11 - Spring Boot Starter Parent

spring-boot-starter-parent is a parent POM provided by Spring Boot. He is included in our maven project to inherit a series
of useful default configurations, preventing us from needing to write all of it manually

### What he does for us?

  By using this parent, Maven automatically applies multiple configurations and good practices defined by the Spring BOot
  team

  1. It manages the dependency versions

    . It already defines the correct and compatible version of hundreds of libraries that Spring Boot uses
    . This means that we don't need to specify the version of most dependencies in our pom xml's <dependency> 

    Example

    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
      <!-- Doesn't need to specify the version, only in the parent, which ensures that every dependency share the same
      version as the parent, making sure that they are all compatible -->
    </dependency>

  2. Defines the Maven default configuration

    For example: 

      . Java compiler version (by default, Java 17 or other one according to Spring Boot's version), however, if we would
      like to change the default, we simply add a new tag <properties> and set <java.version> to whatever version we want
      . File encoding: UTF-8
      . JAR packaging configurations
      . Maven plugins already configured: maven-compiler-plugin, maven-surefire-plugin, etc

  3. It easies good practice inheritance

    We inherit stable and tested configuration from the Spring boot team. This reduce errors and ensures compatibility.

  4. Typical pom.xml structure

    ```xml
      <parent>
        <groupId>org.spring.framework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.0.0-RC1</version>
        <relativePath /> <!-- Lookup parent from repository>
    ```

  However, we must pay attention, the parent is not required, but it is highly recommended for projects that uses Spring
  Boot with Maven.

  Also, the starter parent provides the default configuration of spring boot plugin, such as

  ```xml
  <build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
  ```

  ### How does build plugin relates to the parent and how to execute

  The <parent> block inherits configuration from `spring.boot.starter-parent`, including

  . Default plugin versions
  . Common plugin configurations

  This means we don't need to manually configure version numbers for plugins like

  ```xml
  <plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
  </plugin>
  ```

  `spring-boot-starter-parent` contains a section called <pluginManagement>. Inside of it, it registers the plugin
  `spring-boot-maven-plugin` (and others)
  . When our project inherits this `parent, everything inside <pluginManagement> can be used with no explicit version
  in our plugin

  In our pom.xml, the build groupId and the artifactId are the same as the one in <pluginManagement>, and Maven identifies
  this correspondence by these two attributes, they are the "key" that links the plugins defined in the parent with the 
  ones used in the project.

  Therefore, there is no need to additional configuration, Maven does everything for us, we just need to run

  `> mvn spring-boot:run`


  ### Benefits of the Spring Boot Starter Parent

  . Default Maven configuration: Java version, UTF-encoding, etc
  . Dependency Management
    . Use version on parent only
  . spring-boot-starter-* dependencies inherit version from parent
  . Default configuration of Spring Boot plugin

## Lesson 12 - Spring Boot Dev Tools

### The Problem

  . When running Spring Boot applications
  . If you make changes to your source code
  . Then you have to manually restart your app

### The solution

. spring-boot-devtools
. automatically restarts your application when code is updated
. simply add the dependency to your POM file
. no need to write additional code
. In others IDE this functionality works out of the box, however for IntelliJ some additional configuration is needed

### IntelliJ config

. Does not support Spring Boot Dev Tools by default
. Select: Preferences -> build, execution, deployment -> compiler
  . Check box: Build project automatically

. Additional Setting
. Select: Preferences -> Advanced Settings
  . Check box: Allow auto-make to start ...

Once we made these two setups, then IntelliJ Community Edition will be able to work with spring boot dev tools

### Spring Boot Dev Tools

. In order to use spring boot dev tools, we simply add

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
</dependency>

. By adding this, it will automatically restart our application when the code is updated

### Development Process Recap

1. Apply IntelliJ configurations
2. Edit pom.xml and add spring-boot-devtools
3. Add new REST endpoint to our app
4. Verify the app is automatically reloaded.


## Lesson 13 - Dev Tools - Coding

. Creating folder to hold all section 1 projects
. Moving mycoolapp to this folder and renaming it to 01-spring-boot-demo
. Copying mycoolapp and renaming the copy to 02-dev-tools-demo
. Open folder in IntelliJ
. Go to settings -> build, execution, deployment -> compiler tab -> check "build project automatically"
. Go to settings -> advanced settings -> check "allow auto-make to start..."
. Open pom.xml and add spring-boot-devtools dependency

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
		</dependency>

  ### Why is dev tools groupId the same as the parent one? 

  . The groupId is the same as the parent one, meaning that both are part of the same project maintained by Spring Boot
  they are not directly connected by inheritance in pom.xml.

  .Parent is inheriting configuration from the spring=boot-starter-parent, which is a SPring Boot pom, when adding this
  dependency we are simply saying to add this dependency to that specific group.
  
  . The relation between them is: 
    . Both belong to the same Spring Boot project, with the same groupId, that's why they seem related
    . The parent (starter-parent) centralizes and define default Spring-Boot versions
    . This means we don't need to define a version

  In Conclusion

  . Yes, the dependency groupId is "conceptually related" to the parent, because they come from the same eco-system
  . But, in terms of XML structure, the groupId of a dependency isn't directly inherited by the parent — what the parent
  does is simply providing versions, configurations and default plugins

  ### End

  . Open the controller and a new REST endpoint and test it out


## Lesson 14: Spring Boot Actuator

Problem

. How can i monitor and manage my application? 
. How can i check the application health? 
. How can i access application metrics

### Solution: Spring Boot Actuator

  ##### What is it? 

  . Exposes endpoints to monitor and manage our application
  . We easily get DevOps functionality out of the box (works automatically with no additional configuration)
  . Simply add the dependency to our POM file
  . REST endpoints are automatically added to our application


  ####  Actuator Dependency 
  . We simply add new dependency to our POM file

  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
  </dependency>

  . This will enable  spring boot actuator and give support for these metrics and monitoring of the app
  
  #### Actuator Endpoints 
  
    All the endpoints metrics are exposed with the prefix /actuator, and they are: 

    . /health: checks the status of our application
      . By default, only /health is exposed, 
      . Normally used by monitoring apps to see if our app is up or down
      . localhost:8080/actuator/health would give us { "status": "UP" }, this help status is customizable, so we can
      customize it using our own custom business logic.

    . /info: provide information of the app
      . to expose /info we need to update applications.properties
          management.endpoints.web.exposure.include=health, info
          management.info.env.enabled=true
      . The default is an empty json object, so in order for it to return something inside of it, we need to customize
      the application.properties.
        e. g. info.app.name=any name info.app.description=any description info.app.version= any version
      . Now, any properties starting with info will be used by /info

    . /auditevents: Audit events for our application
    . /beans: List of all beans registered in the Spring application context
    . /mappings: List of all @RequestMappings paths
    . full list in `www.luv2code.com/actuator-endpoints`

  #### Exposing Endpoints

  . By default, only /health is exposed
  . To expose all actuator endpoints over HTTP

     . In application.properties, we can make use of the * wildcard to expose all endpoints
     , We can also expose individual endpoints with a comma-delimited list\
     . But for now, using the wildcard, it is:
        management.endpoints.web.exposure.include=*

  #### What are beans? 

  Essentially, a bean is just a regular Java object (POJO) that is created, configured, and managed by Spring so we don't
  have to manually create it ourselves.

  ```java

  public class MyService {
    public void doSomething() {
        System.out.println("Doing something important...");
    }
  }

  ```

  This class becomes a Spring bean because of the @Component annotation. Spring will:

    . automatically detect it
    . create an instance of it
    . inject it wherever needed (e.g, using @Autowired or constructor injection)

  #### Listing Beans Through the Actuator

    . Access `http://localhost:8080/actuator/beans`
    . It will give us a JSON dump of all the beans registered in the application context

     
## Lesson 15 Spring Boot Actuator - Accessing Endpoints - Part 1

For this lesson, we simply copied the dev tools project

add this to application.properties

management.endpoints.web.exposure.include=health,info
management.info.env.enabled=true

update maven and run /actuator/health and /actuator/info, which will be empty by now

## Lesson 16 Spring Boot Actuator - Accessing Endpoints - Part 2

Editing application.properties to customize /info

it can be as simple as

info.app.name=My Super Cool App
info.app.description=A crazy fun app, yohoo!
info.app.version=1.0.0

now, every custom property starting with info, should appear on localhost:8080/actuator/info

### Wildcard "*"

. The * wildcard exposes all endpoints
. It can also expose individual endpoints with a comma-delimiter
. Now we can view endpoints such as /beans or /threaddump (useful for analyzing and profiling application's performance)
 or /mappings (useful for finding out which request mappings are available)

 ## Lesson 17 - Securing Endpoint

  . Previously we saw how to make all endpoints available on the url
  . However, we probably may not want to expose all of this information for anyone on the web
  . Add Spring Security to project and endpoints are secured
  . We can do it by adding the dependency

  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
  </dependency>

  . The only caveat is that the /health will still be available, but we can disable it

  
  ### Secured Endpoints

  . Now, when accessing /actuator/beans
  . Spring security will now prompt for a login and the user will have to give their username/password in order to access
  those given end points

  The default username and passwords are: 

  username: user
  password: generated security password available on the console logs. e.g. 
  `Using generated security password: b4ab0328-942c-4fd4-be37-b886b9b26bd5` 


  . For overriding these defaults, in `application.properties` we add something like

  spring.security.user.name=caio
  spring.security.user.password=cerettasoares123

  .  We may wonder: "Ok, i want to do something more than just this .properties file". And we can customize spring security
  for the spring boot actuator, so we can use database for roles, encrypted passwords and so on...

  ### Excluding Endpoints

  . To exclude /health and /info we simply add an entry in our .properties file as `management.endpoints.web.exposure.exclude=health,info

  ### Spring Boot Actuator Documentation

  `www.luv2code.com/actuator-docs`

  ### Development Process

  1. Edit pom.xml and add spring-boot-starter-security
  2. Verify security on actuator endpoints for: /beans etc
  3. Disable endpoints for /health and /info

## Lesson 18: Securing endpoints

  This course lesson was already made during thee 16th one, is just about the security which were already applied in the
  previous project

## Lesson 19: Running spring boot from the command line

. During development we spend most of our time in the IDEs: IntelliJ, eclipse, Netbeans. However, we may want to run our
Spring Boot applications outside of the IDE

. One approach, is running it from the command line.

### Command Line

. When running from the command-line, there is not need to have IDE open/running
. Since we're using Spring Boot, the server is embedded in our JAR file
  . No need to have separate server installed/running
. Spring Boot apps are self contained and include the server already

### Running from the command line

. A jar such as mycoolapp.jar includes the code and the tomcat server, for example, therefore, it is a self containing
unit and there is nothing else to install. 
. We have two options for running the app
  . Option 1: Use java -jar

    - If we have a spring boot application such as mycoolapp.jar we would simply run it with java -jar mycoolapp.jar

  . Option 2: Use Spring Boot Maven plugin
    
    - In our spring boot projects we have the mvnw and the mvnw.cmd files 
    - These files allow us to run a Maven project with no need to have Maven installed or present on our computer
    - If correct version of Maven is NOT found on our computer
      - It automatically downloads correct version and runs Maven
    - Two files are provided
      - mvnw.cmd for MS Windows
      - mvnw.sh for Linux / Mac
  

  #### Maven Wrapper files

    , If we already have Maven installed previously
      . Then we can ignore / delete the mvnw files

    . Just use Maven as we normally would with `mvn clean compile test`

  #### Use Spring Boot Maven plugin

    <build>
      <plugins>
        <plugin>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
      </plugins>
    </build>


  This entry is already generated for us on our pom.xml for the spring boot maven plugin, so we can use this plugin to
  easily execute run our app. Therefore, to package our application, we say `./mvnw spring-boot:run`. We could also just
  use mvn package or mvn spring-boot:run if we already have Maven installed.


  #### Development Process

  1. Exit the IDE
  2. Package the app using mvnw package
  3. Run app using java -jar
  4. Run app using Spring Boot Maven plugin, mvnw spring-boot:run


## Lesson 20 - Running from command line - prep. Running the app outside the IDE

  ● Command line

    ○ Open the folder on the terminal
    ○  run `./mvnw package` or `mvnw package` on windows
    ○ This will create a `target\appName-0.0.1-SNAPSHOT.jar`
    ○ Run `java -jar target\snapshot-created-name.jar
    ○ The spring boot app is now up and running and can be accessed normally

  ● Using Spring Boot Maven Plugin

    ○ Open the folder on the terminal
    ○ run `./mvnw spring-boot:run`
    ○ Same result

## Lesson 21 - Injecting Custom Application Properties - Overview

  ■ Problem: We need our app to be configurable with no hard coding of values
    ● Solution: Application Properties File
      ○ By default, Spring Boot reads information from a standard properties file
        . Located at: src/main/resources/application.properties
      ○ We can define ANY custom properties in this file
      ○ Spring Boot app can access properties using @Value notation, with no additional coding or configuration needed


  ● Development Process

    1. Define custom properties in application.properties
    2. Inject properties into Spring Boot application using @Value


  Step 1: Define custom application properties. We can give any custom properties names and values, such as
  `coach.name=Mickey Mouse` or `team.name=The Mouse Club`
  Step 2: Inject Properties into Spring Boot app using @Value annotation 
    ○ We are going to make use of the rest controller from previous lessons, to inject, we are going to simply inject
    the properties, like:  

      @Value("${coach.name}")
      private String coachName;

      @Value("${team.name}")
      private String teamName;

    This way, we inject the value within application.properties and assign it to a property of the same type, spring boot
    access the properties name and make them available with no configuration needed






















   







    


