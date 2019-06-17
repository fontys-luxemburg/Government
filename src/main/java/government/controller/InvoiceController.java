package government.controller;

import government.annotation.Secured;
import government.facade.InvoiceFacade;
import government.model.Invoice;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/invoices")
@Produces("application/json")
@Secured
public class InvoiceController {
    @Inject
    InvoiceFacade invoiceFacade;

    @GET
    @Path("/invoices/{registration_id}")
    public Response getInvoiceByRegistrationId(@PathParam("registration_id") String registrationId,Long from,Long till){
        Optional<Invoice> invoice = invoiceFacade.findByRegistrationId(registrationId,from,till);
        if(invoice.isPresent()){
            return Response.
        }
    }

}
