package com.example.student_data_jpa.entity;

import jakarta.persistence.*;

@Entity
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Student_name")
    private String name;

    @Column(name = "Student_age")
    private int age;

    public Student(){

    }
    public Student( String name, int age){
        this.name=name;
        this.age=age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

