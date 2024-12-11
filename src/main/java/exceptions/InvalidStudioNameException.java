package exceptions;

public class InvalidStudioNameException extends ValidationException {
    public InvalidStudioNameException(String message) {
        super(message);
    }
}
