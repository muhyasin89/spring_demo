package com.example.demo.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
	}

    public void addNewStudent(Student student){
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email has been taken");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentID){
        boolean exists = studentRepository.existsById(studentID);

        if (!exists){
            throw new IllegalStateException("Student with ID: "+ studentID + "does not exist");
        }
        
        studentRepository.deleteById(studentID);
    }

    @Transactional
    public void updateStudent(Long studentID, String name, String email){
        Student student = studentRepository.findById(studentID)
        .orElseThrow( () -> new IllegalStateException(
            "Student with ID:"+ studentID + " does not exist"
        ));

        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), name)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email has already been taken");
            }

            student.setEmail(email);
        }
    }
}
