## Lesson 1 - Inversion control? 

  ● What does "Injecting" mean? 

    ○ In programming, injecting mean:
      □ Provide a preconstructed object into the class,so the class doesn't need to create it itself.

    ○ Simple Example (without injection)

      ■ Imagine we have a class CricketCoach that needs a FortuneService to give a motivational message. Without injection,
    it would create this object itself

```java
        public class CricketCoach {
          private FortuneService fortuneService = new HappyFortuneService(); // Creating here

          public String getDailyFortune() {
            return fortuneService.getFortune(); 
          }
        }
```

      Here, CricketCoach is creating the HappyFortuneService — it depends on it e knows how to build it

    ○ Simple Example (with DI)

      ■ With dependency injection, 'someone' from outside (e.g.: Spring) is responsible for injecting (i.e. provide) this
      ready-to-use `FortuneService` 

```java
          public class CricketCoach {
            private FortuneService fortuneService;

            // Injecting via constructor (In java, the constructor has the name of the class, not `constructor`)
            public CricketCoach(FortuneService fortuneService) {
              this.fortuneService = fortuneService; 
            }

            public String getDailyFortune() {
              return fortuneService.getFortune();
            }
          }
```

        □ Now, `CricketCoach` does not create `FortuneService` anymore.
        □ It receives this service from the outside — in other words, it is injected

      ■ And who does this injection? 

        □ In the context of Spring, is the Spring Container who does it automatically for us. We only declare that our
        class needs 'something', and Spring provides

    ○ Quick Summary: 

      ■ With no injection, the class creates the objects itself, there is a higher coupling, making it hard to change, and
      we have less control and testability

      ■ With injection, the objects are provided externally, it is more flexible (easier to modify tests, etc), and there
      is more control and testability.



  ● What is Dependency Injection (DI) ? 

    ○ This is a core of IoC
      Dependency Injection is the process where SPring automatically provides the objects that a class needs
    
      Example: Suppose the class CricketCoach needs a FortuneService object. Instead of creating it manually inside
      `CricketCoach`, Spring `injects`it to you
      This helps keep your code decoupled and flexible, and easier to test and maintain


    ○ Example no 2 of DI

      . Let's use a car factory as an example and we want to purchase a car, in programming, we would communicate with the
      car factory and ask for a car, and in the background, the car factory grab the given car, and make it available to
      us.

      . Since it is a factory, they may have to actually assemble the car, from various parts, like the door, the engine,
      the windshield, and all the different components there.

      . Once it is all put together, it will give us the actual car

      . The whole idea of dependency injection is saying: "Hey, give me a given object if it has any components or helpers
      components, then assemble all that for me ahead of time and simply give it to me so i can use it out of the box".
      So that's the idea of dependency injection. Injecting the given dependencies or helper components for a given object


  ● What is inversion control?

    ○ Inversion of control is the approach of outsourcing the construction and management of objects
      ■ Instead of us manually creating objects ourselves, we'll outsource this and delegate that responsibility to a
      container (like Spring Container). In short
        □ Before: you created the objects yourself.
        □ Now: you "outsource" this responsibility, and the framework (e.g. Spring) creates objects for you.

  ● Coding Scenario

    ○ In one box we have our application, and in the other box, the CricketCoach where we want to write a method and say:
      "Hey, give me a daily workout — `getDailyWorkout()`" and it will give us a response
    ○ And that application should be configurable, so we can easily change the coach for another sport we desire.
      ■ Baseball, Hockey, Tennis, Gymnastics, etc...
      ■ We'd like for this app to be configurable, we can easily ask the coach for a workout and it'll give us a given
      response

  ● Ideal Solution
    ○ In one box we have our application, and in the other box an object factory we can talk to, and say: "Hey, give me
    a coach object"
    ○ This object factory, based on a configuration, will create a coach for us and give us a reference to it
    ○ This configuration can give us a Cricket, Tennis, Baseball coach object, all based on the configuration

    ○ Example with the coach idea

      ■ Imagine your app needs a `Coach`. This Coach could be for cricket, baseball, tennis, etc. You want the app to work
      like this:

```java
          Coach myCoach = ... // I want the system to give me a Coach
          system.out.println(myCoach.getDailyWorkout())
```
       
       ■ But you don't wan't to change the code every time you switch the Coach. You just want to change a configuration
       file.

          That's where Inversion of Control comes in: you ask for a Coach, and the Spring Container gives you one, based
        on a configuration!


  
  ● Spring Container

    ○ Primary Functions
      ■ Create and manage objects (Inversion of Control)
      ■ Inject object dependencies (Dependency Injection)

    ○ Configuring Spring Container
      ■ XML configuration file (legacy)
      ■ Java Annotations (modern)
      ■ Java Source Code (modern)


    ○ Injection Types

        ■ Need to inject this dependency into the controller our inject the code into the given controller, which we will
      further cover in this class

        □ Constructor Injection

        □ Setter Injection

        ■ Which type of injection should i use? 

          □ Constructor Injection
            
            . Use this when you have required dependencies
            . Generally recommended by the spring.io development team as first choice

          □ Setter  Injection

            . Use this when you have optional dependencies
            . If dependency is not provided, you app can provide reasonable default logic

    ○ What is Spring AutoWiring?

      ■ For dependency injection, Spring can use autowiring

      ■ Spring will look for a class that matches

        □ Matches by type: class or interface

      ■ Spring will inject it automatically... hence it is autowired

      ■ Autowiring Example

        □ Injecting a Coach implementation

        □ Spring will scan for @Components — any class annotated with the @Component annotation

        □ "Asks" if anyone implement the Coach interface, if so then let's inject them


    ○ How it works

      ■ Spring container kinda works as the object factory, so, my application can talk to the Spring Container: "hey,
      give me a coach object and this coach object may have additional dependencies or additional helpers. Imagine we
      have a head-coach and he may have a staff of assisting coaches, physical trainers, medical staff, and so on. Therefore
      we say: "Hey, give me everything that i need to make use of this given coach", and then it will give to us all put
      together, ready-to-go, out-of-the-box, and this is independency injection using the Spring Contain

    ○ Spring Container Refresher

      ■ It has two key primary functions

        □ One function is create and manage object (Inversion of Control)

        □ Inject object's dependencies (Dependency Injection)
      
## Lesson 2 - Dependency Injection Overview

  ● @Component annotation

    ○ @Component marks the class as a Spring Bean

      . A Spring Bean is just a regular Java class that is managed by Spring

    ○ @Component annotation also makes the bean available for dependency injection

  ● Example application

    . We have this 'Web Browser', a 'Demo Controller' and a 'Coach'
    . The endpoint from the web browser is the /dailyworkout, which send the request to the coach, and the controller
    will communicate to the coach through getDailyWorkout()
    . Coach will respond with a string like "Practice serves for 15m"
    . And the controller will return it to the browser
  
  ● Development Process - Constructor Injection

    1. Define the dependency interface and class
    2. Create Demo REST Controller
    3. Create a constructor in our class for injections
    4. Add @GetMapping for /getDailyWorkout endpoint
   
    ○ Step 1: Define the dependency interface and class: 

      File: Coach.java
```java
          package ...

          public interface Coach {
            String getDailyWorkout();
          }       
```

      File: CricketCoach.java
```java
        package ...

        import pathToComponent;

        @Component
        public class CricketCoach implements Coach {
          
          @Override
          public String getDailyWorkout() {
            return "Practice fast bowling for 15 minutes"
          }
        }        
```

      The @Component annotation marks the class as a Spring Bean and makes it a candidate for the dependency injection.

    ○ Step 2: Create Demo REST Controller

```java
        package ...packagename;

        import ...RestController;

        @RestController
        public class DemoController {
            
        }
```

    ○ Step 3: Create a constructor in your class for injections

```java

        package ...packagename;
        
        import ...Autowired;
        import ...RestController; 

        @RestController
        public class DemoController {

          private Coach myCoach; 

          @Autowired
          public DemoController(Coach theCoach) {
            myCoach = theCoach;
          }
        }
```

        Now, `Spring Object Factory` will handle injecting this dependency based on the configuration, we tell string to inject
        the dependency with the @AutoWired annotation. 

      ○ If we only have one constructor, then the autowired annotation on a constructor is optional 

      ○ At the moment, we only have one coach implementation: `CricketCoach` so Spring can figure out which one it needs.
      Later on the course, he will cover the case of multiple coach implementations and how to implement it accordingly.

    ○ Step 4:  Add @GetMapping for /dailyWorkout

```java

      package ..packagename;

      import  ...Autowired;
      import  ..GetMapping;
      import  ...RestController';

      @RestController
        public class DemoController {

          private Coach myCoach; 

          @Autowired
          public DemoController(Coach theCoach) {
            myCoach = theCoach;
          }

          @GetMapping(/dailyWorkout)
          public String getDailyWorkout() {
            return myCoach.getDailyWorkout(); 
          }
        }
```

## Lesson 3: Constructor Injection - Part 1

● Initializr

  1. Go to the Spring Initializr website `http://start.spring.io` 
  2. Choose Maven for the project type, java as language and spring boot the latest non snapshot
  3. group `com.luv2code` and for the artifact `springcoredemo`, `jar` for the packaging and latest java
  4. for the dependencies add: `Spring Boot DevTools` and `Spring Web`
  5. generate

● Coding

  ○ First of all, we unpack it, and open it into intellij

## Lesson 4: Constructor Injection - Part 2

● Coding

  ○ Create a new interface: double click the springcoredemo package in src/main/java, select `new` in the dropdown, then
  `Interface`, and create the `Coach`
  ○ Create a new class: follow the same steps as above, in the place of interface, choose `Class` and name it `CricketCoach`
  ○ CricketCoach class implement the Coach interface, which will require it to create a getDailyWorkout() method
  ○ Annotate this class the @Component annotation and use the @Override annotation over the interface function, meaning
  it will override the declaration in the supertype (in this case, the `Coach` one it implements) 
  ○ @Component annotation also marks the class as a Spring bean and makes it available for dependency injection

  ○ Implementing getting daily workout
    ■ Simply choose any sentence you want to motivate!
  ○ Create Demo REST Controller: right click on the folder artifactNamePackage, and choose new Java Class
    ■ Annotate it with @RestController
    ■ Create a constructor in our class for injections
    ■ Define a private field for the dependency, in this case, an attribute of the dependency type
    ■ Define a constructor for the dependency injection, annotate the constructor with @AutoWired (It tells spring to inject
    a dependency, and if we only have one constructor, this annotation is optional), in the constructor params insert a
    variable of the dependency type and assign to the property, this constructor input 
    ■ Finally, we add a @GetMapping for /dailyworkout

    ▣ One thing we may notice when accessing the /dailyworkout webpage is that when we implement the constructor and
    assign the myCoach property to the input parameter, calling the getDailyWorkout() method returns the implementation
    from the `Coach` interface. However, no DemoController class explicitly passes in any coach. Why is that? 

    This behavior is due to with Spring Boot's default @Component scanning and autowiring by type.

    ● We have the interface:
      .`public interface Coach { String getDailyWorkout() }
    ● We have only one concrete implementation annotated with @Component — which is the CricketCoach
    
    ● In our controller we define a constructor like this:
      `public DemoController(Coach the) { this.myCoach = theCoach}
    
    Here's what `Spring` does behind the scenes:

      1. It scans the project for any classes annotated with @Component (or related stereotypes like @Service, @Repository,
      etc.) that implement the `Coach` interface
      2. Since there is only one implementation available in the application context (`CricketCoach`), Spring automatically
      injects this class to satisfy the dependency
      
      ▣ Important Note: 
      
        This only works if there is only one implementation in the Spring Context, if we introduce another one, for example:

```java
      @Component
      public class BaseballCoach implements Coach {
          public String getDailyWorkout() {
              return "Spend 30 minutes on batting practice";
          }
      }
```
      We would now have `two beans` implementing `Coach`. In this case, when running the app, Spring will throw an error 
      due to ambiguity — It won't know which implementation to inject.
      
      To fix this, we must use the @Qualifier annotation to explicitly specify which one to use, like so: 
      
```java
      public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
        this.myCoach = theCoach
      }
      
```

  ● IntelliJ Note

    ○ Spring Boot DevTools is not automatically reloading when the value of a string changes
      ■ To fix this, in IntelliJ we must go to:
        □ 1. Settings -> Advanced Settings -> Allow auto-make...
        □ 2. Build, Execution, Deployment -> Compiler -> Build project automatically 

  ● Recap: Dependency Injection vs Dependency Inversion Principle

    ○ On the code above, we utilized the DI via constructor injection

     ■ With spring, this is automatically managed by the IoC (inversion of control) container, it injects a coach instance
     (in our case, `CricketCoach`) inside DemoController

    ○ But what about the "Dependency Inversion Principle" (DIP)? 

      ■ This principle is part of the `SOLID`, and says

        □ High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should
        not depend on details. Details must depend on abstractions

      ■ But what about Dependency Inversion Principle (DIP)?

        □ Taking our code as an example

          . High-level module: DemoController
          . Low-level module: CricketCoach
          . Abstraction: Coach (interface)


        □ We are applying the dependency inversion principle because: 

          . DemoController doesn't directly know the implementation (CricketCoach)
          . It depends on the `Coach` abstractions
          . Who chooses which concrete implementation to use (in the case: CricketCoach) is the Spring Container through
            the @Component annotation.
          . Which means our code obeys DIP and also use DI to perform this dependency

      ■ Summary:

        □ Dependency Injection: Is the technique for providing dependencies of an object (via constructor, setter or field)

        □ Dependency Inversion Principle: Design principle that says that classes must depend on abstractions but not on
        concrete implementations

# Lesson 5: IDE Warning - No usages

  ● Warning notice: 

    ○ One thing we might have noticed is that the IDE may have given us a warning notice about "no usages"

      ■ For example, on the class CricketCoach, it is listed as no usages, however, we know that we are using it inside
      our Spring Boot project, because we ran our application, tested it, and received the daily workout from it. So
      we may wonder: "Why is the IDE saying no usages?"
          
        □ Due to the dynamic nature of Spring, sometimes the IDE is not able to figure out how beans are injected.

        □ Since most times we are coding to the interface, we may not explicitly reference the implementation class in
        our Spring app, we simply let Spring do its work behind the scenes of injecting the appropriate implementation
        as needed.

        □ There are a lot of things that happen behind the scenes at runtime and the IDE may not be able to determine if
        a given class or method is used at runtime.

# Lesson 6: Constructor Injection - Behind the scenes

  ● How Spring processes our application

    ○ We have our interface for Coach, the CricketCoach implementation and our `DemoController`

    ○ Spring Framework will perform operations behind the scenes for us

      ■ Behind the scenes, Spring will create a new instance of Coach, `new CricketCoach`, and will also perform constructor
      injection with our `DemoController`, it will actually inject the coach into the DemoController, such as:

        ```java
          Coach theCoach = new CricketCoach();

          DemoController demoController = new DemoController(theCoach)
        ```

      ■ The whole idea of injection is that there is a dependency/helper — such as the `Coach` in this example — for the
      actual controller

    ○ The "new" keyword.... is that it? 

      ■ We may wonder

        - Is it just the "new" keyword?
        - I don't need Spring for this... I can do this by myself.
        - What is the point of spring if it is just the new keyword
  
      ■ Is Spring only IoC? 

        □ Spring is more than just IoF and DI

        □ For small basic apps, it may be hard to see the real benefits of Spring.

    ○ For what is Spring designed to?

      ■ Spring is targeted for enterprise, real-time / real-world applications

      ■ Spring provides features such as

        □ Database access and Transactions
        □ REST API
        □ Security
        □ etc...

      ■ Later in the course we will build a real-time CRUD REST API with database access. 
        







            


    



  


  
 