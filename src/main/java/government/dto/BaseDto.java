package government.dto;

import java.io.Serializable;
import java.util.Date;

public class BaseDto implements Serializable {
    private Date createdAt;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
