package government.mapper;

import government.dto.TripDto;
import government.model.Trip;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "trip")
public interface TripMapper {

    @Mapping(target = "trackerId", source = "tracker.id")
    TripDto tripToTripDto(Trip trip);
    List<TripDto> tripsToTripDtos(List<Trip> trips);

    @Mapping(target = "tracker.id", source = "trackerId")
    Trip tripDtoToTrip(TripDto tripDto);
}
