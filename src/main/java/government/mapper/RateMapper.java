package government.mapper;

import government.dto.RateDto;
import government.model.Rate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "rate")
public interface RateMapper {
    RateDto rateToRateDto(Rate rate);
    List<RateDto> ratesToRateDtos(List<Rate> rates);

    Rate rateDtoToRate(RateDto rateDto);
}
