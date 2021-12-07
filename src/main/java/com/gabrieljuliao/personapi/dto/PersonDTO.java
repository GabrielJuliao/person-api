package com.gabrieljuliao.personapi.dto;

import com.gabrieljuliao.personapi.entity.Phone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String cpf;
    private LocalDate birthDate;
    private Set<Phone> phones = new HashSet<>();
}
