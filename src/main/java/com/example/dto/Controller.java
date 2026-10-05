package com.example.dto;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import jakarta.validation.Valid;
@RestController
public class Controller {
    private final StudentService studentService;
    public Controller(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }
    @DeleteMapping("/students/{id}")
    public boolean deleteStudent(@PathVariable Integer id){
        return studentService.deleteStudent(id);
    }
    @GetMapping("/students/name/{name}")
    public List<Student> getStudentsByName(@PathVariable String name){
        return studentService.getStudentsByName(name);
    }
    @GetMapping("/students/age/{age}")
    public List<Student> getStudentsByAge(@PathVariable Integer age){
        return studentService.getStudentsByAge(age);
    }
    @GetMapping("/students/name/{name}/age/{age}")
    public List<Student> getStudentsByNameAndAge(@PathVariable String name,@PathVariable Integer age){
        return studentService.getStudentsByNameAndAge(name, age);
    }
    @GetMapping("/students/age/gThan/{age}")
    public List<Student> getStudentsByAgeGreaterThan(@PathVariable Integer age){
        return studentService.getStudentsByAgeGreaterThan(age);
    }
    @GetMapping("/students/age/lThan/{age}")
    public List<Student> getStudentsByAgeLessThan(@PathVariable Integer age){
        return studentService.getStudentsByAgeLessThan(age);
    }
    @GetMapping("/students/name/containing/{text}")
    public List<Student> getStudentsContaining(@PathVariable String text){
        return studentService.getStudentsByNameContaining(text);
    }
    @GetMapping("/students/name/startingwith/{ch}")
    public List<Student> getStudentsByNameStartingWith(@PathVariable char ch){
        return studentService.getStudentsByNameStartingWith(ch);
    }
    
    @GetMapping("/students/studentdtos/{id}")
    public StudentDTO getStudentDTOById(@PathVariable Integer id){
        return studentService.getStudentDTOById(id);
    }
    @GetMapping("/students/studentdtos")
    public List<StudentDTO> getAllStudentDTOs(){
        return studentService.getAllStudentDTOs();
    }
    @PostMapping("/students/studentdtos")
    public Student addStudentByDTO(@Valid @RequestBody StudentDTO studentDTO){
        return studentService.addStudentByDTO(studentDTO);
    }
}
