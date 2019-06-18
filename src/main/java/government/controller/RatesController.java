package government.controller;

import government.dto.RateDto;
import government.facade.RateFacade;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Path("/rates")
@Consumes("application/json")
@Produces("application/json")
public class RatesController {

    @Inject
    RateFacade rateFacade;

    @GET
    public RateDto getRate(@QueryParam("date") String date) {
        if (date != null) {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return rateFacade.getRateForDate(formatter.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return rateFacade.getCurrentRate();
    }
}
