<template>
  <div v-if="status.loaded">
    <div class="mb-2">
      <back-button to="/" />
    </div>
    <div class="bg-white rounded mb-8">
      <div class="p-8">
        <h1 class="mb-2">{{ vehicle.brand }}</h1>
        <h2>{{ vehicle.model }} – {{ vehicle.registrationID }}</h2>
      </div>

      <div class="flex px-4">
        <router-link
          class="no-underline px-6 py-4 block text-grey-dark hover:text-blue"
          :to="{ name: 'vehicles#show', params: { license_number: vehicle.registrationID }}"
        >Basic</router-link>
        <router-link
          class="no-underline px-6 py-4 block text-grey-dark hover:text-blue"
          :to="{ name: 'vehicles#trackers', params: { license_number: vehicle.registrationID }}"
        >Trackers</router-link>
        <router-link
          class="no-underline px-6 py-4 block text-grey-dark hover:text-blue"
          :to="{ name: 'vehicles#owner', params: { license_number: vehicle.registrationID }}"
        >Owner</router-link>
        <router-link
          class="no-underline px-6 py-4 block text-grey-dark hover:text-blue"
          :to="{ name: 'vehicles#travels', params: { license_number: vehicle.registrationID }}"
        >Travels</router-link>
      </div>
    </div>
  </div>
</template>

<script>
    import {mapState} from 'vuex';
    import BackButton from "../BackButton";

    export default {
  name: "car-header",
    components: {BackButton},
    computed: {
    ...mapState({
        status: state => state.vehicles.status,
      vehicle: state => state.vehicles.value
    })
  },

    created() {
      if (this.vehicle && this.vehicle.registrationID === this.$route.params.license_number) return;

      this.$store.dispatch("vehicles/getVehicle", this.$route.params.license_number);
    }
};
</script>


<style scoped>
.router-link-exact-active {
  @apply bg-blue text-white rounded-t;
}

.router-link-exact-active:hover {
  @apply text-white;
}
</style>
