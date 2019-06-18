package government.mapper;

import government.dto.RushRateDto;
import government.model.RushRate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "rushRate")
public interface RushRateMapper {
    RushRateDto rushRateToRushRateDto(RushRate rushRate);
    List<RushRateDto> rushRatesToRushRateDtos(List<RushRate> rushRates);
}
