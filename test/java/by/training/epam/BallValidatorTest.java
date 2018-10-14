package by.training.epam;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;

import by.training.epam.validator.BallValidatorImpl;
import by.training.epam.validator.RoundFigureValidator;

public class BallValidatorTest {

	@Test
	public void ballValidatorTest() {
		
		List<String> balls = new ArrayList<>();
		RoundFigureValidator val = new BallValidatorImpl();
		
		balls.add("1 2 3 4");
		balls.add("0 2 2 2");
		balls.add("5 0 0 1");
		balls.add("-5 0 0 1");
		balls.add("4");
		val.validateBalls(balls);
		
		List<String> expectedListOfBalls = new ArrayList<>();
		expectedListOfBalls.add("1 2 3 4");
		expectedListOfBalls.add("0 2 2 2");
		expectedListOfBalls.add("5 0 0 1");
		assert (new BallValidatorImpl()).compare(balls, expectedListOfBalls);	
		
	}
}
