export const vehicleService = {
  findVehicle
};

function findVehicle(registrationID) {
  return fetch(`/government/api/vehicles/${registrationID}`)
    .then(resp => resp.json())
    .then(vehicle => {
      return vehicle;
    });
}
