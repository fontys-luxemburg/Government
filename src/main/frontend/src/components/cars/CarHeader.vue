<template>
  <div>
    <div class="mb-2">
      <router-link to="/" class="no-underline text-grey-dark inline-flex items-center hover:text-grey-darker">
        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-chevron-left"><polyline points="15 18 9 12 15 6"></polyline></svg>
        Back
      </router-link>
    </div>
    <div class="bg-white rounded mb-8">
      <div class="p-8">
        <h1 class="mb-2">Peugeot</h1>
        <h2>208 – {{ this.$route.params.license_number }}</h2>
      </div>

      <div class="flex px-4">
        <router-link class="no-underline px-6 py-4  block text-grey-dark hover:text-blue"
                     :to="{ name: 'cars#show', params: {license_number: 'AB-1234'}}">
          Basic
        </router-link>
        <router-link class="no-underline px-6 py-4 block text-grey-dark hover:text-blue"
                     :to="{ name: 'cars#trackers', params: {license_number: 'AB-1234'}}">
          Trackers
        </router-link>
        <router-link class="no-underline px-6 py-4 block text-grey-dark hover:text-blue"
                     :to="{ name: 'cars#owner', params: {license_number: 'AB-1234'}}">
          Owner
        </router-link>
        <router-link class="no-underline px-6 py-4 block text-grey-dark hover:text-blue"
                     :to="{ name: 'cars#travels', params: {license_number: 'AB-1234'}}">
          Travels
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
        name: 'car-header'
    }
</script>


<style scoped>
  .router-link-exact-active {
    @apply bg-blue text-white rounded-t;
  }

  .router-link-exact-active:hover {
    @apply text-white;
  }
</style>
