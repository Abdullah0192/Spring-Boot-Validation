package com.example.dto;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public Student getStudentById(Integer id){
        return studentRepository.findById(id).orElse(null);
    }
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }
    public Student updateStudent(Integer id, Student student){
        student.setId(id);
        return studentRepository.save(student);
    }
    public boolean deleteStudent(Integer id){
        if (studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return true;
        }
        return false; 
    }
    public List<Student> getStudentsByName(String name){
        return studentRepository.findByName(name);
    }
    public List<Student> getStudentsByAge(Integer age){
        return studentRepository.findByAge(age);
    }
    public List<Student> getStudentsByNameAndAge(String name, Integer age){
        return studentRepository.findByNameAndAge(name, age);
    }
    public List<Student> getStudentsByAgeGreaterThan(Integer age){
        return studentRepository.findByAgeGreaterThan(age);
    }
    public List<Student> getStudentsByAgeLessThan(Integer age){
        return studentRepository.findByAgeLessThan(age);
    }
    public List<Student> getStudentsByNameContaining(String text){
        return studentRepository.findByNameContaining(text);
    }
    public List<Student> getStudentsByNameStartingWith(char ch){
        return studentRepository.findByNameStartingWith(ch);
    }
    
    public StudentDTO convertToDTO(Student student){
        StudentDTO studentDTO = new StudentDTO(student.getName(), student.getAge());
        return studentDTO;
    }
    public StudentDTO getStudentDTOById(Integer id){
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null){
            return null;
        }
        return convertToDTO(student);
    }
    public List<StudentDTO> getAllStudentDTOs(){
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOs = new ArrayList<>();
        for (Student student: students){
            studentDTOs.add(convertToDTO(student));
        }
        return studentDTOs;
    }
    public Student convertToEntity(StudentDTO studentDTO){
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        return student;
    }
    public Student addStudentByDTO(StudentDTO studentDTO){
        Student student = convertToEntity(studentDTO);
        return addStudent(student);
    }
}
