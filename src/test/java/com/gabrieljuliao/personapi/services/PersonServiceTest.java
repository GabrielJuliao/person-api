package com.gabrieljuliao.personapi.services;

import com.gabrieljuliao.personapi.dto.PersonDTO;
import com.gabrieljuliao.personapi.dto.PhoneDTO;
import com.gabrieljuliao.personapi.entity.Person;
import com.gabrieljuliao.personapi.entity.Phone;
import com.gabrieljuliao.personapi.enums.PhoneType;
import com.gabrieljuliao.personapi.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;
    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedDTO() {
        PhoneDTO mockPhoneDTO = PhoneDTO
                .builder()
                .id(1L)
                .type(PhoneType.MOBILE)
                .number("+5561999999999")
                .build();

        PersonDTO mockPersonDTO = PersonDTO
                .builder()
                .id(1L)
                .firstName("John")
                .lastName("Doe")
                .cpf("460.771.400-31")
                .phones(Set.of(mockPhoneDTO))
                .build();

        Phone mockPhone = Phone
                .builder()
                .id(1L)
                .type(PhoneType.MOBILE)
                .number("+5561999999999")
                .build();

        Person mockPerson = Person
                .builder()
                .id(1L)
                .firstName("John")
                .lastName("Doe")
                .cpf("460.771.400-31")
                .phones(Set.of(mockPhone))
                .build();

        Mockito.when(personRepository.save(Mockito.any(Person.class))).thenReturn(mockPerson);

        Assertions.assertEquals(mockPersonDTO, personService.create(mockPersonDTO));
    }
}
