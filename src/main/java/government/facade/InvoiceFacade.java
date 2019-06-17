package government.facade;

import government.model.Invoice;
import government.repository.InvoiceRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class InvoiceFacade implements BaseFacade<Invoice, Long>{
    @Inject
    InvoiceRepository invoiceRepository;
    @Override
    public Optional<Invoice> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Invoice> findAll() {
        return null;
    }

    @Override
    public Invoice save(Invoice entity) {
        return null;
    }


    public Optional<Invoice> findByRegistrationId(String registrationId, Long startDate, Long endDate) {

       return invoiceRepository.findByRegistrationId(registrationId,new Date(startDate),new Date(endDate));

    }

}
