package com.example.student_data_jpa.controller;

import com.example.student_data_jpa.entity.Student;
import com.example.student_data_jpa.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {
    private final StudentRepository studentRepository;
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @GetMapping
    public ResponseEntity<List<Student>>
    getStudents(){
        return ResponseEntity.ok(studentRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudents(@PathVariable Long id){
        return studentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudent(@RequestParam String name){
        List<Student> result = studentRepository.findByName(name);
       if(result.isEmpty()){
           return ResponseEntity.notFound().build();
       }
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Student> createStudents(@RequestBody Student student){
        Student student1 = studentRepository.save(student);

        return ResponseEntity.status(201).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudents(@PathVariable Long id, @RequestBody Student updatedS){
        return studentRepository.findById(id)
                .map(student1 ->
                {
                    student1.setName(updatedS.getName());
                    student1.setAge(updatedS.getAge());
                    return ResponseEntity.ok(studentRepository.save(student1));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        if(!studentRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        studentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{age}")
    public ResponseEntity<List<Student>> getStudentByAge(@PathVariable int age){
        List<Student> result =studentRepository.findByAgeGreaterThan(age);

        if(result.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Student>> filterByNameAndAge(@RequestParam String name, @RequestParam int age){
        List<Student> result = studentRepository.findByNameAndAge(name, age);

        if(result.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> filterByContaining(@RequestParam String name){
        List<Student> result = studentRepository.findByNameContaining(name);

        if(result.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> filterByAge(@RequestParam int age){
        long count = studentRepository.countByAge(age);
        return ResponseEntity.ok(count);
    }

}

