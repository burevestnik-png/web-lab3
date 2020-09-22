package ru.yofik.lab3.model;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

public class AbstractValidator {
    private final String errorSummary;


    public AbstractValidator(String errorSummary) {
        this.errorSummary = errorSummary;
    }


    protected FacesMessage createExceptionMessage(String detail) {
        FacesMessage msg = new FacesMessage("X validation failed.", detail);
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);

        return msg;
    }
}
