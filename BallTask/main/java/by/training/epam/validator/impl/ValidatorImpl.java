package by.training.epam.validator.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import by.training.epam.validator.Validator;

public class ValidatorImpl implements Validator {

	public static final String REGEX_BALL = "[\\+]?[0-9]+(\\.[0-9]+)?( [\\- | \\+]?[0-9]+(\\.[0-9]+)?){3}";
	public static final ValidatorImpl validator = new ValidatorImpl();
	
	private ValidatorImpl() {}
	
	@Override
	public void validate(List<String> balls) {
		Iterator<String> it = balls.iterator();
		while(it.hasNext()) {
			if (!isValid(it.next())) {
				it.remove();
			}
		}
	}

	@Override
	public boolean isValid(String ball) {
		return ball.matches(REGEX_BALL);
	}

}
