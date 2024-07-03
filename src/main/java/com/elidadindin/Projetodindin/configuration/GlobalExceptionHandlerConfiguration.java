package com.elidadindin.Projetodindin.configuration;

import com.elidadindin.Projetodindin.models.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandlerConfiguration {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseModel> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<String> messages = null;
        BindingResult bindingResult = ex.getBindingResult();
        if (bindingResult != null) {
            messages = bindingResult.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        }

        return ResponseEntity.badRequest().body(new ResponseModel(null, messages));
    }
}