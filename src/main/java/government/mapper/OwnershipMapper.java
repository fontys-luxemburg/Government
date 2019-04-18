package government.mapper;

import government.dto.OwnershipDto;
import government.model.Ownership;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "ownership")
public interface OwnershipMapper {

    @Mapping(target = "userID", source = "user.id")
    @Mapping(target = "vehicleID", source = "vehicle.id")
    @Mapping(target = "userName", source = "user.name")
    @Mapping(target = "vehicleRegistrationID", source = "vehicle.registrationID")
    OwnershipDto ownershipToOwnershipDto(Ownership ownership);
    List<OwnershipDto> ownershipsToOwnershipDtos(List<Ownership> ownerships);
}
