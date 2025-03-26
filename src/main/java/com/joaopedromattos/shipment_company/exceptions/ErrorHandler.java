package com.joaopedromattos.shipment_company.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Object> handleApplicationException(ApplicationException exception) {
        ShipmentExceptionResponse error = ShipmentExceptionResponse.builder()
                            .mensagem(exception.getMessage())
                            .timeStamp(LocalDateTime.now())
                            .status(exception.getStatus().value())
                            .build();

        return new ResponseEntity<>(error, exception.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ShipmentExceptionResponse error = ShipmentExceptionResponse.builder()
                            .mensagem("Validation failed: " + errors)
                            .timeStamp(LocalDateTime.now())
                            .status(HttpStatus.BAD_REQUEST.value())
                            .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
