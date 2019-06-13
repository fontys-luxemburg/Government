<template>
  <div>
    <div class="bg-white rounded p-8 mb-8">
      <div class="flex flex-col items-center">
        <h1 class="mb-8">Search vehicle information</h1>
        <form class="flex" type="get" @submit.prevent="search">
          <div class="flex bg-yellow text-xl inline-flex rounded overflow-hidden mr-4">
            <div class="bg-blue p-2">
              <svg height="24" width="24" class="stroke-current text-yellow">
                <circle
                  cx="12"
                  cy="12"
                  r="8"
                  stroke-width="2"
                  fill="transparent"
                  stroke-dasharray="0.001 5.6"
                  stroke-linecap="round"
                ></circle>
              </svg>
              <div class="text-white text-sm text-center">L</div>
            </div>
            <input
              type="text"
              autofocus
              placeholder="AB-1234"
              class="bg-transparent py-2 px-4 w-32 text-2xl"
              v-model="registrationID"
            >
          </div>

          <button
            type="submit"
            class="block bg-grey-light hover:bg-grey text-grey-darker group py-4 px-8 pr-6 rounded flex items-center"
            :disabled="registrationID.length == 0"
          >
            <span class="mr-2">Search</span>
            <svg
              class="text-grey-dark group-hover:text-grey-dark"
              xmlns="http://www.w3.org/2000/svg"
              width="24"
              height="24"
              viewBox="0 0 24 24"
              fill="none"
              stroke="currentColor"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
            >
              <polyline points="9 18 15 12 9 6"></polyline>
            </svg>
          </button>
        </form>
      </div>
    </div>

    <div class="flex -mx-4">
      <div class="w-1/2 mx-4 bg-white rounded p-6">
        <h2 class="mb-4">Actions</h2>

        <ul>
          <li class="mb-2">
            <router-link :to="{ name: 'vehicles#new' }">Register a new vehicle</router-link>
          </li>
          <li class="mb-2">
            <router-link :to="{ name: 'drivers#new' }">Register a driver</router-link>
          </li>
          <li class="mb-2">
            <router-link to="/">Update settings</router-link>
          </li>
        </ul>
      </div>
      <div class="w-1/2 mx-4 bg-white rounded p-6">
        <h2>Recent changes</h2>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "index",

  data() {
    return {
      registrationID: ""
    };
  },

  methods: {
    search() {
      this.$router.push({
        name: "vehicles#show",
        params: { license_number: this.registrationID }
      });
    }
  }
};
</script>

<style scoped>
</style>
