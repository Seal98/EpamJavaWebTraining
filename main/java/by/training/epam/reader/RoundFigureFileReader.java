package by.training.epam.reader;

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
import by.training.epam.exception.EmptyURIException;
import by.training.epam.exception.ReadingFromFileException;
import by.training.epam.parser.BallParserImpl;
import by.training.epam.validator.BallValidatorImpl;
import by.training.epam.validator.RoundFigureValidator;

public class RoundFigureFileReader implements RoundFigureReader {

	private static final String fileName = "src\\main\\resources\\input.txt";
	private static final String emptyString = "";

	private List<String> dataFromFile;
	private static final Logger logger = LogManager.getLogger(RoundFigureFileReader.class);

	public RoundFigureFileReader() {
		dataFromFile = new ArrayList<>();
	}

	public List<String> getListCopy(List<String> list) {
		List<String> newList = new ArrayList<>();
		newList.addAll(list);
		return newList;
	}

	@Override
	public void readFigure() throws IOException, ReadingFromFileException {
		try {
			Stream<String> stream = Files.lines(Paths.get(fileName));
			dataFromFile = Arrays.asList(stream.toArray(size -> new String[size]));
		} catch (IOException e) {
			throw new ReadingFromFileException("Exception while reading figure from file: " + e);
		}
	}

	@Override
	public void readFigure(String uri) throws EmptyURIException, IOException, ReadingFromFileException {
		if (uri.equals(emptyString)) {
			throw new ReadingFromFileException("URI is empty (" + this.getClass()+")", new EmptyURIException());
		}
		try (Stream<String> stream = Files.lines(Paths.get(uri))) {
			dataFromFile = Arrays.asList(stream.toArray(size -> new String[size]));
		} catch (IOException e) {
			throw new ReadingFromFileException("Exception while reading figure from file: " + e);
		}
	}

	@Override
	public List<RoundFigure> getBalls() {
		RoundFigureValidator validator = new BallValidatorImpl();
		List<String> validDataFromFile = getListCopy(dataFromFile);
		validator.validateBalls(validDataFromFile);
		List<RoundFigure> listOfBalls = (new BallParserImpl()).parseBalls(getListCopy(validDataFromFile));
		return listOfBalls;
	}
}
