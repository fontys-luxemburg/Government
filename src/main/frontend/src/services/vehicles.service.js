import {authHeader} from "../helpers";
import {userService} from "./users.service";
import auth from "../store/modules/auth";

export const vehicleService = {
  findVehicle,
  saveVehicle,
  findVehicleInformation,
  updateVehicleInformation
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

function saveVehicle(params) {
    const requestOptions = {
      method: "POST",
      headers: {
        ...authHeader(),
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(params)
    };

    return fetch('/government/api/vehicles', requestOptions)
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

function updateVehicleInformation(vehicleInformation) {
    const requestOptions = {
        method: "PUT",
        headers: {
            ...authHeader(),
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(vehicleInformation)
    };

    return fetch(`/government/api/vehicles/${vehicleInformation.vehicle_id}/information`, requestOptions)
        .then(response => {
            if(!response.ok) {
                if(response.status === 401) {
                    userService.logout();
                }

                const error = (data && data.message) || response.statusText;
                return Promise.reject(error);
            }

            return response;
        })
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