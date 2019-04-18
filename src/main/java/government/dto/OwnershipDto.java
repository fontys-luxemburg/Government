package government.dto;

import java.util.Date;

public class OwnershipDto extends BaseDto {
    private long userID;
    private String userName;
    private long vehicleID;
    private String vehicleRegistrationID;
    private Date endDate;

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(long vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleRegistrationID() {
        return vehicleRegistrationID;
    }

    public void setVehicleRegistrationID(String vehicleRegistrationID) {
        this.vehicleRegistrationID = vehicleRegistrationID;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
