package com.alejandroflores.demo.services;

import com.alejandroflores.demo.domain.Gender;
import com.alejandroflores.demo.repositories.GenderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenderServiceImpl implements GenderService {

    private final GenderRepository genderRepository;

    public GenderServiceImpl(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    @Override
    public Gender getGenderById(Long id) {
        return genderRepository.findGenderById(id);
    }

    @Override
    public Boolean isGender(Long id) {
        Optional<Gender> isGender = genderRepository.findById(id);
        if (isGender.isPresent()) return true;
        return false;
    }
}
