package com.gabrieljuliao.personapi.services;

import com.gabrieljuliao.personapi.dto.PersonDTO;
import com.gabrieljuliao.personapi.exceptions.ResourceNotFoundException;
import com.gabrieljuliao.personapi.mappers.PersonMapper;
import com.gabrieljuliao.personapi.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonDTO create(PersonDTO personDTO) {
        return personMapper.toDTO(
                personRepository.save(personMapper.toModel(personDTO))
        );
    }

    public Iterable<PersonDTO> readAll() {
        return personRepository.findAll().stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public PersonDTO readOne(Long id) {
        if (personRepository.existsById(id)) {
            return personMapper.toDTO(personRepository.getById(id));
        }
        throw new ResourceNotFoundException();
    }

    public PersonDTO update(PersonDTO personDTO) {
        if (personRepository.existsById(personDTO.getId())) {
            return personMapper.toDTO(
                    personRepository.save(
                            personMapper.toModel(personDTO)
                    )
            );
        }
        throw new ResourceNotFoundException();
    }

    public void delete(Long id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return;
        }
        throw new ResourceNotFoundException();
    }
}
