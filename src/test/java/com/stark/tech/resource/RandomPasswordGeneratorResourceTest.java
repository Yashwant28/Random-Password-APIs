package com.stark.tech.resource;

import com.stark.tech.exception.StarkTechException;
import com.stark.tech.model.ExceptionModel;
import com.stark.tech.model.Password;
import com.stark.tech.service.RandomPasswordGeneratorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.misusing.NullInsteadOfMockException;
import org.mockito.junit.MockitoJUnitRunner;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class RandomPasswordGeneratorResourceTest {

    @Mock
    private RandomPasswordGeneratorService randomPasswordGeneratorService;

    @InjectMocks
    private RandomPasswordGeneratorResource randomPasswordGeneratorResource;

    @Test
    public void testGenerateRandomPassword() {
        Password mockPassword = new Password("passwordType", 6);
        mockPassword.setPasswordValue("passwordValue");
        Mockito.when(randomPasswordGeneratorService.generateRandomPassword(Mockito.any(Integer.class), Mockito.anyString())).thenReturn(mockPassword);

        Response actualResponse = randomPasswordGeneratorResource.generateRandomPassword(6, "passwordType");
        Password actualPassword = (Password) actualResponse.getEntity();
        assertEquals(mockPassword.getPasswordType(), actualPassword.getPasswordType());
        assertEquals(mockPassword.getPasswordValue(), actualPassword.getPasswordValue());
        assertEquals(mockPassword.getPasswordLength(), actualPassword.getPasswordLength());
    }

    @Test
    public void testGenerateRandomPasswordWhenStarkTechException() {

        ExceptionModel exceptionModel = new ExceptionModel();
        exceptionModel.setStatus(400);
        exceptionModel.setErrorMessage("ErrorMessage");
        exceptionModel.setError("Error");
        StarkTechException starkTechException = new StarkTechException(exceptionModel);

        Mockito.when(randomPasswordGeneratorService.generateRandomPassword(Mockito.any(Integer.class), Mockito.anyString())).thenThrow(starkTechException);
        Response actualResponse = randomPasswordGeneratorResource.generateRandomPassword(6, "passwordType");
        assertEquals(400, actualResponse.getStatus());
        assertEquals(Response.Status.BAD_REQUEST, actualResponse.getStatusInfo().toEnum());
        ExceptionModel actualExceptionModel = (ExceptionModel) actualResponse.getEntity();
        assertEquals(exceptionModel.getErrorMessage(), actualExceptionModel.getErrorMessage());
        assertEquals(exceptionModel.getError(), actualExceptionModel.getError());
        assertEquals(exceptionModel.getStatus(), actualExceptionModel.getStatus());

    }

    @Test
    public void testGenerateRandomPasswordWhenException() {
        String mockErrorMessage = "Exception occurred";
        Mockito.when(randomPasswordGeneratorService.generateRandomPassword(Mockito.any(Integer.class), Mockito.anyString())).thenThrow(new NullInsteadOfMockException(mockErrorMessage));
        Response actualResponse = randomPasswordGeneratorResource.generateRandomPassword(6, "passwordType");
        assertEquals(500, actualResponse.getStatus());
        assertEquals(Response.Status.INTERNAL_SERVER_ERROR, actualResponse.getStatusInfo().toEnum());
        NullInsteadOfMockException response = (NullInsteadOfMockException) actualResponse.getEntity();
        assertEquals(mockErrorMessage, response.getMessage());

    }

}