package com.example.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sms.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	List<Course> findByCourseNameContainingIgnoreCase(String courseName);
}
