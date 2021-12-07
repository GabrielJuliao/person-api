package com.gabrieljuliao.personapi.controllers;

import com.gabrieljuliao.personapi.dto.PersonDTO;
import com.gabrieljuliao.personapi.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/person", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<?> setPerson(@RequestBody PersonDTO personDTO) {
        return new ResponseEntity<>(
                personService.create(personDTO),
                HttpStatus.CREATED
        );
    }
}
