package ru.yofik.lab3.model.services.validator;

import ru.yofik.lab3.model.services.validator.AbstractValidator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("yValidator")
public final class YValidator extends AbstractValidator implements Validator {
    private static final int MIN_Y = -4, MAX_Y = 4;


    public YValidator() {
        super("Y validation failed.");
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String yString = value.toString();

        if (yString == null || yString.isEmpty()) {
            throw new ValidatorException(createExceptionMessage("Y must be a integer."));
        }

        int y;

        try {
            y = Integer.parseInt(yString);
        } catch (NumberFormatException e) {
            throw new ValidatorException(createExceptionMessage("Y must be a integer."));
        }

        if (!isInRange(y)) {
            throw new ValidatorException(createExceptionMessage("Y is out of range."));
        }
    }

    private boolean isInRange(int y) {
        return y >= MIN_Y && y <= MAX_Y;
    }
}
