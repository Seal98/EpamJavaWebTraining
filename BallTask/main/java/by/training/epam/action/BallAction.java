package by.training.epam.action;

import java.util.List;

import by.training.epam.entity.RoundFigure;
import by.training.epam.entity.impl.Ball;

public interface BallAction {
	
	public double ballSurfaceArea(Ball ball);
	
	public double ballDiameter(Ball ball);
	
	public double ballVolume(Ball ball);
	
	public List<RoundFigure> create(String uri);
}
