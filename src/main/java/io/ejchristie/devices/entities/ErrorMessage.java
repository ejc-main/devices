package io.ejchristie.devices.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorMessage {
    MACHINE_CODE_INVALID ("machine.code.invalid",
            "ER001",
            "The machine code is incorrect. Check the Machine code you provided and try again."),
    MACHINE_CODE_NOT_FOUND ("machine.code.not.found",
            "ER002",
            "The machine code does not match our records."),
    SERIAL_NUMBER_INVALID ("serial.number.invalid",
            "ER003",
            "The serial number entered can include a - z, A - Z, 0 - 9 and hyphen. Please correct your entry."),
    SERIAL_NUMBER_NOT_FOUND ("serial.number.not.found",
            "ER004",
            "The serial number does not match our records."),
    SERIAL_NUMBER_AND_MACHINE_CODE_NOT_FOUND ("serial.number.and.machine.code.not.found",
            "ER005",
            "The serial number and machine code do not match our records."),
    UNKNOWN ("unknown.error",
            "ER006",
            "An unknown error has occurred.");

    private final String resourceKey;
    private final String errorCode;
    private final String message;

    ErrorMessage(String resourceKey, String errorCode, String message) {
        this.resourceKey = resourceKey;
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getResourceKey() {
        return resourceKey;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
