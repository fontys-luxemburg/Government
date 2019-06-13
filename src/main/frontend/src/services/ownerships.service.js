import { authHeader } from "../helpers";
import { userService } from "./users.service";

export const ownershipsService = {
  findOwnerships,
  transfer,
  findOwnershipsByDriver
};

function findOwnerships(registrationID) {
  const requestOptions = {
    method: "GET",
    headers: authHeader()
  };

  return fetch(
    `/government/api/vehicles/${registrationID}/ownerships`,
    requestOptions
  )
    .then(handleResponse)
    .then(ownerships => {
      return ownerships;
    });
}

function transfer(registrationID, user_id) {
  const requestOptions = {
    method: "post",
    headers: {
      "Content-Type": "application/json",
      ...authHeader()
    },
    body: JSON.stringify({
      user_id
    })
  };

  return fetch(
    `/government/api/vehicles/${registrationID}/ownerships`,
    requestOptions
  ).then(resp => {
    if (resp.ok) {
      return Promise.resolve(true);
    } else {
      return Promise.reject();
    }
  });
}
function findOwnershipsByDriver(driver_id) {
  const requestOptions = {
    method: "GET",
    headers: authHeader()
  };

  return fetch(`/government/api/users/${driver_id}/ownerships`, requestOptions)
      .then(handleResponse)
      .then(ownerships => {
        return ownerships;
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
