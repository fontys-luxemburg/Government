package government.controller;

import government.annotation.Secured;
import government.dto.InvoiceDto;
import government.facade.InvoiceFacade;
import government.facade.UserFacade;
import government.facade.VehicleFacade;
import government.mapper.InvoiceMapper;
import government.model.Invoice;
import government.model.User;
import government.model.Vehicle;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Inject
    UserFacade userFacade;
    @Inject
    VehicleFacade vehicleFacade;

    @GET
    @Path("/vehicle/{registration_id}")
    public Response getInvoiceByRegistrationId(@PathParam("registration_id") String registrationId,@QueryParam("year") int year,
                                               @QueryParam("month") int month){
        Optional<Vehicle> vehicle = vehicleFacade.findByRegistrationID(registrationId);
        if(!vehicle.isPresent()){
            return Response.status(404).build();
        }
        Optional<Invoice> invoice = invoiceFacade.findByRegistrationId(registrationId,year,month);
        if(invoice.isPresent()){
            InvoiceDto invoiceDto = invoiceMapper.invoiceToInvoiceDto(invoice.get());
            invoiceDto.setTripDtos(invoiceFacade.TripsInvoiceToTripDto(invoice.get()));
            return Response.ok(invoiceDto).build();
        }else{
           Invoice invoice1 = invoiceFacade.generateInvoiceVehicle(year,month,registrationId);
           if(invoice1 == null){
               return Response.status(204).build();
           }else{
               return Response.ok(invoice1).build();
           }
        }
    }

    @GET
    @Path("/user/{user_id}")
    public Response getInvoiceByUserId(@PathParam("user_id") Long user_id, @QueryParam("year") int year, @QueryParam("month") int month){
        Optional<User> user = userFacade.findById(user_id);
        if(!user.isPresent()){
            return Response.status(404).build();
        }
        Optional<Invoice> invoice = invoiceFacade.findByUserID(user_id,year,month);
        if(invoice.isPresent()){
            InvoiceDto invoiceDto = invoiceMapper.invoiceToInvoiceDto(invoice.get());
            invoiceDto.setTripDtos(invoiceFacade.TripsInvoiceToTripDto(invoice.get()));
            return Response.ok(invoiceDto).build();
        }else{
            Invoice invoice1 = invoiceFacade.generateInvoiceFromUser(year,month,user_id);
            if(invoice1 == null){
                return Response.status(204).build();
            }else{
                return Response.ok(invoice1).build();
            }
        }
    }
    @GET
    @Path("/user/{user_id}/all")
    public Response getInvoiceAllByUser(@PathParam("user_id") Long user_id){
        Optional<User> user = userFacade.findById(user_id);
        if(!user.isPresent()){
            return Response.status(404).build();
        }
        List<Invoice> invoices = invoiceFacade.getAllInvoiceUser(user_id);
        if(invoices == null || invoices.size()==0){
            return Response.status(204).build();
        }else{
            return Response.ok(invoiceFacade.invoicesToInvoiceDtos(invoices)).build();
        }

    }
    @PUT
    @Path("")
    @Consumes("application/json")
    public Response updateInvoice(InvoiceDto invoiceDto,@QueryParam("year") int year, @QueryParam("month") int month) throws ParseException {
        Optional<Invoice> invoice = invoiceFacade.findByUserID(invoiceDto.getUser_id(),year,month);
        if(!invoice.isPresent()){
            return Response.status(404).build();
        }
         invoiceDto.setId(invoice.get().getId());
        invoice.get().setPayDate(new SimpleDateFormat("dd/MM/yyyy").parse(invoiceDto.getPayDate()));
        invoiceFacade.updateInvoice(invoice.get());
        return Response.ok().build();


    }
}
