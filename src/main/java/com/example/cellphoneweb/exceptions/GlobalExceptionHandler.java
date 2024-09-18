package com.example.cellphoneweb.exceptions;


import com.example.cellphoneweb.responses.ApiReponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiReponse> handleGeneralException(Exception ex, HttpServletRequest request) {
        ApiReponse response = ApiReponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("An unexpected error occurred: " + ex.getMessage())
                .data(null)
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiReponse> handleValidationException(MethodArgumentNotValidException ex) {
        StringBuilder errors = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            errors.append(error.getDefaultMessage()).append("; ");
        });

        ApiReponse response = ApiReponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Validation failed: " + errors.toString())
                .data(null)
                .build();
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiReponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ApiReponse response = ApiReponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message("Resource not found: " + ex.getMessage())
                .data(null)
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
