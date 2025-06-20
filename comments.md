## Initializing a Spring project

First of all, we enter the website "start.spring.io", in this website there are going to be some options.

### 1st Part 

1. Project

Which type of project are we creating, by default gradle - groovy is selected but the instructor prefers to use maven because
it's the native approach. Gradle uses maven under the hood, it's a more simplified way than gradle but maven is easier
to learn and most of the companies utilize maven.

Maven: 
. Based in XML
. Default, stable and very used in java projects
. Easier for  beginners to understand
. More rigid structure

Gradle:
. Based on Kotlin DSL or Groovy DSL
. More modern and flexible
. Faster with incremental build resource
. Recommended for bigger and complex projects

2. Language

`Java`, `Kotlin`, and `Groovy` are languages based on JVM, but for this course purpose w

Java is more used, verbose but well documented, bigger community and support and ideal for whom is starting

Kotlin is more modern and concise, but can also work with Java, created by Jetbrains, have some newer resources such as
null safety and coroutines (Way to write asynchronous, non-blocking code in a sequential style. They allow suspending and
resuming functions without blocking threads.). And is very used in spring boot + reactive APIs

Groovy is dynamic and more flexible than java, less used nowadays in new projects, internally used in Spring within scripts
and tests, but not too recommended for newer apps.

3. Spring Boot Version

Newer version with (Snapshot) on their name, means that they are versions released for testing (newer features, but they
are still not official)

4. Project Metadata

. Group: Domain of the company (reversed, example.com we use com.example)
. Artifact: Name of the project (projetosapi)
. Name: Same as the artifact, we can use uppercase if we would like, etc, just for display
. Description
. Package Name: root package, its value is also auto generated: group  + artifact
. Package: Jar

  Jar (Java Archive) is more common with spring boot, is an executable file that contains our java application and all its 
  dependencies. It's used for standalone apps (auto-executables), spring boot was projected to use JAR as default, it runs
  with a simple java -jar my-app.jar

  WAR (Web Application Archive) - More common in old projects, it's a packaging used in servlets Java and in applications
  servers, such as Tomcat, Wildfly or Jboss.
  It needs to be deployed in a server, Ex: Tomcat -> /webapps/my-app.war
  Requires more configuration and its less portable

### 2nd Part

If we were to run with only with this first part, we could, but before this we are going to add the dependencies.

Dependencies are the libraries we want to add, when clicking on `Add` dependencies, we are going to see some options.

In our case we'll choose

Lombok: A Java annotation library that helps reduce boilerplate code by automatically generating commonly used code, such
as getters, setters, constructors, and toString methods at compile time.

Spring Boot Devtools: A toolset that provides fast application restarts, live reload, and various configurations to improve
the development experience. With Devtools enabled, the application will automatically restart whenever changes are made
to the code, making the development process faster and more efficient.

Spring Web: A module that enables building web applications using Spring MVC (Model-View-Controller). It provides essential
features for building RESTful services and web-based applications, including request handling, URL mapping, and view resolution.

Spring Data JPA: Spring Data JPA is a part of the Spring Data project that simplifies data access using the Java Persistence
API (JPA). It reduces boilerplate code by providing repository interfaces that automatically handle common database operations
like saving, updating, deleting, and querying entities. With Spring Data JPA, developers can focus more on the domain logic
while relying on conventions and annotations to generate queries, making data persistence faster and easier to implement.

H2 Database: An in-memory database that supports both JDBC and R2DBC. When the application starts, the H2 database is
automatically launched in memory, and it is discarded once the application stops. It is often used for testing, development,
or scenarios where persistent data storage is not necessary. Since it is in-memory, it offers fast data operations but does
not retain data after the application is restarted.

Before generating we have two buttons to click on

Generate: 

Explore: We can visualize how the project is going to be created, the source code, the package, application properties,
pom.xml, etc.


## Arquivo de configuração de dependencias

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



