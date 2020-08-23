package com.stark.tech.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Password {

    private String passwordType;
    private String passwordValue;
    private Integer passwordLength;

    public Password(String passwordType, Integer passwordLength) {
        this.passwordType = passwordType;
        this.passwordLength = passwordLength;
    }

    public Integer getPasswordLength() {
        return passwordLength;
    }

    public String getPasswordValue() {
        return passwordValue;
    }

    public void setPasswordValue(String passwordValue) {
        this.passwordValue = passwordValue;
    }

    public String getPasswordType() {
        return passwordType;
    }

}
