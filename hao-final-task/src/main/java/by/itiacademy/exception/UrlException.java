package by.itiacademy.exception;

public class UrlException extends Exception {
    public UrlException(String message) {
        super(message);
    }

    public UrlException(String message, Throwable cause) {
        super(message, cause);
    }
}
