package com.example.student_api.StudentController;

import com.example.student_api.Student.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/students")
public class StudentController {
    static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1,"Harati",21));
        students.add(new Student(2,"Srinivas",18));
        students.add(new Student(3,"Grishma",16));
        students.add(new Student(4,"Vignesh",21));
        students.add(new Student(5,"Pranay",18));
        students.add(new Student(6,"Pranavi",26));
    }
    @GetMapping
    public ResponseEntity<List<Student>>
    getStudents(){
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudents(@PathVariable int id){
        for(Student student : students){
            if(student.getId() == id){
                return ResponseEntity.ok(student);
            }

        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudent(@RequestParam String name){
        List<Student> result = new ArrayList<>();
        for(Student student : students){
            if(student.getName().equalsIgnoreCase(name)){
                result.add(student);
                return ResponseEntity.ok(result);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Student> createStudents(@RequestBody Student student){
        students.add(student);

        return ResponseEntity.ok(student);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudents(@PathVariable int id, @RequestBody Student updatedS){
        for(Student student : students){
            if(student.getId() == id){
                student.setName(updatedS.getName());
                student.setAge(updatedS.getAge());
                return ResponseEntity.ok(student);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id){
        for(Student student : students){
            if(student.getId() == id){
                students.remove(student);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}

