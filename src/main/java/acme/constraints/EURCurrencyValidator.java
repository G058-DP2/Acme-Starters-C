
package acme.constraints;

import javax.validation.ConstraintValidatorContext;

import acme.client.components.datatypes.Money;
import acme.client.components.validation.AbstractValidator;
import acme.client.components.validation.Validator;

@Validator
public class EURCurrencyValidator extends AbstractValidator<ValidEUR, Money> {

	@Override
	public void initialize(final ValidEUR constraintAnnotation) {
		assert constraintAnnotation != null;
	}

	@Override
	public boolean isValid(final Money money, final ConstraintValidatorContext context) {

		assert context != null;
		if (money == null)
			return true;

		boolean isEur = money.getCurrency() != null && money.getCurrency().trim().equalsIgnoreCase("EUR");

		super.state(context, isEur, "currency", "acme.validation.money.eur.error");

		return !super.hasErrors(context);
	}
}
