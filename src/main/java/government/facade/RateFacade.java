package government.facade;

import government.dto.RateDto;
import government.mapper.RateMapper;
import government.model.Rate;
import government.repository.RateRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class RateFacade {

    @Inject
    RateRepository rateRepository;

    @Inject
    RateMapper mapper;

    public List<RateDto> getAll() {
        List<Rate> rates = rateRepository.findAll();
        return mapper.ratesToRateDtos(rates);
    }

    public RateDto getCurrentRate() {
        Rate rate = rateRepository.rateForDate(new Date());
        return mapper.rateToRateDto(rate);
    }

    public RateDto getRateForDate(Date date) {
        Rate rate = rateRepository.rateForDate(date);
        return mapper.rateToRateDto(rate);
    }

    @Transactional
    public void save(Rate rate) {
        rateRepository.save(rate);
    }
}
