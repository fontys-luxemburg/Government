import { authHeader } from "../helpers";

export const trackerService = {
    findTrackers
};

function findTrackers(vehicleID) {
    const requestOptions = {
        method: "GET",
        headers: authHeader()
      };
    
      return fetch(
        `/government/api/vehicles/${vehicleID}/trackers`,
        requestOptions
      )
        .then(handleResponse)
        .then(trackers => {
          return trackers;
        });
}

function handleResponse(response) {
    const data = response.json();
  
    if (!response.ok) {
      if (response.status === 401) {
        userService.logout();
      }
  
      const error = (data && data.message) || response.statusText;
      return Promise.reject(error);
    }
  
    return data;
  }