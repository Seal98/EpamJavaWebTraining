package by.training.epam.action;

import by.training.epam.entity.Ball;
import by.training.epam.entity.RoundFigure;

public interface BallAction {

	public double ballSurfaceArea(RoundFigure updatedFigure);

	public double ballDiameter(Ball ball);

	public double ballVolume(RoundFigure ball);
	
}
