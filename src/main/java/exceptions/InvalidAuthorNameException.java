package exceptions;

public class InvalidAuthorNameException extends ValidationException {
    public InvalidAuthorNameException(String message) {
        super(message);
    }
}
