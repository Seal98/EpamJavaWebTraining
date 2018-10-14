package by.training.epam.entity.factory;

import by.training.epam.entity.Ball;
import by.training.epam.entity.RoundFigure;

public class CreateBall extends FiguresFabric {

	public RoundFigure createFigure() {
		return new Ball();
	}

	private CreateBall() {
	}

	private static class SingletonHolder {
		public static final FiguresFabric instance = new CreateBall();
	}

	public static FiguresFabric getInstance() {
		return SingletonHolder.instance;
	}

}
