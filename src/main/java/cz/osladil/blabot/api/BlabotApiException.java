package cz.osladil.blabot.api;

/**
 *
 * @author mosladil
 */
public class BlabotApiException extends Exception {

    public BlabotApiException() {
        super();
    }

    public BlabotApiException(String message) {
        super(message);
    }

    public BlabotApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlabotApiException(Throwable cause) {
        super(cause);
    }
}
