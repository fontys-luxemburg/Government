<template>
  <div>
    <div v-if="status.loading" class="flex justify-center items-center my-32">
      <MoonLoader color="black"/>
    </div>

    <div v-if="status.loaded">
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

    <div v-if="status.failed">Whoops... Something went wrong</div>
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
      status: state => state.vehicles.status
    })
  },

  created() {
    this.$store.dispatch("vehicles/getVehicle", "AB1234");
  }
};
</script>
