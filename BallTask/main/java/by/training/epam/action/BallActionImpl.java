package by.training.epam.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.epam.entity.Ball;
import by.training.epam.entity.RoundFigure;

public class BallActionImpl implements BallAction {

	private static final Logger logger = LogManager.getLogger(BallActionImpl.class);
	private static final double ballVolumeCoefficient = 4.0 / 3;
	private static final double ballVolumeRadiusPower = 3;
	private static final double ballDiameterCoefficient = 2;
	private static final double ballSurfaceAreaCoefficient = 4;
	private static final double ballSurfaceAreaPower = 2;
	public static final BallAction ballCharacteristic = new BallActionImpl();

	@Override
	public double ballSurfaceArea(RoundFigure ball) {
		return ballSurfaceAreaCoefficient * Math.pow(ball.getRadius(), ballSurfaceAreaPower) * Math.PI;
	}

	@Override
	public double ballDiameter(Ball ball) {
		return ball.getRadius() * ballDiameterCoefficient;
	}

	@Override
	public double ballVolume(RoundFigure ball) {
		return Math.PI * Math.pow(ball.getRadius(), ballVolumeRadiusPower) * ballVolumeCoefficient;
	}

}
