package government.mapper;


import government.dto.VehicleInformationDto;
import government.model.VehicleInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "vehicleInformation")
public interface VehicleInformationMapper  {
    @Mapping(target = "vehicle_id", source = "vehicle.id")
    VehicleInformationDto vehicleInformationToDto(VehicleInformation vehicleInformation);
    List<VehicleInformationDto> vehicleInformationToVehicleInformationDtos(List<VehicleInformation> vehicleInformationList);
    @Mapping(target = "vehicle.id", source = "vehicle_id")
    VehicleInformation vehicleInformationDtoToVehicleInformation(VehicleInformationDto vehicleDto);
}
