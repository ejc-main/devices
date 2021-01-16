package io.ejchristie.devices.services;

import io.ejchristie.devices.entities.Device;
import io.ejchristie.devices.exceptions.*;
import io.ejchristie.devices.reposiories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Pattern;

@Component("deviceService")
@Transactional
public class DeviceServiceImpl implements DeviceService {

    private static final String serialNumberRegexp = "^[a-zA-z0-9-]+$";

    @Autowired
    private DeviceRepository deviceRepository;

    public DeviceServiceImpl() {
    }

    public void setDeviceRepository(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public List<Device> getAll() {
        return deviceRepository.findAll();
    }

    @Override
    public Device get(long id) {
        return deviceRepository.getOne(id);
    }

    @Override
    public Device addDevice(Device device) {
        if (isValidMachineCode(device.getMachineCode())
                && isValidSerialNumber(device.getSerialNumber())) {
            return deviceRepository.saveAndFlush(device);
        } else {
            return null;
        }
    }

    @Override
    public Device updateDevice(Device device) {
        if (isValidMachineCode(device.getMachineCode())
                && isValidSerialNumber(device.getSerialNumber())) {
            return deviceRepository.saveAndFlush(device);
        } else {
            return null;
        }
    }

    @Override
    public List<Device> getDevicesBySerialNumber(String serialNumber) {
        List<Device> result = deviceRepository.findBySerialNumber(serialNumber);
        if (result.size() > 0) {
            return result;
        } else {
            throw new SerialNumberNotFoundException(serialNumber);
        }
    }

    @Override
    public List<Device> getDevicesByMachineCode(String machineCode) {
        List<Device> result = deviceRepository.findByMachineCode(machineCode);
        if (result.size() > 0) {
            return result;
        } else {
            throw new MachineCodeNotFoundException(machineCode);
        }
    }

    @Override
    public List<Device> getDevicesBySerialNumberAndMachineCode(String serialNumber, String machineCode) {
        List<Device> result = deviceRepository.findBySerialNumberAndMachineCode(serialNumber, machineCode);
        if (result.size() > 0) {
            return result;
        } else {
            throw new SerialNumberAndMachineCodeNotFoundException(serialNumber + " " + machineCode);
        }
    }

    private boolean isValidSerialNumber(String serialNumber) {
        if (Pattern.matches(serialNumberRegexp, serialNumber)) {
            return true;
        } else {
            throw new SerialNumberValidationException(serialNumber);
        }
    }

    private boolean isValidMachineCode(String machineCode) {
        if (!machineCode.isEmpty()) {
            return true;
        } else {
            throw new MachineCodeValidationException(machineCode);
        }
    }

}
