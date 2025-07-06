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
          return fortuneService.getFortune()
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
              this.fortuneService = fortuneService
            }

            public String getDailyFortune() {
              return fortuneService.getFortune()
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
        on a configuration


  
  ● Spring Container

    ○ Primary Functions
      ■ Create and manage objects (Inversion of Control)
      ■ Inject object dependencies (Dependency Injection)

    ○ Configuring Spring Container
      ■ XML configuration file (legacy)
      ■ Java Annotations (modern)
      ■ Java Source Code (modern)

    ○ How it works

      ■ Spring container kinda works as the object factory, so, my application can talk to the Spring Container: "hey,
      give me a coach object and this coach object may have additional dependencies or additional helpers. Imagine we
      have a head-coach and he may have a staff of assisting coaches, physical trainers, medical staff, and so on. Therefore
      we say: "Hey, give me everything that i need to make use of this given coach", and then it will give to us all put
      together, ready-to-go, out-of-the-box.

    ○ Spring Container Refresher

      ■ It has Primary Functions

        □ Create and manage object (Inversion of Control)

        □ Inject object's dependencies (Dependency Injection)


  
