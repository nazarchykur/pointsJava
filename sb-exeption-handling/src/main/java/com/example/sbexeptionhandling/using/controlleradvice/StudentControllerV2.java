package com.example.sbexeptionhandling.using.controlleradvice;

import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/students")
public class StudentControllerV2 {

    @PostMapping
    public String save(@RequestBody Student student) {
        if (ObjectUtils.isEmpty(student.getEmail())) {
            throw new InvalidFieldException("Email is required");
        }
        return "Data saved";
    }
    
        /*
        Request:
                POST http://localhost:8080/api/v2/students
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
                    POST http://localhost:8080/api/v2/students
                    Content-Type: application/json
                    
                    {
                      "id": 1,
                      "firstName": "f1",
                      "lastName": "l1"
                    }
            
            Response:
                    POST http://localhost:8080/api/v2/students

                    HTTP/1.1 404 
                    Content-Type: application/json;charset=UTF-8
                    
                    {
                      "timestamp": "2023-01-25T14:36:09.179+00:00",
                      "status": 404,
                      "error": "Not Found",
                      "path": "/api/v2/students"
                    }
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
}
/*
        Success
            Request
                    POST http://localhost:8080/api/v2/students/entity
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
                    POST http://localhost:8080/api/v2/students/entity
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