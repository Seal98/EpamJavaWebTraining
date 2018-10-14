package by.training.epam;
import org.testng.annotations.Test;

import by.training.epam.entity.Ball;
import by.training.epam.entity.Point;
import by.training.epam.entity.RoundFigure;
import by.training.epam.exception.FigureAlreadyExistException;
import by.training.epam.exception.FigureNotFoundException;
import by.training.epam.repository.BallRepository;

public class BallSearchByIdTest {

	@Test
	public void getFigureByIdTest() throws FigureAlreadyExistException, FigureNotFoundException {
		BallRepository rep = BallRepository.getInstance();
		RoundFigure ball1 = new Ball(1, new Point(0, 0, 0));
		RoundFigure ball2 = new Ball(3, new Point(1, 2, 3));
		RoundFigure ball3 = new Ball(9, new Point(-5, 0, 10));
		RoundFigure ball4 = new Ball(7, new Point(-2, 5, 4));
		ball1.setBallId(1);
		ball2.setBallId(2);
		ball3.setBallId(3);
		ball4.setBallId(4);
		rep.addFigure(ball2);
		rep.addFigure(ball1);
		rep.addFigure(ball4);
		rep.addFigure(ball3);

		RoundFigure expected = new Ball(9, new Point(-5, 0, 10));

		assert rep.getFigureById(3).equals(expected);
	}
}
