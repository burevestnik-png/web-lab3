package ru.yofik.lab3.model;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("rValidator")
public final class RValidator extends AbstractValidator implements Validator {
    public RValidator() {
        super("R validation failed.");
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String rString = value.toString();

        if (rString == null || rString.isEmpty()) {
            throw new ValidatorException(createExceptionMessage("R must be a number."));
        }


        int r;

        try {
            r = Integer.parseInt(rString);
        } catch (NumberFormatException ex) {
            throw new ValidatorException(createExceptionMessage("R must be a number."));
        }

        if (!isInRange(r)) {
            throw new ValidatorException(createExceptionMessage("R is out of range."));
        }
    }

    private boolean isInRange(int r) {
        return true;
    }
}
