package by.training.epam;

import org.testng.annotations.Test;

import by.training.epam.action.BallAction;
import by.training.epam.action.impl.BallActionImpl;
import by.training.epam.entity.impl.Ball;
import by.training.epam.entity.impl.Point;

public class BallSurfaceAreaTest {

	@Test
	public void ballSurfaceTest() {
		Ball ball = new Ball(5, new Point(0, 0, 0));
		BallAction bai = new BallActionImpl();
		double expectedValue = 4 * Math.PI * 25;
		assert bai.ballSurfaceArea(ball) == expectedValue;
	}
}
