package com.example.project.BackendSpring.Exception;

import com.example.project.BackendSpring.Services.Implement.UnitService;
import com.example.project.BackendSpring.Utilities.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    private ResponseEntity<ErrorResponse> handleException(Exception ex) {
        // log exception
        ErrorResponse error = new ErrorResponse();
        error.setError(ex.getClass().getSimpleName());
        error.setMessage("Đã xảy ra lỗi");
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        logger.error("Đã xảy ra lỗi: " + error.getError());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

}
