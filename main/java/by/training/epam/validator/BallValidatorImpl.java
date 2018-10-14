package by.training.epam.validator;

import java.util.Iterator;
import java.util.List;

public class BallValidatorImpl implements RoundFigureValidator {

	public static final String REGEX_BALL = "[\\+]?[0-9]+(\\.[0-9]+)?( [\\- | \\+]?[0-9]+(\\.[0-9]+)?){3}";

	public BallValidatorImpl() {
	}

	@Override
	public void validateBalls(List<String> balls) {
		Iterator<String> it = balls.iterator();
		while (it.hasNext()) {
			if (!isValidBall(it.next())) {
				it.remove();
			}
		}
	}

	@Override
	public boolean isValidBall(String ball) {
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
