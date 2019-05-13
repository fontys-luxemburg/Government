import { authHeader } from "../helpers";

export const trackerService = {
    findTrackers,
    createTracker
};

function findTrackers(registrationID) {
    const requestOptions = {
        method: "GET",
        headers: authHeader()
      };
    
      return fetch(
        `/government/api/vehicles/${registrationID}/trackers`,
        requestOptions
      )
        .then(handleResponse)
        .then(trackers => {
          return trackers;
        });
}

function createTracker(registrationID) {
    const requestOptions = {
      method: "POST",
      headers: {
          ...authHeader(),
          'Content-Type': 'application/json'
        }
    };

    return fetch(`/government/api/vehicles/${registrationID}/trackers`, requestOptions)
        .then(resp => {
            if (resp.ok) {
                return Promise.resolve(true);
            } else {
                return Promise.reject();
            }
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