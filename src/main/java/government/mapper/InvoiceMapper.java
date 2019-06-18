package government.mapper;

import government.dto.InvoiceDto;
import government.model.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "invoice")
public interface InvoiceMapper {
    @Mapping(target = "registrationId", source = "vehicle.registrationID")
    @Mapping(target = "user_name", source = "user.name")
    @Mapping(target = "user_id", source = "user.id")
    @Mapping(target = "endDate", source = "endDate.time")
    @Mapping(target = "startDate", source = "startDate.time")
    @Mapping(target = "payDate", source = "payDate.time")
    InvoiceDto invoiceToInvoiceDto(Invoice invoice);
    List<InvoiceDto> invoicesToInvoicesDtos(List<Invoice> invoices);

    @Mapping(target = "vehicle.registrationID", source = "registrationId")
    @Mapping(target = "user.name", source = "user_name")
    @Mapping(target = "user.id", source = "user_id")
    Invoice invoiceDtoToInvoice(InvoiceDto invoiceDto);
}
