package by.training.epam.entity.factory.creation;

import by.training.epam.entity.RoundFigure;
import by.training.epam.entity.factory.FiguresFabric;
import by.training.epam.entity.impl.Ball;

public class CreateBall extends FiguresFabric{

	public RoundFigure createFigure() {
		return new Ball();
	}

}
