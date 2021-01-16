package io.ejchristie.devices.exceptions;

public class SerialNumberValidationException extends RuntimeException {

    public SerialNumberValidationException() {
    }

    public SerialNumberValidationException(String message) {
        super(message);
    }

    public SerialNumberValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerialNumberValidationException(Throwable cause) {
        super(cause);
    }

    public SerialNumberValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
