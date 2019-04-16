package mapper;

import dto.TrackerIdDto;
import model.TrackerId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "trackerId")
public interface TrackerIdMapper {

    @Mapping(target = "vehicleId", source = "vehicle.id")
    List<TrackerIdDto>trackerIdsToTrackerIdDtos(List<TrackerId> trackerIds);
    TrackerIdDto trackerIdToTrackerIdDto(TrackerId trackerId);

    @Mapping(target = "vehicle.id", source = "vehicleId")
    TrackerId trackerIdDtoToTrackerId(TrackerIdDto trackerIdDto);
}
