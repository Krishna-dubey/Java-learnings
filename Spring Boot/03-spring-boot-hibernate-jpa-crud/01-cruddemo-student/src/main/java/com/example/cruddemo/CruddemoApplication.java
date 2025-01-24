package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			// createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);

			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numOfRowsDeleted = studentDAO.deleteAll();
		System.out.println("Number of rows deleted: " + numOfRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId=3;
		System.out.println("Deleting Student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on id: primary key
		int studentId = 1;
		System.out.println("Get student with id: " + studentId);
		Student student = studentDAO.findById(studentId);

		// change the first name
		System.out.println("Updating student....");
		student.setFirstName("Govind");

		// update the student in database
		studentDAO.update(student);

		// display the updated student
		System.out.println("Updated student: " + student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Dubey");

		// Display students
		for( Student student : theStudents){
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display the list of students
		for( Student student : theStudents){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student object");
		Student student = new Student("Sushil", "Dubey", "krishnadubey@gmail.com");

		// save the student object
		System.out.println("Saving student object in database");
		studentDAO.save(student);

		// display student id
		System.out.println("Saved student. Generated id: " + student.getId());

		// retrieve student based on id: primary key
		System.out.println("Retrieving student with id: " + student.getId());
		Student retrievedStudent = studentDAO.findById(student.getId());

		// display student
		System.out.println("Retrieved student details:" + retrievedStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating 3 students object");
		Student student1 = new Student("Krishna", "Dubey", "krishnadubey@gmail.com");
		Student student2 = new Student("Ankita", "Dubey", "krishnadubey@gmail.com");
		Student student3 = new Student("Aman", "Dubey", "krishnadubey@gmail.com");


		// save the students
		System.out.println("Saving 3 students object in database");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating student object");
		Student student = new Student("Krishna", "Dubey", "krishnadubey@gmail.com");

		// save the student object
		System.out.println("Saving student object in database");
		studentDAO.save(student);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + student.getId());
	}


}
