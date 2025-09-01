package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    // Executed after the Spring beans have been loaded, and we can use it with this given method
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {

//          createStudent(studentDAO);

//          createMultipleStudent(studentDAO);

//          readStudent(studentDAO);

//          queryForStudents(studentDAO);

            queryForStudentsByLastName(studentDAO);
        };
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        // get a list of students
        List<Student> theStudents = studentDAO.findByLastName("Ceretta");


        // display list of students
        for (Student tempStudent: theStudents) {
            System.out.println(tempStudent);
        }


    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get a list of students
            List<Student> theStudents = studentDAO.findAll();

        // display list of students
            for(Student tempStudent: theStudents) {
                System.out.println(tempStudent);

            }

    }

    private void readStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new student object");
        Student tmpStudent = new Student("Caio", "Ceretta", "caioceretta@gmail.com");

        // save the student object
        System.out.println("Saving the student object...");
        studentDAO.save(tmpStudent);
        // display id of the saved student
        int theId = tmpStudent.getId();
        System.out.println("Saved student. Generated id: " + theId);

        // display student
        System.out.println("Retrieving student with the id: " + theId);
        Student student = studentDAO.findById(theId);

        // display student
        System.out.println("Found Student: " + student);


    }

    private void createMultipleStudent(StudentDAO studentDAO) {
        // create multiple students
        System.out.println("Creating 3 student objects");
        Student tempStudent1 = new Student("Thiago", "Marcelino", "thiago.distend@hotmail.com");
        Student tempStudent2 = new Student("Alex", "Ceretta", "alex.ceretta@gmail.com");
        Student tempStudent3 = new Student("André", "Ceretta", "andre_ceretta@gmail.com");
        // save the students objects
        System.out.println("Saving the students...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

    }


    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new student object");
        Student tmpStudent = new Student("Caio", "Ceretta", "caioceretta@gmail.com");

        // save the student object
        System.out.println("Saving the student object...");
        studentDAO.save(tmpStudent);

        // display id
        System.out.println("Saved student. Generated id: " + tmpStudent.getId());
    }

}
