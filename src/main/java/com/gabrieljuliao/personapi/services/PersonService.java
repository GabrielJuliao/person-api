package com.gabrieljuliao.personapi.services;

import com.gabrieljuliao.personapi.dto.PersonDTO;
import com.gabrieljuliao.personapi.entity.Person;
import com.gabrieljuliao.personapi.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    public PersonService(PersonRepository personRepository, ModelMapper modelMapper) {
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;
    }

    public PersonDTO create(PersonDTO personDTO){
        return modelMapper.map(
                personRepository.save(
                        modelMapper.map(personDTO, Person.class)
                ),
                PersonDTO.class
        );
    }
}
