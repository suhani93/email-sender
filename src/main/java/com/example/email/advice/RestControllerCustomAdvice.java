package com.example.email.advice;

import com.example.email.response.ErrorResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestControllerCustomAdvice {

    @ExceptionHandler(Exception.class)
    public ErrorResponse serverError(){
        List<String> errors = new ArrayList<>();
        errors.add("서버에 이상이 생겼습니다.");

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrors(errors);

        return errorResponse;
    }

    @ExceptionHandler({BindException.class})
    public ErrorResponse processValidationError(BindException exception) {
        List<String> errors = new ArrayList<>();

        BindingResult bindingResult = exception.getBindingResult();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            builder.append(fieldError.getField());
            builder.append("] : ");
            builder.append(fieldError.getRejectedValue());
            builder.append(" => ");
            builder.append(fieldError.getDefaultMessage());
            errors.add(builder.toString());
        }

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrors(errors);

        return errorResponse;
    }
}
