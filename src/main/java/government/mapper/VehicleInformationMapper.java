package government.mapper;


import government.dto.VehicleInformationDto;
import government.model.VehicleInformation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "vehicleInformation")
public interface VehicleInformationMapper  {
    VehicleInformationDto vehicleInformationToDto(VehicleInformation vehicleInformation);
    List<VehicleInformationDto> vehicleInformationToVehicleInformationDto(List<VehicleInformation> vehicleInformationList);

    VehicleInformation vehicleDtoToVehicle(VehicleInformationDto vehicleDto);
}
