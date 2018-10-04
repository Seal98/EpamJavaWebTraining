package by.training.epam.parser.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import by.training.epam.entity.Ball;
import by.training.epam.entity.Point;
import by.training.epam.parser.Parser;

public class ParserImpl implements Parser {

	@Override
	public List<Ball> parseBalls(List<String> list) {
		List<Ball> listOfBalls = new ArrayList<>();
		Scanner sc;
		for (String ball : list) {
			sc = new Scanner(ball);
			listOfBalls.add(new Ball(Double.parseDouble(sc.next()), new Point(Double.parseDouble(sc.next()),
					Double.parseDouble(sc.next()), Double.parseDouble(sc.next()))));
		}
		return listOfBalls;
	}

}
