package com.example.dto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface StudentRepository extends JpaRepository<Student, Integer>{
    List<Student> findByName(String name);
    List<Student> findByAge(Integer age);
    List<Student> findByNameAndAge(String name, Integer age);
    List<Student> findByAgeGreaterThan(Integer age);
    List<Student> findByAgeLessThan(Integer age);
    List<Student> findByNameContaining(String text);
    List<Student> findByNameStartingWith(char ch);
}
