package government.mapper;


import government.dto.VehicleDto;
import government.model.Vehicle;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "vehicle")
public interface VehicleMapper {

    VehicleDto vehicleToVehicleDto(Vehicle vehicle);
    List<VehicleDto> vehiclesToVehicleDtos(List<Vehicle> vehicles);

    Vehicle vehicleDtoToVehicle(VehicleDto vehicleDto);
}
