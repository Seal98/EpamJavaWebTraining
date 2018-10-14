package by.training.epam.exception;

public class FigureAlreadyExistException extends Exception{

	private static final long serialVersionUID = -6318957360131592826L;

	public FigureAlreadyExistException() {
	}
	
	public FigureAlreadyExistException(String message) {
		super(message);
	}
	
}
