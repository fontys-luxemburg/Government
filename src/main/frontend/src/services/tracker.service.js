import { authHeader } from "../helpers";

export const trackerService = {
    findTrackers,
    findTripsBetweenDates,
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

function findTripsBetweenDates(registrationID, begin, end ) {
    const requestOptions = {
        method: "GET",
        headers: authHeader(),
        body: JSON.stringify({ registrationID, begin, end })
    };

    return fetch(
        `/government/api/trackers/dates`, 
        requestOptions
    )
    .then(handleResponse)
    .then(trips => {
        return trips;
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