package com.stark.tech.dao;

import com.stark.tech.dao.helper.RandomPasswordGeneratorHelper;
import com.stark.tech.exception.StarkTechException;
import com.stark.tech.exception.utils.ExceptionUtils;
import com.stark.tech.model.ExceptionModel;
import com.stark.tech.model.Password;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@RunWith(MockitoJUnitRunner.class)
public class RandomPasswordGeneratorRepositoryTest {

    @Mock
    private RandomPasswordGeneratorHelper randomPasswordGeneratorHelper;

    @Mock
    private ExceptionUtils exceptionUtils;

    @InjectMocks
    private RandomPasswordGeneratorRepository randomPasswordGeneratorRepository;

    @Test
    public void testGenerateRandomPasswordWhenPasswordTypeIsNull() {
        Password mockPassword = new Password("passwordType", 6);
        mockPassword.setPasswordValue("passwordValue");
        Mockito.when(randomPasswordGeneratorHelper.generateRandomPassword(Mockito.anyInt())).thenReturn(mockPassword);

        Password actualPassword = randomPasswordGeneratorRepository.generateRandomPassword(6, null);
        assertEquals(mockPassword.getPasswordType(), actualPassword.getPasswordType());
        assertEquals(mockPassword.getPasswordValue(), actualPassword.getPasswordValue());
        assertEquals(mockPassword.getPasswordLength(), actualPassword.getPasswordLength());
    }

    @Test
    public void testGenerateRandomPasswordWhenPasswordTypeIsNumeric() {
        Password mockPassword = new Password("passwordType", 6);
        mockPassword.setPasswordValue("passwordValue");
        Mockito.when(randomPasswordGeneratorHelper.generateNumericPassword(Mockito.anyInt(), Mockito.anyString())).thenReturn(mockPassword);

        Password actualPassword = randomPasswordGeneratorRepository.generateRandomPassword(6, "numeric");
        assertEquals(mockPassword.getPasswordType(), actualPassword.getPasswordType());
        assertEquals(mockPassword.getPasswordValue(), actualPassword.getPasswordValue());
        assertEquals(mockPassword.getPasswordLength(), actualPassword.getPasswordLength());
    }

    @Test
    public void testGenerateRandomPasswordWhenPasswordTypeIsAlphabet() {
        Password mockPassword = new Password("passwordType", 6);
        mockPassword.setPasswordValue("passwordValue");
        Mockito.when(randomPasswordGeneratorHelper.generateAlphabetPassword(Mockito.anyInt(), Mockito.anyString())).thenReturn(mockPassword);

        Password actualPassword = randomPasswordGeneratorRepository.generateRandomPassword(6, "alphabet");
        assertEquals(mockPassword.getPasswordType(), actualPassword.getPasswordType());
        assertEquals(mockPassword.getPasswordValue(), actualPassword.getPasswordValue());
        assertEquals(mockPassword.getPasswordLength(), actualPassword.getPasswordLength());
    }

    @Test
    public void testGenerateRandomPasswordWhenPasswordTypeIsAlphanumeric() {
        Password mockPassword = new Password("passwordType", 6);
        mockPassword.setPasswordValue("passwordValue");
        Mockito.when(randomPasswordGeneratorHelper.generateAlphaNumericPassword(Mockito.anyInt(), Mockito.anyString())).thenReturn(mockPassword);

        Password actualPassword = randomPasswordGeneratorRepository.generateRandomPassword(6, "alphanumeric");
        assertEquals(mockPassword.getPasswordType(), actualPassword.getPasswordType());
        assertEquals(mockPassword.getPasswordValue(), actualPassword.getPasswordValue());
        assertEquals(mockPassword.getPasswordLength(), actualPassword.getPasswordLength());
    }

    @Test
    public void testGenerateRandomPasswordWhenPasswordTypeIsNotApplicable() {
        Integer mockStatus = new Integer("400");
        String mockError = "Bad Request";
        String mockErrorMessage = "Invalid Password Type Passed";
        ExceptionModel mockExceptionModel = new ExceptionModel();
        mockExceptionModel.setError(mockError);
        mockExceptionModel.setErrorMessage(mockErrorMessage);
        mockExceptionModel.setStatus(mockStatus);
        Mockito.when(exceptionUtils.getExceptionModel(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString())).thenReturn(mockExceptionModel);
        try {
            Password actualPassword = randomPasswordGeneratorRepository.generateRandomPassword(6, "testType");
            fail("should throw exception but did not");
        } catch (StarkTechException starkTechException) {
            ExceptionModel actualExceptionModel = starkTechException.getExceptionModel();
            assertEquals(mockError, actualExceptionModel.getError());
            assertEquals(mockStatus, actualExceptionModel.getStatus());
            assertEquals(mockErrorMessage, actualExceptionModel.getErrorMessage());
        }

    }
}