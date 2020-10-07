package ru.yofik.lab3.model.services.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("xValidator")
public final class XValidator extends AbstractValidator implements Validator {
    private static final double MIN_X = -5, MAX_X = 3;


    public XValidator() {
        super("X validation failed.");
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String xString = value.toString();

        if (xString == null || xString.isEmpty()) {
           throw new ValidatorException(createExceptionMessage("X must be a double."));
        }

        double x;

        try {
            x = Double.parseDouble(xString);
        } catch (NumberFormatException e) {
            throw new ValidatorException(createExceptionMessage("X must be a double."));
        }

        if (!isInRange(x)) {
            throw new ValidatorException(createExceptionMessage("X is out of range."));
        }
    }

    private boolean isInRange(double x) {
        return x >= MIN_X && x <= MAX_X;
    }
}
