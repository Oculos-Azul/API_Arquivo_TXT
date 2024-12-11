package exceptions;

public class InvalidReleaseYearException extends ValidationException {
    public InvalidReleaseYearException(String message) {
        super(message);
    }
}
