package by.training.epam.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import by.training.epam.entity.Point;
import by.training.epam.entity.RoundFigure;
import by.training.epam.entity.factory.CreateBall;
import by.training.epam.entity.factory.FiguresFabric;

public class BallParserImpl implements RoundFigureParser {

	private FiguresFabric fabricForFigures;
	private static final String parserRegExSpace = " ";

	@Override
	public List<RoundFigure> parseBalls(List<String> list) {
		List<RoundFigure> listOfBalls = new ArrayList<>();
		fabricForFigures = CreateBall.getInstance();
		RoundFigure figure;

		for (String ball : list) {
			String[] ballParameters = ball.split(parserRegExSpace);
			figure = fabricForFigures.createFigure();
			figure.setRadius(Double.parseDouble(ballParameters[0]));
			figure.setPoint(new Point(Double.parseDouble(ballParameters[1]), Double.parseDouble(ballParameters[2]),
					Double.parseDouble(ballParameters[3])));
			listOfBalls.add(figure);
		}

		return listOfBalls;
	}

}
