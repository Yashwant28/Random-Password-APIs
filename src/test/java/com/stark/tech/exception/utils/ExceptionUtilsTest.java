package com.stark.tech.exception.utils;

import com.stark.tech.model.ExceptionModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ExceptionUtilsTest {

    @InjectMocks
    private ExceptionUtils exceptionUtils;

    @Test
    public void testGetExceptionModel() {
        Integer mockStatus = new Integer("400");
        String mockError = "Bad Request";
        String mockErrorMessage = "Invalid Password Type Passed";
        ExceptionModel actualExceptionModel = exceptionUtils.getExceptionModel(mockError, mockStatus, mockErrorMessage);
        assertEquals(mockError, actualExceptionModel.getError());
        assertEquals(mockStatus, actualExceptionModel.getStatus());
        assertEquals(mockErrorMessage, actualExceptionModel.getErrorMessage());
    }

}