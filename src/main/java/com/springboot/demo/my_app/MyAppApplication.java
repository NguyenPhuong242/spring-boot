package com.springboot.demo.my_app;

import com.springboot.demo.my_app.dao.StudentDAO;
import com.springboot.demo.my_app.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

// This annotation is a combination of the following annotations:
// - scanBasePackages: to specify the base packages to scan for annotated components and input beans
//@SpringBootApplication(
//		scanBasePackages = "com.springboot.demo"
//)

// SpringBootApplication
@SpringBootApplication
@ComponentScan(basePackages = "com.springboot.demo")
public class MyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudent(studentDAO);
//			queryForStudentByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		// delete all students
		int count = studentDAO.deleteAll();
		System.out.println("Deleted students: " + count);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		// delete the student
		System.out.println("Deleting student");
		studentDAO.delete(1);
		// print the student
		System.out.println("Deleted student: " + 1);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve the student on the id: primary key
		Student myStudent = studentDAO.findById(1);
		System.out.println("Found student: " + myStudent);
		// change the first name
		myStudent.setFirstName("Scooby");
		// save the student
		studentDAO.update(myStudent);
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Doe");
		// query for students
		System.out.println("Querying for students");
		// get all students
		for (Student student : students) {
			System.out.println("Found student: " + student);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		// query for students
		System.out.println("Querying for students");
		// get all students
		for (Student student : students) {
			System.out.println("Found student: " + student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// Create a student object
		System.out.println("Creating a new student");
		Student student = new Student("adam", "smith", "dqw@dw.com");

		// Save the student
		System.out.println("Saving the student");
		studentDAO.save(student);


		// retrieve the student base on the id: primary key
		Student myStudent = studentDAO.findById(student.getId());
		System.out.println("Found student: " + myStudent);

		// display the student
		System.out.println("Found student: " + myStudent.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating multiple students");
		Student student1 = new Student("John", "Doe", "123@123.com");
		Student student2 = new Student("Mary", "Public", "sd@sad.com");
		Student student3 = new Student("Bon", "Jovi", "sadas@dwdwd.com");
		// save the students
		System.out.println("Saving the students");
		studentDAO.save(student1);
		// print the student
		System.out.println("Saved student: " + student1.getId());
		studentDAO.save(student2);
		// print the student
		System.out.println("Saved student: " + student2.getId());
		studentDAO.save(student3);
		// print the student
		System.out.println("Saved student: " + student3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {
		// create a student
		System.out.println("Creating a new student");
		Student student = new Student("John", "Doe", "coucou@asdas.com");
		// save the student
		System.out.println("Saving the student");
		studentDAO.save(student);
		// print the student
		System.out.println("Saved student: " + student.getId());
	}

}
