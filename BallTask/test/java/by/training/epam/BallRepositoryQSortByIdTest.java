package by.training.epam;

import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.Test;

import by.training.epam.action.BallAction;
import by.training.epam.action.BallActionImpl;
import by.training.epam.entity.Ball;
import by.training.epam.entity.Point;
import by.training.epam.entity.RoundFigure;
import by.training.epam.exception.FigureAlreadyExistException;
import by.training.epam.repository.BallRepository;
import by.training.epam.repository.BallsIdComparator;

public class BallRepositoryQSortByIdTest {

	@Test
	public void sortBallsByIdTest() throws FigureAlreadyExistException {
		BallRepository rep = BallRepository.getInstance();
		RoundFigure ball1 = new Ball(1, new Point(0, 0, 0));
		RoundFigure ball2 = new Ball(3, new Point(1, 2, 3));
		RoundFigure ball3 = new Ball(9, new Point(-5, 0, 10));
		RoundFigure ball4 = new Ball(7, new Point(-2, 5, 3));
		ball1.setBallId(1);
		ball2.setBallId(2);
		ball3.setBallId(3);
		ball4.setBallId(4);
		rep.addFigure(ball2);
		rep.addFigure(ball1);
		rep.addFigure(ball4);
		rep.addFigure(ball3);
		rep.sortBalls(new BallsIdComparator());

		List<RoundFigure> expectedRep = new LinkedList<>();
		expectedRep.add(ball1);
		expectedRep.add(ball2);
		expectedRep.add(ball3);
		expectedRep.add(ball4);
		
		assert compareFigures(rep.getFigures(), expectedRep);
	}
	
	public boolean compareFigures(List<RoundFigure> list1, List<RoundFigure> list2) {
		for(int i=0; i < 4 ; i ++) {
			if(!list1.get(i).equals(list2.get(i))) {
				return false;
			}
		}
		return true;
	}
}
