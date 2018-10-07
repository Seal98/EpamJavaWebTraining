package by.training.epam.parser;

import java.util.List;

import by.training.epam.entity.RoundFigure;

public interface Parser {
	
	public List<RoundFigure> parseBalls(List<String> list);
	
}
