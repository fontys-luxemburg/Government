package government.dto;

import government.model.InvoiceLine;

public class invoiceDto extends BaseDto  {
    private String User_name;
    private String registrationId;
    private String from;
    private String till;
    private List<InvoiceLineDto> invoiceLineDtoList
}
