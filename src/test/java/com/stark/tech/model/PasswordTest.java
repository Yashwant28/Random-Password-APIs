package com.stark.tech.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PasswordTest {

    @Test
    public void testPassword() {
        Password actualPassword = new Password("passwordType", 6);
        actualPassword.setPasswordValue("passwordValue");

        assertEquals("passwordType", actualPassword.getPasswordType());
        assertEquals("passwordValue", actualPassword.getPasswordValue());
        assertEquals(new Integer("6"), actualPassword.getPasswordLength());
    }
}