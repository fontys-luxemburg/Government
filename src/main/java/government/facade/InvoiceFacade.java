package government.facade;


import government.dto.InvoiceDto;
import government.dto.OwnershipDto;
import government.dto.TrackerIdDto;
import government.dto.TripDto;
import government.mapper.InvoiceMapper;
import government.mapper.TripMapper;
import government.model.*;
import government.repository.InvoiceRepository;
import org.apache.commons.lang3.tuple.Pair;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class InvoiceFacade implements BaseFacade<Invoice, Long>{
    @Inject
    InvoiceRepository invoiceRepository;
    @Inject
    VehicleFacade vehicleFacade;
    @Inject
    TripMapper tripMapper;
    @Inject
    TrackerIdFacade trackerIdFacade;
    @Inject
    UserFacade userFacade;
    @Inject
    OwnershipFacade ownershipFacade;
    @Inject
    InvoiceMapper invoiceMapper;

    @Override
    public Optional<Invoice> findById(Long id) {
        return invoiceRepository.findById(id);
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice save(Invoice entity) {
        return invoiceRepository.save(entity);
    }

    public Optional<Invoice> findByRegistrationId(String registrationId, int year, int month) {
        Pair<Date,Date> startEnd = DateHelper.getDateRange(year,month);
       return invoiceRepository.findByRegistrationId(registrationId,startEnd.getKey(),startEnd.getValue());
    }

    public Optional<Invoice> findByUserID(Long user_id,int year, int month){
        Pair<Date,Date> startEnd = DateHelper.getDateRange(year,month);
        return invoiceRepository.findByUserId(user_id,startEnd.getKey(),startEnd.getValue());
    }
    public List<TripDto> TripsInvoiceToTripDto(Invoice invoice){
        List<TripDto> tripDtos = new ArrayList<>();
        for(Trip trip: invoice.getTrips()){
            tripDtos.add(tripMapper.tripToTripDto(trip));
        }
        return tripDtos;
    }
    public List<Invoice> getAllInvoiceUser(Long user_id){
        return invoiceRepository.getAllInvoicesByUser(user_id);
    }
    public Invoice generateInvoiceVehicle(int year,int month,String registrationId ){
        Pair<Date,Date> startEnd = DateHelper.getDateRange(year,month);
        Date start = startEnd.getKey();
        Date end = startEnd.getValue();
        Optional<Vehicle> vehicle = vehicleFacade.findByRegistrationID(registrationId);
        if (!vehicle.isPresent()){
            return null;
        }
        List<TrackerIdDto> trackers = trackerIdFacade.getTrackersFromVehicleBetweenDates(registrationId,start,end);

        Invoice invoice = new Invoice(vehicle.get(),start,end,null,getTripsFromTrackers(trackers));
        return invoiceRepository.save(invoice);
    }
    public Invoice generateInvoiceFromUser(int year, int month, Long user_id) {
        Pair<Date,Date> startEnd = DateHelper.getDateRange(year,month);
        Date start = startEnd.getKey();
        Date end = startEnd.getValue();
        Optional<User> user = userFacade.findById(user_id);
        if(!user.isPresent()){
            return null;
        }
        List<Ownership> ownerships = ownershipFacade.findByUserAndDate(user.get(),start,end);
        List<Trip> trips = getTripsFromOwnerships(ownerships,start,end);

        return invoiceRepository.save( new Invoice(user.get(),start,end,null,trips));
    }

    public List<InvoiceDto> invoicesToInvoiceDtos(List<Invoice> invoices){
        List<InvoiceDto> invoiceDtos = new ArrayList<>();
        for(Invoice invoice : invoices){
            InvoiceDto invoiceDto = invoiceMapper.invoiceToInvoiceDto(invoice);
            invoiceDto.setTripDtos(tripMapper.tripsToTripDtos(invoice.getTrips()));
            invoiceDtos.add(invoiceDto);
        }
        return invoiceDtos;
    }

    private List<Trip> getTripsFromTrackers(List<TrackerIdDto> trackers){
        List<Trip> trips = new ArrayList<>();
        for(TrackerIdDto tracker : trackers){
            trips.addAll(tripMapper.tripDtosToTrips(tracker.getTrips()));
        }
        return trips;
    }

    private List<Trip> getTripsFromOwnerships(List<Ownership> ownerships,Date start,Date end){
        List<Trip> trips = new ArrayList<>();
        for(Ownership ownership : ownerships){
            Vehicle vehicle = ownership.getVehicle();
            List<TrackerIdDto> trackers = trackerIdFacade.getTrackersFromVehicleBetweenDates(vehicle.getRegistrationID(),start,end);
            trips.addAll(getTripsFromTrackers(trackers));
        }
        return trips;
    }

    public Invoice updateInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }
}
