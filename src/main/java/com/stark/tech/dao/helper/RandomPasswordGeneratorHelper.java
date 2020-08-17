package com.stark.tech.dao.helper;

import com.stark.tech.model.Password;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Random;

@Named
@Singleton
public class RandomPasswordGeneratorHelper {

    public Password generateNumericPassword(Integer passwordLength, String passwordType) {
        Password password = new Password(passwordType, passwordLength);
        int baseLimit = 48; // letter '0'
        int topLimit = 57; // letter '9'
        Random random = new Random();

        String passwordValue = random.ints(baseLimit, topLimit + 1)
                .limit(passwordLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println("password is: " + passwordValue);
        password.setPasswordValue(passwordValue);
        return password;
    }

    public Password generateAlphabetPassword(Integer passwordLength, String passwordType) {
        Password password = new Password(passwordType, passwordLength);
        int baseLimit = 65; // letter 'a'
        int topLimit = 122; // letter 'z'
        Random random = new Random();

        String passwordValue = random.ints(baseLimit, topLimit + 1)
                .filter(i -> (i <= 90 || i >= 97))
                .limit(passwordLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println("password is: " + passwordValue);
        password.setPasswordValue(passwordValue);
        return password;
    }

    public Password generateAlphaNumericPassword(Integer passwordLength, String passwordType) {
        Password password = new Password(passwordType, passwordLength);
        int baseLimit = 48; // numeral '0'
        int topLimit = 122; // letter 'z'
        Random random = new Random();

        String passwordValue = random.ints(baseLimit, topLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(passwordLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println("password is: " + passwordValue);
        password.setPasswordValue(passwordValue);
        return password;
    }

    public Password generateRandomPassword(Integer passwordLength) {
        Password password = new Password(null, passwordLength);
        int baseLimit = 33; // symbol '!'
        int topLimit = 122; // letter 'z'
        Random random = new Random();

        String passwordValue = random.ints(baseLimit, topLimit + 1)
                .limit(passwordLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println("password is: " + passwordValue);
        password.setPasswordValue(passwordValue);
        return password;
    }
}
