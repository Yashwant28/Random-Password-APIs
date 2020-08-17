package com.stark.tech.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class ExceptionModel {

    private String errorMessage;
    private Integer status;
    private String error;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
