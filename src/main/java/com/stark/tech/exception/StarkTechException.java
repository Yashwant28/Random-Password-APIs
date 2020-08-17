package com.stark.tech.exception;

import com.stark.tech.model.ExceptionModel;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class StarkTechException extends RuntimeException {

    private ExceptionModel exceptionModel;

    public StarkTechException(ExceptionModel exceptionModel) {
        this.exceptionModel = exceptionModel;
    }

    public ExceptionModel getExceptionModel() {
        return exceptionModel;
    }

}
