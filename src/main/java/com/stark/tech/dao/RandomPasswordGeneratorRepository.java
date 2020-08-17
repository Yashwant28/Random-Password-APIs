package com.stark.tech.dao;

import com.stark.tech.dao.helper.RandomPasswordGeneratorHelper;
import com.stark.tech.exception.StarkTechException;
import com.stark.tech.exception.utils.ExceptionUtils;
import com.stark.tech.model.ExceptionModel;
import com.stark.tech.model.Password;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class RandomPasswordGeneratorRepository {

    private RandomPasswordGeneratorHelper randomPasswordGeneratorHelper;
    private ExceptionUtils exceptionUtils;

    @Inject
    public RandomPasswordGeneratorRepository(RandomPasswordGeneratorHelper randomPasswordGeneratorHelper, ExceptionUtils exceptionUtils) {
        this.randomPasswordGeneratorHelper = randomPasswordGeneratorHelper;
        this.exceptionUtils = exceptionUtils;
    }

    public Password generateRandomPassword(Integer passwordLength, String passwordType) {
        Password password;
        if (null == passwordType) {
            return randomPasswordGeneratorHelper.generateRandomPassword(passwordLength);
        }
        switch (passwordType.toLowerCase()) {
            case "numeric":
                password = randomPasswordGeneratorHelper.generateNumericPassword(passwordLength, passwordType);
                break;
            case "alphabet":
                password = randomPasswordGeneratorHelper.generateAlphabetPassword(passwordLength, passwordType);
                break;
            case "alphanumeric":
                password = randomPasswordGeneratorHelper.generateAlphaNumericPassword(passwordLength, passwordType);
                break;
            default:
                ExceptionModel exceptionModel = exceptionUtils.getExceptionModel("Bad Request", 400, "Invalid Password Type Passed");
                throw new StarkTechException(exceptionModel);
        }
        return password;
    }

}
