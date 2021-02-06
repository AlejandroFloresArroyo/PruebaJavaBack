package com.alejandroflores.demo.services;

import com.alejandroflores.demo.domain.Gender;

public interface GenderService {
    Gender getGenderById(Long id);
    Boolean isGender(Long id);

}
