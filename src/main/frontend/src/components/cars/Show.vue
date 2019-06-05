<template>
  <div>
    <div v-if="vehicleStatus.failed" class="flex items-center justify-center flex-col mt-32">
      <h1 class="mb-8">We couldn't find this vehicle</h1>
      <router-link to="/" class="bg-blue p-4 rounded text-white no-underline hover:bg-blue-dark">Search for other vehicle</router-link>
    </div>

    <div v-if="vehicleStatus.loaded">
      <car-header/>

      <div class="bg-white rounded p-8">
        <div class="mb-4 flex justify-between items-center">
          <h2>Vehicle information</h2>
          <router-link
            :to="{ name: 'vehicles#edit', params: { license_number: vehicle.registrationID }}"
            class="no-underline bg-grey-lighter hover:bg-grey-light hover:text-grey-darkest text-grey-darker py-4 px-8 rounded"
          >
            Edit Vehicle
          </router-link>
        </div>
        <table class="w-full">

          <tr class="border-b border-grey-lighter">
            <td class="py-4">Brand</td>
            <td class="py-4 w-2/3">{{vehicle.brand}}</td>
          </tr>
          <tr class="border-b border-grey-lighter">
            <td class="py-4">Model</td>
            <td class="py-4 w-2/3">{{vehicle.model}}</td>
          </tr>
          <tr class="border-b border-grey-lighter">
            <td class="py-4">Body type</td>
            <td class="py-4 w-2/3">{{vehicle.bodyType}}</td>
          </tr>
          <tr class="border-b border-grey-lighter" >
            <td class="py-4">Trade name</td>
            <td class="py-4 w-2/3">{{vehicleInformation.tradeName}}</td>
          </tr>
          <tr class="border-b border-grey-lighter">
            <td class="py-4">Type</td>
            <td class="py-4 w-2/3">{{vehicleInformation.type}}</td>
          </tr>
          <tr class="border-b border-grey-lighter">
            <td class="py-4">Color</td>
            <td class="py-4 w-2/3">{{vehicleInformation.color}}</td>
          </tr>
          <tr class="border-b border-grey-lighter">
            <td class="py-4">Registration date</td>
            <td class="py-4 w-2/3">{{vehicleInformation.registrationDate}}</td>
          </tr>
          <tr class="border-b border-grey-lighter">
            <td class="py-4">APK experation date</td>
            <td class="py-4 w-2/3">{{vehicleInformation.apkExperationDate}}</td>
          </tr>
          <tr class="border-b border-grey-lighter">
            <td class="py-4">Is stolen</td>
            <td class="py-4 w-2/3">{{vehicleInformation.stolen}}</td>
          </tr>
          <tr class="border-b border-grey-lighter">
            <td class="py-4">Is exported</td>
            <td class="py-4 w-2/3">{{vehicleInformation.exported}}</td>
          </tr>
          <tr class="border-b border-grey-lighter">
            <td class="py-4">is WAM insured</td>
            <td class="py-4 w-2/3">{{vehicleInformation.wamInsured}}</td>
          </tr>
          <tr class="border-b border-grey-lighter">
            <td class="py-4">May ride on road</td>
            <td class="py-4 w-2/3">{{vehicleInformation.mayRideOnRoad}}</td>
          </tr>
          <tr class="border-b border-grey-lighter">
            <td class="py-4">Catalog price</td>
            <td class="py-4 w-2/3">{{vehicleInformation.catalogPrice}}</td>
          </tr>
        </table>
      </div>
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
    this.$store.dispatch("vehicleInformation/getVehicleInformation", this.$route.params.license_number);

    if (this.vehicle && this.vehicle.registrationID === this.$route.params.license_number) return;
    this.$store.dispatch("vehicles/getVehicle", this.$route.params.license_number);
  }
}
</script>
