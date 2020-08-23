package com.stark.tech.dao.helper;

import com.stark.tech.model.Password;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class RandomPasswordGeneratorHelperTest {

    @InjectMocks
    private RandomPasswordGeneratorHelper randomPasswordGeneratorHelper;

    @Test
    public void testGenerateNumericPassword() {
        Password actualPassword = randomPasswordGeneratorHelper.generateNumericPassword(6, "passwordType");
        assertNotNull(actualPassword);
        String password = actualPassword.getPasswordValue();
        assertNotNull(password);
        assertEquals(6, password.length());
        assertTrue(password.matches("[0-9]*"));
    }

    @Test
    public void testGenerateAlphabetPassword() {
        Password actualPassword = randomPasswordGeneratorHelper.generateAlphabetPassword(6, "passwordType");
        assertNotNull(actualPassword);
        String password = actualPassword.getPasswordValue();
        assertNotNull(password);
        assertEquals(6, password.length());
        assertTrue(password.matches("[a-zA-Z]*"));
    }

    @Test
    public void testGenerateAlphaNumericPassword() {
        Password actualPassword = randomPasswordGeneratorHelper.generateAlphaNumericPassword(6, "passwordType");
        assertNotNull(actualPassword);
        String password = actualPassword.getPasswordValue();
        assertNotNull(password);
        assertEquals(6, password.length());
        assertTrue(password.matches("[0-9a-zA-Z]*"));
    }

    @Test
    public void generateRandomPassword() {
        Password actualPassword = randomPasswordGeneratorHelper.generateRandomPassword(6);
        assertNotNull(actualPassword);
        String password = actualPassword.getPasswordValue();
        assertNotNull(password);
        assertEquals(6, password.length());
    }
}