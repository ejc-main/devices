package io.ejchristie.devices.exceptions;

public class SerialNumberNotFoundException extends RuntimeException {

    public SerialNumberNotFoundException() {
    }

    public SerialNumberNotFoundException(String message) {
        super(message);
    }

    public SerialNumberNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerialNumberNotFoundException(Throwable cause) {
        super(cause);
    }

    public SerialNumberNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
