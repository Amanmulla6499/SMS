package com.example.sms.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sms.entity.Address;
import com.example.sms.entity.Course;
import com.example.sms.entity.Student;
import com.example.sms.repository.AddressRepository;
import com.example.sms.repository.CourseRepository;
import com.example.sms.repository.StudentRepository;
import com.example.sms.service.StudentService;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long studentId) {
		return studentRepository.findById(studentId).orElse(null);
	}

	@Override
	public List<Student> getStudentsByName(String studentName) {
		return studentRepository.findByStudentNameContainingIgnoreCase(studentName);
	}

	@Override
	public Student enrollStudentInCourse(Long studentId, Long courseId) {
		Student student = studentRepository.findById(studentId).orElse(null);
		Course course = courseRepository.findById(courseId).orElse(null);

		if (student != null && course != null) {
			student.getCourses().add(course);
			return studentRepository.save(student);
		}
		return null;
	}

	@Override
	public void deleteStudent(Long studentId) {
		studentRepository.deleteById(studentId);
	}

	@Override
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	@Override
	public Course getCourseById(Long courseId) {
		return courseRepository.findById(courseId).orElse(null);
	}

	@Override
	public List<Course> getCoursesByName(String courseName) {
		return courseRepository.findByCourseNameContainingIgnoreCase(courseName);
	}

	@Override
	public void deleteCourse(Long courseId) {
		courseRepository.deleteById(courseId);
	}

	@Override
	public Address addAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public List<Address> getAllAddresses() {
		return addressRepository.findAll();
	}

	@Override
	public List<Address> getAddressesByStudentId(Long studentId) {
		return addressRepository.findByStudentStudentId(studentId);
	}

	@Override
	public void deleteAddress(Long addressId) {
		addressRepository.deleteById(addressId);
	}

	@Override
	public void updateStudent(Student student) {
		Student existingStudent = studentRepository.findById(student.getStudentId())
				.orElseThrow(() -> new RuntimeException("Student not found"));

		existingStudent.setStudentName(student.getStudentName());
		existingStudent.setStudentDob(student.getStudentDob());
		existingStudent.setStudentGender(student.getStudentGender());
		existingStudent.setStudentUniqueCode(student.getStudentUniqueCode());

		studentRepository.save(existingStudent);
	}

}
