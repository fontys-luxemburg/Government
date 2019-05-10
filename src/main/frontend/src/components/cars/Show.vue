<template>
  <div>
      <car-header/>

      <div class="bg-white rounded p-8">
        <h2 class="mb-4">Vehicle information</h2>
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
      vehicleInformation: state => state.vehicleInformation.value,
      status: state => state.vehicleInformation.status
    })
  },

  created() {
    this.$store.dispatch("vehicleInformation/getVehicleInformation", this.$route.params.license_number );
  }
};
</script>
