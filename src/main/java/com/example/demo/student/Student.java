package com.example.demo.student;

import java.time.LocalDate;

import jdk.vm.ci.meta.Local;

public class Student {
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;

    public Student() {

    }

    public Student(Long id, String name, String email, LocalDate dob, Integer age){
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    public Student( String name, String email, LocalDate dob, Integer age){
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    public void setId(Long id){
        this.id = id;
    }


    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setDob(LocalDate dob){
        this.dob = dob;
    }

    public LocalDate getDob(){
        return dob;
    }

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public String toString(){
        return "Student{" +
                "id="+ id +
                ", name"+ name+
                ", email"+ email+
                ", dob"+ dob +
                ", age"+ age+
                '}';
                
    }
    
}
