package com.example.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
public class StudentDTO {
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50")
    private String name;
    @NotNull(message = "Age is required")
    @Min(value = 1,message = "Aeg must be at least 1")
    @Max(value = 100, message = "Age should not exceed 100")
    private Integer age;
    public StudentDTO(){
    }
    public StudentDTO(String name, Integer age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Integer getAge(){
        return age;
    }
    public void setAge(Integer age){
        this.age = age;
    }
}
