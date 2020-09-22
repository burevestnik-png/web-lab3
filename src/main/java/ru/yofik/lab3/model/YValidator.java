package ru.yofik.lab3.model;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("yValidator")
public final class YValidator extends AbstractValidator implements Validator {
    public YValidator() {
        super("Y validation failed.");
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String yString = value.toString();

        if (yString == null || yString.isEmpty()) {
            throw new ValidatorException(createExceptionMessage("Y must be a number."));
        }

        double y;

        try {
            y = Double.parseDouble(yString);
        } catch (NumberFormatException e) {
            throw new ValidatorException(createExceptionMessage("Y must be a number."));
        }

        if (!isInRange(y)) {
            throw new ValidatorException(createExceptionMessage("Y is out of range."));
        }
    }

    private boolean isInRange(double y) {
        return true;
    }
}
