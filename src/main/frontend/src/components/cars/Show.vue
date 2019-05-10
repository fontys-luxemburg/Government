<template>
  <div v-if="vehicleStatus.loaded">
      <car-header/>

      <div class="bg-white rounded p-8">
        <div class="mb-4 flex justify-between items-center">
          <h2>Vehicle information</h2>
          <router-link
            :to="{ name: 'cars#edit', params: { license_number: vehicle.registrationID }}"
            class="no-underline bg-grey-lighter hover:bg-grey-light hover:text-grey-darkest text-grey-darker py-4 px-8 rounded"
          >
            Edit Vehicle
          </router-link>
        </div>
        <table class="w-full">
          <tr class="border-b border-grey-lighter">
            <td class="py-4">Vehicle category</td>
            <td class="py-4 w-2/3">Car</td>
          </tr>
          <tr class="border-b border-grey-lighter">
            <td class="py-4">Suspension type</td>
            <td class="py-4 w-2/3">Hatchback</td>
          </tr>
          <tr class="border-b border-grey-lighter">
            <td class="py-4">Brand</td>
            <td class="py-4 w-2/3">PEUGEOT</td>
          </tr>
          <tr class="border-b border-grey-lighter">
            <td class="py-4">Type</td>
            <td class="py-4 w-2/3">C</td>
          </tr>
          <tr>
            <td class="py-4">Color</td>
            <td class="py-4 w-2/3">Grey</td>
          </tr>
        </table>
      </div>
    </div>
</template>

<script>
import CarHeader from "./CarHeader";
import { mapState } from "vuex";
import MoonLoader from "vue-spinner/src/MoonLoader.vue";

export default {
  name: "cars-show",

  components: { CarHeader, MoonLoader },

  computed: {
    ...mapState({
      vehicle: state => state.vehicles.value,
      vehicleStatus: state => state.vehicles.status,
      vehicleInformation: state => state.vehicleInformation.value,
      status: state => state.vehicleInformation.status
    })
  },

  created() {
    this.$store.dispatch("vehicles/getVehicle", this.$route.params.license_number );
    this.$store.dispatch("vehicleInformation/getVehicleInformation", this.$route.params.license_number );
  }
};
</script>
