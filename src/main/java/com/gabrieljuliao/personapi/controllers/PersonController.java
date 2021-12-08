package com.gabrieljuliao.personapi.controllers;

import com.gabrieljuliao.personapi.dto.PersonDTO;
import com.gabrieljuliao.personapi.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> setPerson(@RequestBody @Valid PersonDTO personDTO) {
        return new ResponseEntity<>(personService.create(personDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getPersons() {
        return new ResponseEntity<>(personService.readAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getAPerson(@PathVariable("id") Long id) {
        return new ResponseEntity<>(personService.readOne(id), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateAPerson(@RequestBody PersonDTO personDTO) {
        return new ResponseEntity<>(personService.update(personDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAPerson(@PathVariable("id") Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
