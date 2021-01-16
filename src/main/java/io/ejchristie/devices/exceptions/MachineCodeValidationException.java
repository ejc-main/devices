package io.ejchristie.devices.exceptions;

public class MachineCodeValidationException extends RuntimeException {

    public MachineCodeValidationException() {
    }

    public MachineCodeValidationException(String message) {
        super(message);
    }

    public MachineCodeValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public MachineCodeValidationException(Throwable cause) {
        super(cause);
    }

    public MachineCodeValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
