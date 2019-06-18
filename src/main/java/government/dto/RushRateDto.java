package government.dto;

public class RushRateDto {

    private Long rateID;
    private int dayOfWeek;
    private String startTime;
    private String endTime;
    private double multiplier;

    public Long getRateID() {
        return rateID;
    }

    public void setRateID(Long rateID) {
        this.rateID = rateID;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }
}
