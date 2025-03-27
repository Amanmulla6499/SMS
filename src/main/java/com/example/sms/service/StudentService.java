package com.example.sms.service;

import com.example.sms.entity.Course;
import com.example.sms.entity.Student;
import com.example.sms.entity.Address;

import java.util.List;

public interface StudentService {

	Student addStudent(Student student);

	void updateStudent(Student student);

	List<Student> getAllStudents();

	Student getStudentById(Long studentId);

	List<Student> getStudentsByName(String studentName);

	Student enrollStudentInCourse(Long studentId, Long courseId);

	void deleteStudent(Long studentId);

	Course addCourse(Course course);

	List<Course> getAllCourses();

	Course getCourseById(Long courseId);
}
