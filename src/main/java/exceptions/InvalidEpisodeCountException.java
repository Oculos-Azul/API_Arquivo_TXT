package exceptions;

public class InvalidEpisodeCountException extends ValidationException {
    public InvalidEpisodeCountException(String message) {
        super(message);
    }
}
