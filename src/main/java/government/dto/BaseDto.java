package government.dto;

import java.io.Serializable;
import java.util.Date;

public class BaseDto implements Serializable {
    private Date createDate;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
