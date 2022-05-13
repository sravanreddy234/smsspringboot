package com.sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.beans.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
