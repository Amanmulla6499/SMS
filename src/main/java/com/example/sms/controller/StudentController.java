package com.example.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms.entity.Address;
import com.example.sms.entity.Course;
import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Student savedStudent = studentService.addStudent(student);
		return ResponseEntity.ok(savedStudent);
	}

	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents() {
		return ResponseEntity.ok(studentService.getAllStudents());
	}

	@GetMapping("/getStudent/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		Student student = studentService.getStudentById(id);
		return ResponseEntity.ok(student);
	}

	@GetMapping("/getStudentsByName/{name}")
	public ResponseEntity<List<Student>> getStudentsByName(@PathVariable String name) {
		return ResponseEntity.ok(studentService.getStudentsByName(name));
	}

	@PostMapping("/enrollStudent/{studentId}/course/{courseId}")
	public ResponseEntity<Student> enrollStudentInCourse(@PathVariable Long studentId, @PathVariable Long courseId) {

		Student student = studentService.enrollStudentInCourse(studentId, courseId);
		return ResponseEntity.ok(student);
	}

	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return ResponseEntity.ok("Student deleted successfully");
	}

	@PostMapping("/addCourse")
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {
		Course savedCourse = studentService.addCourse(course);
		return ResponseEntity.ok(savedCourse);
	}

	@GetMapping("/getAllCourses")
	public ResponseEntity<List<Course>> getAllCourses() {
		return ResponseEntity.ok(studentService.getAllCourses());
	}

	@GetMapping("/getCourse/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
		Course course = studentService.getCourseById(id);
		return ResponseEntity.ok(course);
	}


	@PutMapping("/updateStudent/{studentId}")
	public ResponseEntity<String> updateStudent(@PathVariable Long studentId, @RequestBody Student student) {
		if (!studentId.equals(student.getStudentId())) {
			return ResponseEntity.badRequest().body("ID in path and body must match");
		}
		studentService.updateStudent(student);
		return ResponseEntity.ok("Student updated successfully");
	}

}
