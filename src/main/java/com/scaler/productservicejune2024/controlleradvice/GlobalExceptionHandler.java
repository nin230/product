package com.scaler.productservicejune2024.controlleradvice;

import com.scaler.productservicejune2024.CustomException.ProductNotFoundException;
import com.scaler.productservicejune2024.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
       @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity <ExceptionDto>handleArithmeticException() {
           ExceptionDto exceptionDto = new ExceptionDto();

           exceptionDto.setMessage("Arithmetic Exception has occured");
           exceptionDto.setSolution("please try again");

        ResponseEntity<ExceptionDto> response = new ResponseEntity<>
                (exceptionDto ,
                HttpStatus.BAD_REQUEST
                );
        return response;
        }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity <String>handleArrayIndexOutOfBoundsException() {
        ResponseEntity<String> response = new ResponseEntity<>
                ("ArrayIndex out of bound Exception has occured" ,
                        HttpStatus.NOT_FOUND
                );
        return response;
    }
     @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handlePeoductNotFoundException(){
         ExceptionDto exceptionDto = new ExceptionDto();
         exceptionDto.setMessage("Product Not Found");
         exceptionDto.setSolution("please try again with valid product id");

         ResponseEntity<ExceptionDto> response = new ResponseEntity<>
                 (exceptionDto ,
                         HttpStatus.BAD_REQUEST
                 );
         return response;
    }
//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity <String>handleNullPointerException() {
//        ResponseEntity<String> response = new ResponseEntity<>
//                ("Null Pointer Exception has occured" ,
//                        HttpStatus.NOT_FOUND
//                );
//        return response;
//    }
}
