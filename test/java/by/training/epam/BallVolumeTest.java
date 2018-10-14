package by.training.epam;

import org.testng.annotations.Test;

import by.training.epam.action.BallAction;
import by.training.epam.action.BallActionImpl;
import by.training.epam.entity.Ball;
import by.training.epam.entity.Point;

public class BallVolumeTest {

	@Test
	public void ballVolumeTest() {
		Ball ball = new Ball(5, new Point(0, 0, 0));
		BallAction bai = new BallActionImpl();
		double k = 4.0/3;
		double expectedValue = Math.PI * 125 * k;
		assert bai.ballVolume(ball) == expectedValue;
	}
}
