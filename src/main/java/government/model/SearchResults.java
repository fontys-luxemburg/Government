package government.model;

import government.dto.UserDto;
import government.dto.VehicleDto;

import java.util.List;

public class SearchResults {
    private List<VehicleDto> vehicles;
    private List<UserDto> users;

    public SearchResults(List<VehicleDto> vehicles, List<UserDto> users) {
        this.vehicles = vehicles;
        this.users = users;
    }

    public List<VehicleDto> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleDto> vehicles) {
        this.vehicles = vehicles;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }
}
