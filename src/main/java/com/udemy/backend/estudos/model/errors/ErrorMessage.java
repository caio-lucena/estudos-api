package com.udemy.backend.estudos.model.errors;

public class ErrorMessage {

    private String errorTitle;
    private Integer statusCode;
    private String errorMessage;

    public ErrorMessage(String errorTitleInit, Integer statusCodeInit, String errorMessageInit) {
        errorTitle = errorTitleInit;
        statusCode = statusCodeInit;
        errorMessage = errorMessageInit;
    }

    public String getErrorTitle() {
        return errorTitle;
    }

    public void setErrorTitle(String errorTitle) {
        this.errorTitle = errorTitle;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
