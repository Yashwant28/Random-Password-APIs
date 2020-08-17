package com.stark.tech.exception.utils;

import com.stark.tech.model.ExceptionModel;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class ExceptionUtils {

    public ExceptionModel getExceptionModel(String error, Integer status, String errorMessage) {
        ExceptionModel exceptionModel = new ExceptionModel();
        exceptionModel.setError(error);
        exceptionModel.setErrorMessage(errorMessage);
        exceptionModel.setStatus(status);
        return exceptionModel;
    }

}
