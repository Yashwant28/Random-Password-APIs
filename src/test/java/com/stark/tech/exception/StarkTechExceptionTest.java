package com.stark.tech.exception;

import com.stark.tech.model.ExceptionModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class StarkTechExceptionTest {

    @Test
    public void testStarkTechException() {
        Integer mockStatus = new Integer("400");
        String mockError = "Bad Request";
        String mockErrorMessage = "Invalid Password Type Passed";
        ExceptionModel mockExceptionModel = new ExceptionModel();
        mockExceptionModel.setError(mockError);
        mockExceptionModel.setErrorMessage(mockErrorMessage);
        mockExceptionModel.setStatus(mockStatus);

        StarkTechException actualStarkTechException = new StarkTechException(mockExceptionModel);
        ExceptionModel actualExceptionModel = actualStarkTechException.getExceptionModel();
        assertEquals(mockError, actualExceptionModel.getError());
        assertEquals(mockStatus, actualExceptionModel.getStatus());
        assertEquals(mockErrorMessage, actualExceptionModel.getErrorMessage());

    }
}