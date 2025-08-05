▣ To avoid repetition, Spring Boot will be contracted to `SB`

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
  2. Choose Maven for the project type, java as language and `SB` the latest non snapshot
  3. group `com.luv2code` and for the artifact `springcoredemo`, `jar` for the packaging and latest java
  4. for the dependencies add: ``SB` DevTools` and `Spring Web`
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

    This behavior is due to with `SB`'s default @Component scanning and autowiring by type.

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

    ○ `SB` DevTools is not automatically reloading when the value of a string changes
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

## Lesson 5: IDE Warning - No usages

  ● Warning notice: 

    ○ One thing we might have noticed is that the IDE may have given us a warning notice about "no usages"

      ■ For example, on the class CricketCoach, it is listed as no usages, however, we know that we are using it inside
      our `SB` project, because we ran our application, tested it, and received the daily workout from it. So
      we may wonder: "Why is the IDE saying no usages?"
          
        □ Due to the dynamic nature of Spring, sometimes the IDE is not able to figure out how beans are injected.

        □ Since most times we are coding to the interface, we may not explicitly reference the implementation class in
        our Spring app, we simply let Spring do its work behind the scenes of injecting the appropriate implementation
        as needed.

        □ There are a lot of things that happen behind the scenes at runtime and the IDE may not be able to determine if
        a given class or method is used at runtime.

## Lesson 6: Constructor Injection - Behind the scenes

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

## Lesson 7: Component Scanning - Overview

  ● Scanning for Components Class

    ○ @Component, etc.

    ○ It will automatically register the beans in the Spring container

      ■ Java Source Code

        ○ In our project, we have the, for example, `SpringcoredemoApplication.java`, which is our main `SB` app created
        by the initializr, and we also have the REST controller.  

        ○ In that SpringcoredemoApplication, we can notice that it imports the SpringBootApplication from the org package, which
        enables auto configuration, components scanning and additional configuration with `SB`.

      ■ Behind the scenes, that annotation is composed of the following annotations

        □ @EnableAutoConfiguration
        □ @ComponentScan
        □ @Configuration

  ● Annotations

    ○ @SpringBootApplication is composed of the following annotations

      ■ @EnableAutoConfiguration: Enables `SB`'s auto-configuration support
      ■ @ComponentScan: Enables component scanning of current package also recursively scan sub-packages
      ■ @Configuration: Able to register extra beans with @Bean or import other configuration classes

        □ Java Source Code:

          ```java
          package ...springcoredemo;
          
          import ...boot.SpringApplication;
          import ...boot.autoconfigure.SpringBootApplication;

          @SpringBootApplication
          public class SpringcoredemoApplication {

            public static void main(String [] args) {
              SpringApplication.run(SpringcoredemoApplication, args);
            }
          }
          ```

          . The SpringApplication.run allow us to bootstrap our `SB` app
          . And SpringcoredemoApplication is a reference to the actual name of the class

          . Behind the scenes it will create the application context and register all beans and also start the embedded
          server.

  ● More on Component Scanning

     ○ By default, SP starts component scanning

      ■ From same packages as our main Spring B
      ■ Also scans sub-packages recursively

    ○ This implicitly defines a base search package that we can make use of

      ■ Allows us to leverage default component scanning
      ■ No need to explicitly reference the base package name

    ○ Putting this together would be

      ■ Main Spring Boot application class, automatically component scans package and sub-packages
      ■ We can create any other sub-packages we want within src/main/java/groupId/artifactName
      ■ Spring automatically scans everything inside this folder

      ■ One pitfall when making use of SB is using different packages and moving things around the workspace, for example

        □ Or whole app is within the artifactName folder, but we create a folder outside of it, only inside of the groupId
        folder, such as `demo/utils` and by default, SB will not component scan these packages, only package of main SB
        application class and sub-packages

      ■ Default scanning is fine if everything is under origin.artifactname folder

        □ But what about our other packages? 

          . Such as org.acme.cart, com.luv2code.util, edu.cmu.srs, how does this work out and how can we configure this
          accordingly?

            - In our SB application annotation, we can tell explicitly to scan certain base packages with
              scanBasePackages={"org.acme.cart", "com.luv2code.util", "edu.cmu.srs"}


## Lesson 8: Component Scanning - Coding - Part 1

    ○ Copy and paste previous code, change the pom.xml with the new name, and the package/class name

    ○ Create two new packages within the artifactId folder — rest and common

      ■ Move the DemoController to the `rest` package  

      ■ Also move Coach and CricketCoach to the `common` package

      ■ We can notice that they all are sub packages of src/main/java/group.artifactName package, so they will be component
      scanned automatically for us.

  
## Lesson 9: Component Scanning - Coding - Part 2

    ● New package under java/groupId folder, called `utils`
      ○ The important thing to note is that is no longer a subpackage of our componentscanning project, so we may have
      some issues with our default component scanning

      ○ Go into the componentscanning package/ common and move Coach and CricketCoach to the utils package

      ○ Now notice our main spring boot application, which is ComponentScanningApplication, will scan everything in this
      package and any subpackages, but by default spring will not component scan this new package (com.luv2code/utils).
        ■ If we try running the app now, we can notice that the application fails to start, and this happens because 
        DemoController constructor required a bean of type `com.luv2code.utils.Coach`, that could not be found.

        ■ This happen because it is no longer part of the default @Component scanning.
          □ Now we need to explicitly tell SP how to find these other packages out there 

            - In order to do accomplish that, we must edit the application @SpringBootApplication annotation
            - Inside the annotation parentheses, we explicitly list base packages to scan with scanBasePackages argument
            with a comma delimited list with the packages that we want to scan, such as.

            ```java
              @SpringBootApplication(
                scanBasePackages = {
                    "com.luv2code.componentscanning",
                    "com.luv2code.utils"
                }
            )
            ```

            . Remember, for java arrays, like in these cases, we use {}

            . By fixing the annotation and telling SP to scan the other package too, the issue will be resolved.

## Lesson 10: Setter Injection - Overview

  ● We covered constructor injection and now'll we'll talk about Setter Injection

    ○ Setter injection inject dependencies by calling setter method(s) on your class.

    ○ Autowiring example

      ■ Inject a Coach implementation
      ■ Spring will scan for @Components and basically say: "Hey, any one implements the Coach interface?"
        □ If so, let's inject them. For example: CricketCoach

    ○ Development Process - Setter Injection

      1. Create setter method(s) in your class for injection
   
        ```java

          @RestController
          public class DemoController {
            private Coach myCoach;

            //Setter injection
            public void setCoach(Coach theCoach) { 
              myCoach = theCoach;
            }
          }
        ```

      2. Configure the dependency injection with @Autowired Annotation
   
          ```java
            
            @RestController
            public class DemoController {
              private Coach myCoach;

              @Autowired
              public void setCoach(Coach theCoach) {
                myCoach = theCoach
              }
            }

          ```

          The Spring Framework will perform operations behind the scenes for us

    ○ How Spring processes our application

      ■ It has the Coach Interface, the CricketCoach implementation, and the DemoController.

      ■ We want to inject the dependency into the DemoController

      ■ Behind the scenes, Spring will create an instance of cricketCoach, as well as an instance of DemoController, and pass
       the coach implementation to the setter

        ```java
          Coach theCoach = new CricketCoach();

          DemoController demoController = new DemoController();

          demoController.setCoach(theCoach)
        ```

        □ If we have a RestController with a setter such as the DemoController has the `setCoach` with an Coach parameter,
        and it is the only `Coach` implementation noted with @Component. Behind the scenes, Spring does as pointed, it
        automatically calls setCoach method if only one dependency is compatible.

    ○ We can inject any dependency by calling ANY method on our class by giving the @Autowired annotation.

    ○ Instead of a traditional method, we can annotate the method with Autowired and we can simply give any method name for
    this given method an Spring will handle the dependency injection for us

      ```java

        @RestController
        public class DemoController {
          
          private Coach myCoach;

          @Autowired
          public void doSomeStuff(Coach theCoach) {
            myCoach = theCoach;
          }

          
        }
      ```

      ■ We can give any method name for this given method and spring handles it for us 

      ■ Setter injection should be used when we have optional dependencies, and if is a dependency is not provided, our
      app can provide reasonable default logic.

    ○ Autowired
      
        ■ @Autowired can be omitted after Spring 4.3. This class should be used only if there is only one public setter
          with a parameter, Spring can infer automatically that it must be used for dependency injection

          So if in the case above, we omitted the @Autowired, is work as long as it is the only setter with a parameter.

        ■ We must explicitly use it when:

            . There are many setters or many methods with a parameter, then Spring doesn't know which one to choose.
            . If we want to let the intention clear (good practice in large teams).
            . If we are using injection by constructor and want to keep the compatibility with older versions (Spring < 4.3)

    ○ Always prefer constructor injection

      ■ In general, the constructor injection is more recommended because:

        . Easies tests
        . Ensures Immutability
        . Avoid partially injected dependencies    

        - In this case, @Autowired is also optional in case there is only one constructor      

## Lesson 11: Setter Injection - Coding

  ● First, we start by copying and pasting the constructor injection project, and rebuild project, which helps with auto
  reloading.

  ● Steps

    ○ Create setter method in our class for injections

    ○ Configure the dependency with @Autowired annotation

    ○ Change the controller, instead of saying that the constructor must receive a parameter of type Coach, remove it and
    create a setCoach function, annotated with @Autowired with a parameter of Coach type

    ○ Instead of using a setCoach method, use any other name, such as 'doSomeStuff' because it is annotated with @autoWired,
    Spring will use it for dependency injection

    ○ Even though in most recent `SP` versions, @Autowired is not strictly needed, there are some caveats to consider

      ■ Situations where it is NOT needed

        □ Only one setter method
        □ It follows the setXyz() name pattern
        □ If there is only one bean that implements the interface required for the type
        □ Therefore, Spring can automatically deduct who this method must use

      ■ Situations where it is needed even with only one implementation

        □ If we change the method name for something that does not start with `set` 
        □ If there are other Coach implementations in the future, now spring won't know which Coach to choose, even with
        `setCoach`, it needs @Autowired with a @Qualifier, such as:

          ```java
            @Autowired
            @Qualifier("cricketCoach")
            public void setCoach(Coach coach) {
              this.myCoach = coach
            }
          ```

  ## Lesson 12: Field Injection (Field Injections with Annotations and Autowiring)

    ● Spring Injection Types

      ○ Recommend by the spring.io development team
        ■ Constructor Injection: Required dependencies
        ■ Setter Injection: optional dependencies
      
      ○ Not recommended by the spring.io development team
        ■ Field Injection

      ○ Field Injection... No longer cool

        ■ In the early days, field injection was popular on Spring projects
          □ In recent years, it has fallen out of favor

        ■ In general, it makes the code harder to unit test

        ■ As a result, the spring.io team does not recommend field injection
          □ However, we still see it being used on legacy projects, and on old blog posts on the internet

        ■ Field injection is the idea of injecting dependencies by setting field values on our class directly (even private
        fields), and this is accomplished by using `Java Reflection`

        ■ Code example: 

          ○ Configure the dependency injection with Autowired Annotation

            ```java
              package com.love2code...;

              import org.springframework.beans...;

              @RestController
              public class DemoController {
                @Autowired
                private Coach myCoach;

                // no need for constructors or setters

                @GetMapping("/dailyworkout")
                public String getDailyWorkout() {
                  return myCoach.getDailyWorkout();
                }

              }
            ```

            ■ With the @Autowired annotation on the attribute, Spring will inject a given coach implementation and it will
            do it behind the scenes even on a private field, automatically or directly set it on this controller. 

            ■ We can notice that there is no need for constructors, no need for setters, Spring sets the field directly.

            ■ However, it is not recommended by the spring.io development team, since it makes the code harder to test.

  ## Lesson 13: Qualifiers - Overview (Annotation Autowiring and Qualifiers)

    ● Autowiring

      ○ Injecting a Coach implementation
      ○ Spring will scan @Components
      ○ Any one implements Coach interface? 
      ○ If so, let's inject them... oops, which one? 

      ○ If we have multiple implementations, which algorithm will tell which one it should implement?

    ● Multiple Coach Implementations

      ○ Let's say we have CricketCoach, BaseballCoach, TrackCoach, TennisCoach, and they all implement Coach

        ■ If we have more than one implementation with @Components annotation, implement a constructor simply receiving
        a parameter of type Coach and no more coding, it will generate an error: 

          □ Parameter 0 of constructor in `path-to-controller` required a single bean, but 4 were found
            - baseballCoach
            - cricketCoach
            - tennisCoach
            - trackCoach

      ○ Solution: Be specific! - @Qualifier

        ■ The code consists of basically

          ```java

            // imports

            // class initialization

              //constructor
              @Autowired
              public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
                myCoach = theCoach;
              }

              /// rest of code
            ```

            □ In the @Qualifier we specify the bean id: CricketCoach which has the same name as the class, with the only
            difference that is camelCase.

      ○ But what about Setter Injections? 

        ■ If we are using Setter Injection, we can also apply @Qualifier annotation

          ```java
            // Same code as before

            @Autowired
            public void setCoach(@Qualifier("cricketCoach") Coach theCoach) {
              myCoach = theCoach;
            }

              // Same code as before
          ```

  ## Lesson 14 ~ 15: Qualifiers - Coding 

    ● Normal Housekeeping, create new project to it

    ● Change the code back to constructor injection

    ● Create new @Component implementations for the Coach interface, and it will now return an error

    ● On the CricketCoach, add the qualifier, such as  
      public DemoController(@Qualifier("baseballCoach") Coach theCoach) {
        myCoach = theCoach
      }

  ## Lesson 16: Primary - Overview

    ● This lesson covers the @Primary Annotation

      ○ Resolving Issue with multiple Coach implementations

        ■ In the case of multiple Coach implementations: such as CricketCoach, BaseballCoach, TennisCoach...
          □ We solved this issue by making use of the @Qualifier annotation
          □ We specified a coach by name
          □ However, there's an alternate solution available...

        ■ Instead of specifying the user by name by using the @Qualifier annotation, we can simply say that we simply
          need a coach regardless of which implementation to use

          □ This way, "Spring" will "ask": "Hey, if there are multiple coaches out there, then you coaches figure it out
          and tell me who's the primary coach"

        ■ For this, we make use of this new annotation @Primary, which basically say tht out of the multiple Coach 
        implementations, that this is the primary annotation that Spring should use in case none is specified.
          □ Now, using the @Primary annotation in a component, beneath or above the @Component, we can omit the @Qualifier
          if we want to, and it will choose the @Primary one.

        ■ There is one caveat when using the @Primary annotation

          □ We can only have one @Primary for multiple implementations

          □ By running our app trying to mark more than one class as @Primary, `Spring` will show in the terminal that we
          have an unsatisfied dependency expressed through constructor parameter and there is no qualifying bean available
          for the type because no 'primary' bean was found

      ○ Mixing @Primary and @Qualifier

        ■ We may think if we can mix both in the same class

          □ The answer is yes, but we are asking for trouble

          □ @Qualifier has higher priority, so even if we mention a given class as @Primary, that can be overwritten or
          have higher priority by making use of the @Qualifier annotation

          □ For example, even if some class is a @Primary coach, but on the controller we have some different implementation
          when the controller uses the @Qualifier, the @Qualifier will overrule the @Primary

      ○ Which one should i use? @Primary or @Qualifier? 

        ■ @Primary leaves it up to the implementation classes 

          □ Could have issue of multiple @Primary classes leading to an error

        ■ @Qualifier allows us to be very specific on which bean we want 

        ■ In general, the recommendation is to use @Qualifier

          □ It's more specific

          □ Higher priority

  ## Lesson 18 - Primary Coding

    ● Move to the intellij editor, do the usual housekeeping and implement what we have just explained
          
  ## Lesson 19 - Lazy Initialization - Overview

    ● By default, when our application starts, all beans are initialized

      ○ It will scan for all the @Components, etc...

      ○ Spring will create an instance of each and make them available

    ● Diagnostics: Add `println` to constructors

      ○ For example

        ```java
          public CricketCoach() {
          System.out.println("In constructor, " + getClass().getSimpleName())
          }
        ```

        ■ Do a similar print to all other classes

    ● When we start the application, it would be basically

        In constructor: BaseballCoach
        In constructor: CricketCoach
        In constructor: TennisCoach
        In constructor: TrackCoach
        

        □ By default, when our application starts, all beans are initialized, and Spring will create an instance of each
        and make them available

    ● We can make use of Lazy Initialization

      ○ Instead of creating all beans up front, we can specify lazy initialization

      ○ A bean will only be initialized in the following cases: 
        ■ It is needed for dependency injection
        ■ Or it is explicitly requested

      ○ We simply Add the @Lazy annotation to a given class and other rules will come in to play

        ■ Coding Example

          ```java

            imports ...

            @Component
            @Lazy
            public class TrackCoach implements Coach {
              public TrackCoach() {
                System.out.println("In constructor, " + getClass().getSimpleName());
              }
            }

          ```
        
          □ This given bean will only be initialized if needed for dependency injection, if it is not needed it won't be
          created

            ```java

              @RestController
              public class DemoController {
                private Coach myCoach; 

                
                public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
                  myCoach = theCoach
                }
              }
            ```

              Here we are saying that we need CricketCoach for dependency injection, and when we run the application, we
              won't see the TrackCoach class, since it has the @Lazy annotation and is not needed
        
      ○ Therefore, to configure other beans to lazy initialization

        ■ We would need to add @Lazy to each class

        ■ Turns into tedious work for a large number of classes

        ■ And for this, we can actually set a global configuration property

      
      ○  Global Configuration

        ■ In the application.properties file, we can add

          □ spring.main.lazy-initialization=true

          □ This way, all beans are lazy, no beans are created until needed, including our DemoController 

        ■ Once we access REST endpoint /dailyworkout spring will determine dependencies for DemoController

          □ For dependency resolution resolution Spring creates instance of CricketCoach first...

            - `Dependency Resolution` is the process where Spring: 

              1. Identifies which dependencies a bean needs (for example, DemoController needs a Coach)
              2. Locates the beans that satisfy those dependencies
              3. Creates the necessary beans instances, in case there are none (If they are lazy, for example)
              4. Injects these dependencies in the bean being created.

              . If all beans are lazy, and a bean needs a dependency, but there's no @Primary nor @Qualifier to indicate
              which one to use, it will throw the same error as seen before where there are more than one bean that satisfy
              the condition but it does not know which one to choose


          □ Then creates instance of DemoController and injects the CricketCoach into the `DemoController`

      ○ For more diagnostics we can Add println to DemoController constructor

        ■ For dependency resolution, Spring creates an instance of CricketCoach first then creates instance of DemoController
        and injects the CricketCoach

      ○ Stepping back to Lazy Initialization

        ■ Advantages

          □ Only creates objects as needed 
          □ May help with faster startup time if we have a large number of components
        
        ■ Disadvantages

          □ If we have web related components like @RestController, they are not created until Request, needing to be
          created first and then use it
          □ May not discover configuration issues until too late
          □ Need to make sure to have enough memory for all beans once created

        ■ Lazy Initialization is disabled by default. We should profile our application before configuring lazy init and
          have to avoid common pitfall of premature optimization
        
  ## Lesson 20 ~ 21: Lazy Initialization - Coding

    ● Go to IntelliJ, do the normal housekeeping, create the new project, and utilize what we've just learned.

  ## Lesson 22 - Bean Scopes - Overview

       
        




        


  ## Comments not related to lessons

    ○ Autowired
      
        ■ @Autowired can be omitted after Spring 4.3. This class should be used only if there is only one public setter
          with a parameter, Spring can infer automatically that it must be used for dependency injection

          So if in the case above, we omitted the @Autowired, is work as long as it is the only setter with a parameter.

        ■ We must explicitly use it when:

            . There are many setters or many methods with a parameter, then Spring doesn't know which one to choose.
            . If we want to let the intention clear (good practice in large teams).
            . If we are using injection by constructor and want to keep the compatibility with older versions (Spring < 4.3)

    ○ This is not always required

      ■ The code, such as the myCoach from the RestController, works without `this` because in Java, `this` is optional
      in cases where there is no ambiguity between the parameter names and classes fields

        □ In our case, the parameter is called theCoach and the field is called myCoach, since they are different, the
        compiler knows exactly to what we are referring to, so writing myCoach = theCoach; is enough
        □ It would only be necessary, if the parameter name, in this case, was also myCoach, it would be necessary to avoid
        confusions in the compiler
    

    ○ Even though a class may implement the interface method, we must annotate it as @Component so it will be marked as a 
    Spring Bean
