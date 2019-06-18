package government.mapper;

import government.dto.RushRateDto;
import government.model.RushRate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "rushRate")
public interface RushRateMapper {
    @Mapping(target = "rateID", source = "rate.id")
    RushRateDto rushRateToRushRateDto(RushRate rushRate);
    List<RushRateDto> rushRatesToRushRateDtos(List<RushRate> rushRates);

    @Mapping(target = "rate.id", source = "rateID")
    RushRate rushRateDtoToRushRate(RushRateDto rushRateDto);
}
