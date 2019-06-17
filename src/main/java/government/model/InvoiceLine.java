package government.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class InvoiceLine extends BaseEntity{
    @ManyToOne
    private Invoice invoice;

}
