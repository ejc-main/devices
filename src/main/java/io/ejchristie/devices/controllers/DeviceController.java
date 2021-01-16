package io.ejchristie.devices.controllers;

import io.ejchristie.devices.entities.Device;
import io.ejchristie.devices.entities.ErrorMessage;
import io.ejchristie.devices.exceptions.*;
import io.ejchristie.devices.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    public DeviceController() {
    }

    public void setDeviceService(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public List<Device> getDevices(@RequestParam(required = false) String serialNumber,
                                   @RequestParam(required = false) String machineCode) {
        if (serialNumber == null && machineCode == null) {
            return deviceService.getAll();
        } else if (serialNumber != null && machineCode != null) {
            return deviceService.getDevicesBySerialNumberAndMachineCode(serialNumber, machineCode);
        } else if (serialNumber != null) {
            return deviceService.getDevicesBySerialNumber(serialNumber);
        } else {
            return deviceService.getDevicesByMachineCode(machineCode);
        }
    }

    @PostMapping
    public Device addDevice(@RequestBody Device device) {
        return deviceService.addDevice(device);
    }

    @PutMapping("/{id}")
    public Device updateDevice(@PathVariable long id, @RequestBody Device device) {
        Device d = deviceService.get(id);
        d.setDeviceName(device.getDeviceName());
        d.setMachineCode(device.getMachineCode());
        d.setSerialNumber(device.getSerialNumber());
        return deviceService.updateDevice(d);
    }

    @ExceptionHandler(SerialNumberValidationException.class)
    @ResponseBody
    public ErrorMessage handleSerialNumberValidationException() {
        return ErrorMessage.SERIAL_NUMBER_INVALID;
    }

    @ExceptionHandler(MachineCodeValidationException.class)
    @ResponseBody
    public ErrorMessage handleMachineCodeValidationExeption() {
        return ErrorMessage.MACHINE_CODE_INVALID;
    }

    @ExceptionHandler(SerialNumberNotFoundException.class)
    @ResponseBody
    public ErrorMessage handleSerialNumberNotFoundException() {
        return ErrorMessage.SERIAL_NUMBER_NOT_FOUND;
    }

    @ExceptionHandler(MachineCodeNotFoundException.class)
    @ResponseBody
    public ErrorMessage handleMachineCodeNotFoundException() {
        return ErrorMessage.MACHINE_CODE_NOT_FOUND;
    }

    @ExceptionHandler(SerialNumberAndMachineCodeNotFoundException.class)
    @ResponseBody
    public ErrorMessage handleSerialNumberAndMachineCodeNotFoundException() {
        return ErrorMessage.SERIAL_NUMBER_AND_MACHINE_CODE_NOT_FOUND;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorMessage handleException(Exception exception) {
        exception.printStackTrace();
        return ErrorMessage.UNKNOWN;
    }
}
