package exceptions;

public class InvalidNameException extends ValidationException {
    public InvalidNameException(String message) {
        super(message);
    }
}
