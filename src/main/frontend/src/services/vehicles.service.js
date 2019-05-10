import {authHeader} from "../helpers";
import {userService} from "./users.service";

export const vehicleService = {
  findVehicle,
    findVehicleInformation
};

function findVehicle(registrationID) {
    const requestOptions = {
        method: "GET",
        headers: authHeader()
    };

  return fetch(`/government/api/vehicles/${registrationID}`, requestOptions)
    .then(handleResponse)
    .then(vehicle => {
      return vehicle;
    });
}

function findVehicleInformation(id) {
    const requestOptions = {
        method: "GET",
        headers: authHeader()
    };

    return fetch(`/government/api/vehicles/${id}/information`, requestOptions)
        .then(handleResponse)
        .then(vehicleInformation => {
            return vehicleInformation;
        });
}

function handleResponse(response) {
    const data = response.json();

    if(!response.ok) {
        if(response.status === 401) {
            userService.logout();
        }

        const error = (data && data.message) || response.statusText;
        return Promise.reject(error);
    }

    return data;
}