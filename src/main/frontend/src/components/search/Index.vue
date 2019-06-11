<template>
  <div v-if="status.loaded" class="bg-white p-8 rounded">
    <h1 class="mb-8">Search results ({{ results.users.length + results.vehicles.length }})</h1>

    <div v-for="user in results.users" :key="user.id" class="border rounded p-4 mb-2 flex items-center">
      <div class="w-16 h-16 bg-grey-light rounded-full mr-4"></div>
      <div>
        <router-link :to="{name: 'drivers#show', params: { driver_id: user.id }}" class="no-underline text-blue hover:text-blue-dark text-lg font-semibold">{{ user.name }}</router-link>
        <span class="block mt-2">{{ user.email }}</span>
      </div>
    </div>

    <div v-for="vehicle in results.vehicles" :key="vehicle.registrationID" class="border rounded p-4 mb-2">
      <router-link :to="{name: 'vehicles#show', params: { license_number: vehicle.registrationID }}" class="no-underline text-blue hover:text-blue-dark text-lg font-semibold">{{ vehicle.brand }} – {{ vehicle.model }}</router-link>
      <span class="block mt-2">{{ vehicle.registrationID }}</span>
    </div>

  </div>
</template>

<script>
  import {mapState} from "vuex";

  export default {
    name: "search-index",
    computed: {
      ...mapState({
        results: state => state.search.results,
        status: state => state.search.status
      })
    },
    mounted() {
      if(this.results == null) {
        this.$store.dispatch("search/search", this.$route.query.query);
      }
    }
  }
</script>

<style scoped>

</style>
