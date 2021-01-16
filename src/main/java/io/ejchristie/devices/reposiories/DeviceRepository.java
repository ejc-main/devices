package io.ejchristie.devices.reposiories;

import io.ejchristie.devices.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {

    List<Device> findBySerialNumber(String serialNumber);

    List<Device> findByMachineCode(String machineCode);

    List<Device> findBySerialNumberAndMachineCode(String serialNumber, String machineCode);

}
