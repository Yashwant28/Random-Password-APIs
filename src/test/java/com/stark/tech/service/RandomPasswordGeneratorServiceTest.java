package com.stark.tech.service;

import com.stark.tech.dao.RandomPasswordGeneratorRepository;
import com.stark.tech.model.Password;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RandomPasswordGeneratorServiceTest {

    @Mock
    private RandomPasswordGeneratorRepository randomPasswordGeneratorRepository;

    @InjectMocks
    private RandomPasswordGeneratorService randomPasswordGeneratorService;

    @Test
    public void testGenerateRandomPassword() {
        Password mockPassword = new Password("passwordType", 6);
        mockPassword.setPasswordValue("passwordValue");
        Mockito.when(randomPasswordGeneratorRepository.generateRandomPassword(Mockito.anyInt(), Mockito.anyString())).thenReturn(mockPassword);

        Password actualPassword = randomPasswordGeneratorService.generateRandomPassword(6, "passwordType");
        assertEquals(mockPassword.getPasswordType(), actualPassword.getPasswordType());
        assertEquals(mockPassword.getPasswordValue(), actualPassword.getPasswordValue());
        assertEquals(mockPassword.getPasswordLength(), actualPassword.getPasswordLength());

    }

}