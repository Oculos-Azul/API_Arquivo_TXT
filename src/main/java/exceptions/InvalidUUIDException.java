package exceptions;

public class InvalidUUIDException extends ValidationException {
    public InvalidUUIDException(String message) {
        super(message);
    }
}