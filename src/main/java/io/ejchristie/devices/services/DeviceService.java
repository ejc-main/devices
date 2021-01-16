package io.ejchristie.devices.services;

import io.ejchristie.devices.entities.Device;

import java.util.List;

public interface DeviceService {

    List<Device> getAll();

    Device get(long id);

    Device addDevice(Device device);

    Device updateDevice(Device device);

    List<Device> getDevicesBySerialNumber(String serialNumber);

    List<Device> getDevicesByMachineCode(String machineCode);

    List<Device> getDevicesBySerialNumberAndMachineCode(String serialNumber, String machineCode);
}
