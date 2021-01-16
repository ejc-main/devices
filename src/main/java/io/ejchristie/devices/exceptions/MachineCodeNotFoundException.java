package io.ejchristie.devices.exceptions;

public class MachineCodeNotFoundException extends RuntimeException {

    public MachineCodeNotFoundException() {
    }

    public MachineCodeNotFoundException(String message) {
        super(message);
    }

    public MachineCodeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MachineCodeNotFoundException(Throwable cause) {
        super(cause);
    }

    public MachineCodeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
