package ru.yofik.lab3.model.services.validator;

import javax.faces.application.FacesMessage;

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
