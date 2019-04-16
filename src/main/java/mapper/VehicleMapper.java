package mapper;

import dto.VehicleDto;
import model.Vehicle;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "vehicle")
public interface VehicleMapper {

    VehicleDto vehicleToVehicleDto(Vehicle vehicle);
    List<VehicleDto> vehiclesToVehicleDtos(List<Vehicle> vehicles);

    Vehicle vehicleDtoToVehicle(VehicleDto vehicleDto);
}
