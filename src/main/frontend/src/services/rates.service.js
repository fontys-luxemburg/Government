import { authHeader } from "../helpers";
import { userService } from "./users.service";

export const ratesService = {
  getAllRates,
  createRate,
  createRushRate
};

function getAllRates() {
  const requestOptions = {
    method: "GET",
    headers: authHeader()
  };

  return fetch(
    `/government/api/rates`,
    requestOptions
  )
    .then(handleResponse)
    .then(rates => {
      return rates;
    });
}

function createRushRate(rushRate, rateId) {
  const requestOptions = {
    method: "POST",
    headers: {
      ...authHeader(),
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(rushRate)
  };

  return fetch(`/government/api/rates/${rateId}/rush_rates`, requestOptions)
      .then(resp => {
        if (resp.ok) {
          return Promise.resolve(true);
        } else {
          return Promise.reject();
        }
      });
}


function createRate(rate) {
  const requestOptions = {
    method: "POST",
    headers: {
      ...authHeader(),
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(rate)
  };

  return fetch(`/government/api/rates`, requestOptions)
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
