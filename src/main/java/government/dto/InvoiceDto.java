package government.dto;

import java.util.List;

public class InvoiceDto extends BaseDto  {
    private String user_name;
    private Long user_id;
    private String registrationId;
    private String from;
    private String till;
    private List<TripDto> tripDtos;
    private boolean ispaid;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTill() {
        return till;
    }

    public void setTill(String till) {
        this.till = till;
    }

    public List<TripDto> getTripDtos() {
        return tripDtos;
    }

    public void setTripDtos(List<TripDto> tripDtos) {
        this.tripDtos = tripDtos;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public boolean isIspaid() {
        return ispaid;
    }

    public void setIspaid(boolean ispaid) {
        this.ispaid = ispaid;
    }
}
