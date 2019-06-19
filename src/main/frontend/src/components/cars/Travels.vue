<template>
  <div>
    <car-header />
    <div class="bg-white rounded p-8">
      <la-cartesian autoresize :bound="[0]" :data="values">
        <la-line prop="km"></la-line>
        <la-y-axis></la-y-axis>
        <la-x-axis prop="name"></la-x-axis>
        <la-tooltip></la-tooltip>
      </la-cartesian>
    </div>

    <div class="bg-white rounded p-8">
      <table>
        <thead>
          <td>Date</td>
          <td>Total KM</td>
          <td>Total Price</td>
        </thead>
        <tbody>
          <tr v-for="trip in trips">
            <td>{{ trip.startDate | moment('MM-dd-yyyy HH:mm')}}</td>
            <td>{{ trip.distanceTraveledKm }} km</td>
            <td>€ {{ trip.totalPrice }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
    import CarHeader from "./CarHeader";
    import { Cartesian, Line } from 'laue'
    import { mapState } from 'vuex';

    export default {
      name: "Travels",
      components: {
        LaCartesian: Cartesian,
        LaLine: Line,
        CarHeader
      },

      computed: {
        ...mapState({
          trips: state => state.trackers.allTrips
        }),
        values: function() { 
            return this.trips.map(trip => {
              return {name: trip.startDate, km: trip.distanceTraveledKm };
            });
        }
      },

      created() {
        this.$store.dispatch("trackers/getTripsBetweenDates", this.$route.params.license_number)
      }
}
</script>

<style scoped>

</style>