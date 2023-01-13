package com.example.project.BackendSpring.Exception;

import com.example.project.BackendSpring.Utilities.TemplateApi;
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
    private ResponseEntity<TemplateApi> handleException(Exception ex) {
        // log exception
        TemplateApi error = new TemplateApi();
        error.setMessage("Đã xảy ra lỗi");
        error.setFail(true);
        error.setSuccess(false);

        logger.error("Đã xảy ra lỗi: " + error.getMessage(), error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

}
