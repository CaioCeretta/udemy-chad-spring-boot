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
        □ api.openweatherapp.org/data/<apiVersion>/onecall?lat={theLatitude}&lon={theLongitude}
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
         


  

    

  


