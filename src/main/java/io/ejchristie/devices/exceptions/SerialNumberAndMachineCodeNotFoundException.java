package io.ejchristie.devices.exceptions;

public class SerialNumberAndMachineCodeNotFoundException extends RuntimeException {

    public SerialNumberAndMachineCodeNotFoundException() {
    }

    public SerialNumberAndMachineCodeNotFoundException(String message) {
        super(message);
    }

    public SerialNumberAndMachineCodeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerialNumberAndMachineCodeNotFoundException(Throwable cause) {
        super(cause);
    }

    public SerialNumberAndMachineCodeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
