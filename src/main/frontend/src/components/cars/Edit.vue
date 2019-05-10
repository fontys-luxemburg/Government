<template>
  <div>
    <back-button :to="{ name: 'cars#show', params: { license_number: vehicle.registrationID }}" class="mb-2" />
    <div class="bg-white rounded p-8">
      <h1>Edit Peugeot 208 - AB1234</h1>
      <form>

      </form>
    </div>
  </div>
</template>

<script>
    import BackButton from "../BackButton";
    import {mapState} from "vuex";
    export default {
        name: "cars-edit",
        components: {BackButton},
        computed: {
            ...mapState({
                vehicle: state => state.vehicles.value
            })
        }
    }
</script>

<style scoped>

</style>