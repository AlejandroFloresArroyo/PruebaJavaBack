package com.alejandroflores.demo.repositories;

import com.alejandroflores.demo.domain.Gender;
import org.springframework.data.repository.CrudRepository;

public interface GenderRepository extends CrudRepository<Gender, Long> {
    Gender findGenderById(Long id);
}
