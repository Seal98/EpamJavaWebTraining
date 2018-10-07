package by.training.epam;

import org.testng.annotations.Test;

import by.training.epam.action.BallAction;
import by.training.epam.action.impl.BallActionImpl;
import by.training.epam.entity.impl.Ball;
import by.training.epam.entity.impl.Point;

public class BallVolumeTest {

	@Test
	public void ballVolumeTest() {
		Ball ball = new Ball(5, new Point(0, 0, 0));
		BallAction bai = new BallActionImpl();
		double expectedValue = Math.PI * 4 / 3 * 125;
		assert bai.ballVolume(ball) == expectedValue;
	}
}
