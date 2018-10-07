package by.training.epam.validator.impl;

import java.util.Iterator;
import java.util.List;

import by.training.epam.validator.Validator;

public class ValidatorImpl implements Validator {

	public static final String REGEX_BALL = "[\\+]?[0-9]+(\\.[0-9]+)?( [\\- | \\+]?[0-9]+(\\.[0-9]+)?){3}";

	public ValidatorImpl() {
	}

	@Override
	public void validate(List<String> balls) {
		Iterator<String> it = balls.iterator();
		while (it.hasNext()) {
			if (!isValid(it.next())) {
				it.remove();
			}
		}
	}

	@Override
	public boolean isValid(String ball) {
		return ball.matches(REGEX_BALL);
	}

	public boolean compare(List<String> list1, List<String> list2) {
		if (list1.size() != list2.size()) {
			return false;
		}
		for (int i = 0; i < list1.size(); i++) {
			if (!list1.get(i).equals(list2.get(i))) {
				return false;
			}
		}
		return true;
	}

}
