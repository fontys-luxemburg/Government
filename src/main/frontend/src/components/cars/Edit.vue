<template>
  <div v-if="">
    <back-button :to="{ name: 'cars#show', params: { license_number: vehicle.registrationID }}" class="mb-2" />
    <div class="bg-white rounded p-8">
      <h1 class="mb-12">Edit Peugeot 208 - AB1234</h1>
      <form @submit.prevent="onSubmit()">
        <div class="flex -mx-4 mb-8">
          <div class="w-1/5 mx-4">
            <h2 class="text-lg font-semibold mb-2">General</h2>
          </div>
          <div class="w-4/5 mx-4">
            <form-field name="Trade name" v-model="vehicleInformation.tradeName"/>
            <form-field name="Type" v-model="vehicleInformation.type"/>
            <form-field name="Color" v-model="vehicleInformation.color"/>
          </div>
        </div>

        <div class="flex -mx-4 mb-8">
          <div class="w-1/5 mx-4">
            <h2 class="text-lg font-semibold mb-2">Registration</h2>
          </div>
          <div class="w-4/5 mx-4">
            <div class="form-group">
              <label for="registrationDate" class="form-label">Registration Date</label>
              <input id="registrationDate" type="text" name="body" class="form-input" v-model="vehicleInformation.registrationDate"/>
            </div>
            <div class="form-group">
              <label for="apkExpirationDate" class="form-label">Checkup Expiration Date</label>
              <input id="apkExpirationDate" type="text" name="body" class="form-input" v-model="vehicleInformation.apkExpirationDate"/>
            </div>
          </div>
        </div>

        <div class="flex -mx-4 mb-8">
          <div class="w-1/5 mx-4">
            <h2 class="text-lg font-semibold mb-2">Options</h2>
          </div>
          <div class="w-4/5 mx-4">
            <form-field-boolean v-model="vehicleInformation.stolen" name="Stolen"/>
            <form-field-boolean v-model="vehicleInformation.exported" name="Exported"/>
            <form-field-boolean v-model="vehicleInformation.wamInsured" name="WAM Insured"/>
            <form-field-boolean v-model="vehicleInformation.mayRideOnRoad" name="May Ride on Road"/>

            <div class="flex mt-8">
              <div class="w-1/4 -mx-2"></div>
              <div>
                <button class="bg-blue text-white py-4 px-8 rounded m-0">Save</button>
              </div>
            </div>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
    import BackButton from "../BackButton";
    import {clone} from 'underscore';
    import {mapState} from "vuex";
    import FormField from "./FormField";
    import FormFieldBoolean from "./FormFieldBoolean";

    export default {
        name: "cars-edit",
        components: {FormFieldBoolean, FormField, BackButton},

        data() {
            return {
                vehicleInformation: clone(this.$store.state.vehicleInformation.value)
            }
        },

        computed: {
            ...mapState({
                vehicle: state => state.vehicles.value
            })
        },

        methods: {
            onSubmit() {
                console.log('vehicleInformation', this.vehicleInformation);

                this.$store.dispatch('vehicleInformation/updateVehicleInformation', this.vehicleInformation);
            }
        },

        created() {
            this.$store.dispatch("vehicles/getVehicle", this.$route.params.license_number);

            this.$store.dispatch("vehicleInformation/getVehicleInformation", this.$route.params.license_number);
        }
    }
</script>

<style scoped lang="postcss">

  .form-group {
    @apply flex -mx-4 items-center mb-2;
  }

  .form-label {
    @apply w-1/4 text-right mx-4;

  }

  .form-input {
    @apply bg-grey-lighter mx-4 w-full p-4 rounded;
  }

</style>