
## What is Spring Boot? 

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


## Initializing a Spring project

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


## Similarities to package.json

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


## Running Spring Boot Apps

. Spring Boot apps can be run standalone (includes embedded server)
. Run the Spring Boot app from the IDE or command-line

Therefore, in the example above, we would run in the command line: `java -jar mycoolapp.jar` 

## Deploying Spring Boot Apps

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

## Common Questions - Lesson 1

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

