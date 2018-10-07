package by.training.epam;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
import by.training.epam.validator.Validator;
import by.training.epam.validator.impl.ValidatorImpl;

public class BallValidatorTest {

	@Test
	public void ballValidatorTest() {
		
		List<String> balls = new ArrayList<>();
		Validator val = new ValidatorImpl();
		
		balls.add("1 2 3 4");
		balls.add("0 2 2 2");
		balls.add("5 0 0 1");
		balls.add("-5 0 0 1");
		balls.add("4");
		val.validate(balls);
		
		List<String> expectedListOfBalls = new ArrayList<>();
		expectedListOfBalls.add("1 2 3 4");
		expectedListOfBalls.add("0 2 2 2");
		expectedListOfBalls.add("5 0 0 1");
		assert (new ValidatorImpl()).compare(balls, expectedListOfBalls);	
		
	}
}
