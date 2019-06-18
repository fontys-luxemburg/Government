package government.controller;

import government.dto.RateDto;
import government.dto.RushRateDto;
import government.facade.RateFacade;
import government.mapper.RushRateMapper;
import government.model.Rate;
import government.model.RushRate;
import government.repository.RateRepository;
import government.repository.RushRateRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

@Path("/rates")
@Consumes("application/json")
@Produces("application/json")
public class RatesController {

    @Inject
    RateFacade rateFacade;

    @Inject
    RateRepository rateRepository;

    @Inject
    RushRateMapper rushRateMapper;

    @Inject
    RushRateRepository rushRateRepository;

    @GET
    public Response getRate(@QueryParam("date") String date) {
        if (date != null) {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return Response.ok(rateFacade.getRateForDate(formatter.parse(date))).build();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return Response.ok(rateFacade.getAll()).build();
    }

    @POST
    public Response createRate(Rate rate) {
        rateFacade.save(rate);
        return Response.status(Response.Status.CREATED).build();
    }

    @POST
    @Path("{rate_id}/rush_rates")
    @Transactional
    public Response createRushRate(@PathParam("rate_id") Long id, RushRate rushRate) {
        Optional<Rate> optionalRate = rateRepository.findById(id);

        if (!optionalRate.isPresent()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        Rate rate = optionalRate.get();

        rushRate.setRate(rate);

        rushRateRepository.save(rushRate);
        return Response.status(Response.Status.CREATED).build();
    }
}
