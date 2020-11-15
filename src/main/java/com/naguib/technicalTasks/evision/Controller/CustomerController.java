package com.naguib.technicalTasks.evision.Controller;

import com.naguib.technicalTasks.evision.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/invalid-request")
public class CustomerController {
    @GetMapping
    public ResponseEntity getActiveUser() {
        return new ResponseEntity(new ResponseDTO("You have sent wrong payload, please check it again."
                , "400"), HttpStatus.BAD_REQUEST);
    }
}
