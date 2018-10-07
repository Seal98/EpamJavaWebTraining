package by.training.epam.parser.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import by.training.epam.entity.RoundFigure;
import by.training.epam.entity.factory.FiguresFabric;
import by.training.epam.entity.factory.creation.CreateBall;
import by.training.epam.entity.impl.Point;
import by.training.epam.parser.Parser;

public class ParserImpl implements Parser {
	FiguresFabric fabricForFigures;
	@Override
	public List<RoundFigure> parseBalls(List<String> list) {
		List<RoundFigure> listOfBalls = new ArrayList<>();
		fabricForFigures = new CreateBall();
		RoundFigure figure;
		Scanner sc;
		
		for (String ball : list) {
			sc = new Scanner(ball);
			figure = fabricForFigures.createFigure();
			figure.setRadius(Double.parseDouble(sc.next()));
			figure.setPoint(new Point(Double.parseDouble(sc.next()),
					Double.parseDouble(sc.next()), Double.parseDouble(sc.next())));
			listOfBalls.add(figure);
		}
		return listOfBalls;
	}

}
