package com.stark.tech.service;

import com.stark.tech.dao.RandomPasswordGeneratorRepository;
import com.stark.tech.model.Password;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class RandomPasswordGeneratorService {

    @Inject
    private RandomPasswordGeneratorRepository randomPasswordGeneratorRepository;

    public Password generateRandomPassword(Integer passwordLength, String passwordType) {
        return randomPasswordGeneratorRepository.generateRandomPassword(passwordLength, passwordType);
    }
}
