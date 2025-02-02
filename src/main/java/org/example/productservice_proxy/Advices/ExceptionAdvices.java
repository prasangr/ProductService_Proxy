package org.example.productservice_proxy.Advices;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvices {
@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e){
        return new ResponseEntity<>("Kuch toh phata hai ", org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
