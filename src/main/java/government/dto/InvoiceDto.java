package government.dto;

import java.util.List;

public class InvoiceDto extends BaseDto  {
    private String user_name;
    private Long user_id;
    private String registrationId;
    private String startDate;
    private String endDate;
    private List<TripDto> tripDtos;
    private String payDate;

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }
}
