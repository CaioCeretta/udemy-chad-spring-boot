## Lesson 1 - What are rest services? Part 1

  ● In this section we will:

    ○ Create REST APIs / Web Services with Spring

    ○ Discuss REST concepts, JSON and HTTP messaging

    ○ Install REST client tool: Postman

    ○ Develop REST APIs / Web Services with @RestController

    ○ Build a CRUD interface to the database with Spring REST
  
  ● Practical Results

    ○ Introduction to Spring REST development

    ○ Not an A to Z reference. for that we can see on on the Spring Reference Manual: (www.luv2code.com/spring-reference-manual)

  ● Business Problem

    ○ Build a client app that provides the weather report for a city

    ○ Need to get weather data from an external service

  ● Application Architecture

    ○ Let's say we have a MyWeatherAPP, which is an app that we are creating so that is kind like a client application,
    and we have a WeatherService, which is external and provided by third-party, so it's more like a back-end server.

      ■ And what we will do with the weather app is to pass over a string for a city, and this weather service will return
      back with the actual weather report.

    ○ This is the architecture but it may lead to some questions, like

      ■ How will we connect to the Weather Service? 

        □ We can make REST API calls over HTTP
        □ REST: It stands for: REpresentional State Transfer, which is a lightweight approach for communicating between
        applications

      ■ What programming language do we use? 

        □ REST is language independent, therefore the client application can use ANY programming language and the server
        application can also use ANY programming language, which is up to us.

      ■ What is the data format? Is it CSV, XML, or some other weird format? 

        □ REST applications can use any data format. We will commonly see XML and JSON, but JSON is most popular and modern
        option

      ■ Possible Solution

        □ Use online Weather Service API provided by: openweathermap.org
        □ Provide weather data via an API
        □ Data is available in multiple formats: JSON, XML, etc...
      
  ● Call Weather Service

    ○ The API documentation gives us the following:

      ■ Pass in the latitude and longitude for your desired location:
        □ `api.openweatherapp.org/data/<apiVersion>/onecall?lat={theLatitude}&lon={theLongitude}`
        □ This will actually give us the weather report

        □ The response will be something like:

          ```ts
            {
              ...
              "temp": xxx,
              "feels_like: yyy,
              "humidity: zzz,
              ...
            }
          ```
        
  ○ Multiple Client Apps

    ■ The nice thing of making use of this approach with this REST API web-service, is that the external Weather Service
    they simply provide the data feed, and we can have different types of clients that can access it. So, we could maybe
    create our own client application using Spring MVC, Java, accessing this application, or we could make use of maybe
    a C# application talking to this service and maybe build a iPhone app using swift, communicating with this Weather
    service. 

      □ So again, remember, the REST calls can be made over HTTP, and also, REST is language independent, so it doesn't
      really care what language we are using as long as we can process the data being passed back.

## Lesson 2 - What are rest services? Part 2

  ● App Examples

    ○ MyCurrencyApp -> USD to INR, 100.00 -> Currency Service (external)

      ■ In this example we would send to the server, which currencies to convert, and this application would respond with
      the actual value. Like 6.478.52 INR  

    ○ MyMovieApp -> Movie, Location, Time -> Movie Tickets Service (external) 

      ■ In this other example, we would send these kind of information to the server, and it will respond with a list of
      Movie results

    ○ Again, these services are simply passing back the data and we can use any program language, any type of app or platform
    to render those results.

  ● Customer Relationship Manager (CRM App)

    ○ CRM App and a CRM Service (spring-rest)

      ■ In this case, we can basically access the list of customers by requesting it and it will actually send back that
      list. Therefore, instead of doing directly in the HTML page or JSP page or webpage, we're simply passing back this
      JSON data or whatever data we choose and then the CRM app can render it accordingly. So it can be any type of app,
      web apps, mobile apps, etc.

      ■ In this course we are creating the code for the server, so we'll actually create a CRM service that's gonna pass back
  customers data as JSON, coding everything from scratch .

      ■ What do we call this? REST API RESTful API, Web Services or even Services? 

         □ Generally all mean the SAME thing. Basically we are building an API, or a service, we are still providing an
         endpoint and data based on inputs or requests and so on. So that's the big idea, is that they're all the same.

          . We will hear folks use these terms interchangeably, so at a very high level, they're generally= all the same
          thing. 


  ● What is the difference between REST and RESTful applications? 

    ○ REST is an architectural style that define a set of principles for Distributed Systems

      ■ Example of REST principles

        □ Communication without states (stateless) 
        □ Resource identification by URI.
        □ Standardized HTTP operations (GET, POST, PUT, DELETE...)
        □ Cache when possible

        □ REST is the theory


    ○ RESTful

      ■ Adjective to tell if a system follows all the REST principles.
      ■ An API can be called as REST, but only be "REST-like", meaning it won't follow everything.
      ■ Example: 
        □ An API which uses GET /getAllProducts instead of GET /products is not 100% RESTful, because it is mixing the URL
        with a verb.
        □ Other API that keeps the user session in the server (stateful) is also not completely RESTful.

        □ Therefore, the restful is the practice of correctly keeping all the principles


  ● What are Distributed systems? 
    
    ○ A distributed system is a collection of independent computers that appear to the users as a single coherent system.
    These computers (often called nodes) communicate with each other over a network and coordinate their actions by passing
    messages.

    ○ The main characteristics of distributed systems are: 
      ■ Resource sharing - Hardware, software, or data resources are shared across different nodes.
      ■ Transparency - The system hides complexity so users interact with it as if it were a single system (e.g. location
      transparency, replication transparency)
      ■ Scalability - The system can grow by adding more machines without significant reconfiguration
      ■ Fault tolerance - Even if one or more nodes fail, the system continues to operate, often by replicating data or
      services
      ■ Concurrency - Multiple processes can run simultaneously on different machines

    ○ Examples include cloud platforms like AWS, Azure, peer-to-peer networks, distributed databases, and large-scale web
    applications

    ○ In short: It is a network of computers working together to achieve a common goal, giving the illusion of being a
    single system.

    ○ But what are it's connection with REST?

      ■ While Distributed Systems is about how multiple computers work together, REST, on te other hand, is an architectural
      style for communication between systems. It defines principles on how components in a distributed system (usually
      client and server) should interact over a network, most often using HTTP. The connection is

        □ A distributed system needs a way for its parent to talk to reach other -> REST provides a standardized way to
        do this

        □ REST uses stateless communication: each request from a client to a server contains all the necessary information,
        which makes distributed systems simpler to scale and more fault;tolerant

        □ In many modern distributed systems (like microservices, cloud platforms or APISs), RESTful APIs are the communication
        layer that allows different services (running on different machines) to work together as a single system

      ■ In short:

        □ Distributed Systems = the big picture (many computer working as one).
        □ REST = the communication style often used to make that possible.

  ## Lesson 3 - JSON Basics

    ● What is JSON?

      ○ JavaScript Object Notation
      ○ Lightweight data format for storing and exchanging data... plain text
      ○ Language independent... not just for JavaScript, which means it can be used with any programming language: Java,
      C#, Python, etc. This is possible because it is basically plain text

    ● Simple JSON Example

      ○ {
        "id": 14,
        "firstName": "Caio"
        "lastName": "Ceretta"
        "active": true
      }

        ■ The object members are name / value pairs
          □ Delimited by columns
          □ "Name" is always in double-quotes

      ○ JSON Values

        ■ Numbers no quotes
        ■ String: Always in double quotes
        ■ Boolean: true or false with no quotes
        ■ Nested JSON object

          □ {
            ...
              "address": {
                "street": "100 Main St",
                "city": "Philadelphia",
                "state": "Pennsylvania",
                "zip": "19103",
                "country": "USA"
              }
            ...
            }

        ■ Array

                    □ {
            ...
              "languages": ["Java", "Next.js", "Javascript", "Node.js"]
            ...
            }

        ■ null

  ## Lesson 4 - Spring Boot REST HTTP Basics
    ● REST over HTTP

      ○ Most common use of REST is over HTTP
      ○ Leverage HTTP methods for CRUD operations

        ■ HTTP Method: POST - CRUD Operation: Create a new entity
        ■ HTTP Method: GET - Read a list of entities or single entity
        ■ HTTP Method: PUT - Update an existing entity
        ■ HTTP Method: DELETE - Delete an existing entity 

    ● HTTP Messages

      ○ Client (MyCRMApp) -> Server (CRM Rest Service)

        ■ Client sends over REST requests for the Server, which send back an HTTP Response message

      ○ HTTP Request Message

        ■ Every request has a `Request line`, `Header variables`, `Message body`

          □ Request line: The HTTP command (GET, POST, PUT...)
          □ Header variables: Request metadata. Additional information about the request
          □ Message body: Contents of message

      ○ HTTP Response Message

        ■ Response messages has a `Response Line`, `Header Variables` and `Message Body`

          □ Response line: server protocol and status code, which may be any status code, such as 404, 200, 201, 301...
          □ Header variables: response metadata
          □ Message body: contents of message, so if we request a list of all customers, then that list of data will also
          come back in the message body as either XML or JSON depending on the server configuration

          □ HTTP Response - Status codes

            . Anything in the 100 range that's all informational
            . Anything in the 200 range it's all success messages
            . Anything in the 300 range it's all direction message
            . Anything in the 400 range it's all client error message, such as 401 Authentication Required and File Not
            Found
            . Anything in the 500 range it's all server error message, such as 500 Internal Server Error

        ■ MIME Content Types

          □ Actual message format for the payload, and it's described by a MIME content type, which means Multipurpose
          Internet Mail-Extension, which we will normally hear folks refer to it as MIME , and it simply describes the actual
          content or the format of the message being returned

          □  Basic Syntax: type/sub-type, like text/html, text/plain. This is information that's returned back to the
          client and then the client can render it correctly, or process it accordingly.

            . Using a web browser for example, if we return back text/html to a web browser, a web browser will render
            that based on HTML tags. We pass back text/plain, the web browser will simply just show the plain text in the
            browser. 
            . We can also make use of RESTful clients for that. In particular for REST clients we can pass back application/json
            and basically tell the client "Hey, we're returning JSON data for you" or we can use application/xml saying
             "Hey, we're returning XML data for you".

      ○ Client Tool

        ■ We need a client tool where we will send HTTP requests to the REST Web Service / API. Where we will send HTTP
        requests to REST Web Services / API

        ■ Plenty of tools available: curl, Postman, Insomnia, etc...

  ## Lesson 5 - Spring Boot REST Controller - Overview - Part 1

    ● Setup a Spring REST Hello World example.

      ○ The REST client will make a request for a /test/hello which will respond with Hello World!

      ○ On the far right side (the service), we write the code for the rest service and on the left hand side, as the
      REST client, we can make use of either the web browser or make use of Insomnia

    ● Basic coding for a Spring REST controller.

      ```java

        // This annotation adds the REST support.
        @RestController
        // the @RequestMapping("/test") at the class level means that every endpoint inside this controller will have this
        // as a prefix.
        @RequestMapping("/test")
        public class DemoRestController {
           
          @GetMapping("/hello") // Defines the path where we can access this function
          public String sayHello() {
            // Back to the client
            return "Ciao, Mondo!";
          }

        }

      ```

      ○ We can now test this with a REST client - Insomnia. However, since this is a GET request, we can simply access
      it through a web browser and use the same url in the address bar

  ## Lesson 6 - Spring REST Controller Development Process - Overview - Part 2

    ○ 1. Add Maven dependency for Spring Boot Starter Web
      
      ■ Within pom.xml, add the following

        □ <!-- Add Spring Boot Starter Web -->

          <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
          </dependency>

        □ However, instead of writing this manually, inside the Spring Initializr website, when setting up the project,
        simply select the Web dependency
    

    ○ 2. Create Spring REST Service using @RestController annotation

      ■ Just like the code we saw over earlier for building in our REST Service, we simply write our @RestController and
      add the endpoint

## Lesson 7 - Spring Boot Rest Controller - Coding


● Initial config
  
  • Basic settings -> maven / java / latest stable spring boot / jar 
  • For the additional dependencies this project will only use spring web
  • Generate it

● Coding

  ○ Start by adding a new package named rest under demo and define a new DemoRestController
    . Annotate it with @RestController and @RequestMapping("/test") — RequestMapping will make all the requests inside
    the class to be mapped after "test"




      

  


 