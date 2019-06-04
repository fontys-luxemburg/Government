package government.mapper;

import government.dto.TrackerIdDto;
import government.model.TrackerId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "trackerId")
public interface TrackerIdMapper {

    @Mapping(target = "vehicleID", source = "vehicle.id")
    TrackerIdDto trackerIdToTrackerIdDto(TrackerId trackerId);
    List<TrackerIdDto>trackerIdsToTrackerIdDtos(List<TrackerId> trackerIds);

    @Mapping(target = "vehicle.id", source = "vehicleID")
    TrackerId trackerIdDtoToTrackerId(TrackerIdDto trackerIdDto);
}
