package by.training.epam.reader.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.epam.entity.RoundFigure;
import by.training.epam.entity.impl.Ball;
import by.training.epam.exception.EmptyURIException;
import by.training.epam.parser.impl.ParserImpl;
import by.training.epam.reader.Reader;
import by.training.epam.validator.Validator;
import by.training.epam.validator.impl.ValidatorImpl;

public class ReadFromFileImpl implements Reader {

	private static final String fileName = "input.txt";
	private static final Validator validator = new ValidatorImpl();
	private static final String emptyString = "";
	
	private List<String> dataFromFile;
	private List<String> validDataFromFile;
	private static final Logger logger = LogManager.getLogger(ReadFromFileImpl.class);
	
	public ReadFromFileImpl() {
		dataFromFile = new ArrayList<>();
		validDataFromFile = new ArrayList<>();
	}

	@Override
	public void read() {
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			dataFromFile = Arrays.asList(stream.toArray(size -> new String[size]));
		} catch (IOException e) {
			logger.error("Exception while reading from file: " + e.toString());
		}
	}

	public void read(String uri) throws EmptyURIException{
		if(uri.equals(emptyString)) {
			throw new EmptyURIException("URI is empty");
		}
		try (Stream<String> stream = Files.lines(Paths.get(uri))) {
			dataFromFile = Arrays.asList(stream.toArray(size -> new String[size]));
		} catch (IOException e) {
			logger.error("Exception while reading from file: " + e.toString());
		}
	}

	public static List<String> getListCopy(List<String> list) {
		List<String> newList = new ArrayList<>();
		for (String str : list) {
			newList.add(str);
		}
		return newList;
	}

	@Override
	public List<RoundFigure> getBalls() {
		validDataFromFile = getListCopy(dataFromFile);
		validator.validate(validDataFromFile);
		List<RoundFigure> listOfBalls = (new ParserImpl()).parseBalls(getListCopy(validDataFromFile));
		return listOfBalls;
	}
}
