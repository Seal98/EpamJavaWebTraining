package by.training.epam.parser;

import java.util.List;

import by.training.epam.entity.Ball;

public interface Parser {
	public List<Ball> parseBalls(List<String> list);
}
