package com.joaopedromattos.shipment_company.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Object> handleException(ApplicationException exception) {

        ShipmentExceptionResponse error = ShipmentExceptionResponse.builder()
                            .mensagem(exception.getMessage())
                            .timeStamp(LocalDateTime.now())
                            .status(exception.getStatus().value())
                            .build();

            return new ResponseEntity<>(error, exception.getStatus());
    }

}
