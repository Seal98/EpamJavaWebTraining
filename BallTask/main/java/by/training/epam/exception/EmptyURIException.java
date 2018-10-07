package by.training.epam.exception;

public class EmptyURIException extends Exception{

	private static final long serialVersionUID = 6961815337106678653L;
	
	private String exceptionMessage;
	
	public EmptyURIException() {
		
	}
	
	public EmptyURIException(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
	@Override
	public String toString() {
		return exceptionMessage;
	}
}
