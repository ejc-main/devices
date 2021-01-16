package io.ejchristie.devices.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Device implements Serializable {

    private static final long serialVersionUID = -8165384680317463511L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEVICE_ID_SEQUENCE")
    @SequenceGenerator(name = "DEVICE_ID_SEQUENCE", sequenceName = "DEVICE_ID_SEQUENCE")
    private long id;

    private String serialNumber;

    private String machineCode;

    private String deviceName;

    public Device() {
    }

    public Device(long id, String serialNumber, String machineCode, String deviceName) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.machineCode = machineCode;
        this.deviceName = deviceName;
    }

    public long getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", machineCode='" + machineCode + '\'' +
                ", deviceName='" + deviceName + '\'' +
                '}';
    }
}
