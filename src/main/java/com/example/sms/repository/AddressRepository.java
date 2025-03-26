package com.example.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sms.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findByStudentStudentId(Long studentId);

}
