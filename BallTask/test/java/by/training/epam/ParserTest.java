package by.training.epam;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import by.training.epam.action.impl.BallActionImpl;
import by.training.epam.entity.RoundFigure;
import by.training.epam.entity.impl.Ball;
import by.training.epam.entity.impl.Point;
import by.training.epam.parser.impl.ParserImpl;

public class ParserTest {

	@Test
	public void parseBallsTest() {
		List<String> listOfBalls = new ArrayList<>();
		listOfBalls.add("1 2 3 4");
		listOfBalls.add("2 2 3 4");
		listOfBalls.add("5 0 0 0");
		
		List<RoundFigure> expectedList = new ArrayList<>();
		expectedList.add(new Ball(1, new Point(2, 3, 4)));
		expectedList.add(new Ball(2, new Point(2, 3, 4)));
		expectedList.add(new Ball(5, new Point(0, 0, 0)));
		
		ParserImpl p = new ParserImpl();
		List<RoundFigure> resultedList = p.parseBalls(listOfBalls);
		assert (new BallActionImpl()).compare(resultedList, expectedList);
	}
}
