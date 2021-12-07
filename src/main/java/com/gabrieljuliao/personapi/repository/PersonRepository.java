package com.gabrieljuliao.personapi.repository;

import com.gabrieljuliao.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
