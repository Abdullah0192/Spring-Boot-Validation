package com.example.dto;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Map;
import java.util.HashMap;
import org.springframework.http.ResponseEntity;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    errors.put(error.getField(), error.getDefaultMessage());
                });
        ValidationErrorResponse response = new ValidationErrorResponse();
        response.setStatus(400);
        response.setMessage("Validation failed");
        response.setErrors(errors);
        return ResponseEntity.status(400).body(response);
    }
}
