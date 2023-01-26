package com.example.sbexeptionhandling.using.exceptionhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @PostMapping
    public String save(@RequestBody Student student) {
        if (ObjectUtils.isEmpty(student.getEmail())) {
            throw new InvalidFieldException("Email is required");
        }
        return "Data saved";
    }
    
//    @ExceptionHandler(InvalidFieldException.class)
//    public String handleInvalidFieldException(InvalidFieldException e) {
//        return e.getMessage();
//    }

    @ExceptionHandler
    public String handleInvalidFieldException(InvalidFieldException e) {
        return e.getMessage();
    }

    
    
/*
    Success
            Request:
                    POST http://localhost:8080/api/v1/students
                    Content-Type: application/json
                    
                    {
                      "id": 1,
                      "firstName": "f1",
                      "lastName": "l1",
                      "email": "f1@example.com"
                    }
                
                
            Response:
                    HTTP/1.1 200 
                    Content-Type: text/plain;charset=UTF-8
                    
                    Data saved
 */

/*

    Error
            Request:
                    POST http://localhost:8080/api/v1/students
                    Content-Type: application/json
                    
                    {
                      "id": 1,
                      "firstName": "f1",
                      "lastName": "l1"
                    }
            
            Response:
                    HTTP/1.1 200 
                    Content-Type: text/plain;charset=UTF-8
                    
                    Email is required
 */
    
    /*
    -------------------------------------------------------------------------------------------------------------------
    ----------------------------           with ResponseEntity               ----------------------------------------
    -------------------------------------------------------------------------------------------------------------------
     */

    @PostMapping("/entity")
    public ResponseEntity<Student> saveEntity(@RequestBody Student student) {
        if (ObjectUtils.isEmpty(student.getEmail())) {
            throw new InvalidEntityException("Email is required");
        }
        return ResponseEntity.ok().body(student);
    }
    
    
//    @ExceptionHandler
//    public ResponseEntity<?> handleInvalidFieldException(InvalidEntityException e) {
//       return ResponseEntity
//               .status(HttpStatus.BAD_REQUEST)
//               .body(e.getMessage()); 
//    }

    @ExceptionHandler
    public ResponseEntity<?> handleInvalidFieldException(InvalidEntityException e) {
        return ResponseEntity
                .badRequest()
                .body(e.getMessage());
    }
    
    /*
        Success
            Request
                    POST http://localhost:8080/api/v1/students/entity
                    Content-Type: application/json
                    
                    {
                      "id": 1,
                      "firstName": "f1",
                      "lastName": "l1",
                      "email": "f1@example.com"
                    }
                   
                   
             Response:
                    HTTP/1.1 200 
                    Content-Type: application/json
                    
                    {
                      "id": 1,
                      "firstName": "f1",
                      "lastName": "l1",
                      "email": "f1@example.com"
                    }
                           
     */
    
    /*

    Error
            Request:
                    POST http://localhost:8080/api/v1/students/entity
                    Content-Type: application/json
                    
                    {
                      "id": 1,
                      "firstName": "f1",
                      "lastName": "l1"
                    }
            
            Response:
                    HTTP/1.1 400 
                    Content-Type: text/plain;charset=UTF-8
                    
                    Email is required
 */

}
