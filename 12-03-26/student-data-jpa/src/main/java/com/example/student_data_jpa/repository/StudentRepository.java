package com.example.student_data_jpa.repository;

import com.example.student_data_jpa.entity.Student;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);
    List<Student> findByNameAndAge(String name, int age);
    List<Student> findByNameContaining(String name);
    Long countByAge(int age);

    @Query("select s from Student s where s.age > :age")
    List<Student> findByAgeGreaterThan(@Param("age") int age);



}