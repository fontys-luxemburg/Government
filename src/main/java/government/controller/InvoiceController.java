package government.controller;

import government.annotation.Secured;
import government.dto.InvoiceDto;
import government.facade.InvoiceFacade;
import government.mapper.InvoiceMapper;
import government.model.Invoice;
import government.model.Trip;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/invoices")
@Produces("application/json")
@Secured
public class InvoiceController {
    @Inject
    InvoiceFacade invoiceFacade;
    @Inject
    InvoiceMapper invoiceMapper;

    @GET
    @Path("/invoices/{registration_id}")
    public Response getInvoiceByRegistrationId(@PathParam("registration_id") String registrationId,@QueryParam("year") int year,
                                               @QueryParam("month") int month){
        Optional<Invoice> invoice = invoiceFacade.findByRegistrationId(registrationId,year,month);
        if(invoice.isPresent()){
            InvoiceDto invoiceDto = invoiceMapper.invoiceToInvoiceDto(invoice.get());
            invoiceDto.setTripDtos(invoiceFacade.TripsInvoiceToTripDto(invoice.get()));
            return Response.ok(invoiceDto).build();
        }else{
           Invoice invoice1 = invoiceFacade.generateInvoiceVehicle(year,month,registrationId);
           if(invoice1 == null){
               return Response.status(404).build();
           }else{
               return Response.ok(invoice1).build();
           }
        }
    }

    @GET
    @Path("/invoices/{user_id}")
public Response getInvoiceByUserId(@PathParam("user_id") Long user_id, @QueryParam("year") int year, @QueryParam("month") int month){
        Optional<Invoice> invoice = invoiceFacade.findByUserID(user_id,year,month);
        if(invoice.isPresent()){
            InvoiceDto invoiceDto = invoiceMapper.invoiceToInvoiceDto(invoice.get());
            invoiceDto.setTripDtos(invoiceFacade.TripsInvoiceToTripDto(invoice.get()));
            return Response.ok(invoiceDto).build();
        }else{
            Invoice invoice1 = invoiceFacade.generateInvoiceFromUser(year,month,user_id);
            if(invoice1 == null){
                return Response.status(404).build();
            }else{
                return Response.ok(invoice1).build();
            }
        }
    }
    @GET
    @Path("/invoices/{user_id}/all")
    public Response getInvoiceAllByUser(@PathParam("user_id") Long user_id){
        List<Invoice> invoices = invoiceFacade.getAllinvoicesFromUser(user_id);
        if(invoices == null || invoices.size()==0){
            return Response.status(404).build();
        }else{
            return Response.ok(invoiceFacade.invoicesToInvoiceDtos(invoices)).build();
        }

    }


}
