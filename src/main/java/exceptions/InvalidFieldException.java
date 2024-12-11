package exceptions;

public class InvalidFieldException extends ValidationException {
    public InvalidFieldException(String message) {
        super(message);
    }
}