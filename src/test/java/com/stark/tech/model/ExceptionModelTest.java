package com.stark.tech.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class ExceptionModelTest {

    @Test
    public void testExceptionModel() {
        Integer mockStatus = new Integer("400");
        String mockError = "Bad Request";
        String mockErrorMessage = "Invalid Password Type Passed";
        ExceptionModel exceptionModel = new ExceptionModel();
        exceptionModel.setError(mockError);
        exceptionModel.setErrorMessage(mockErrorMessage);
        exceptionModel.setStatus(mockStatus);

        assertEquals(mockError, exceptionModel.getError());
        assertEquals(mockStatus, exceptionModel.getStatus());
        assertEquals(mockErrorMessage, exceptionModel.getErrorMessage());
    }
}