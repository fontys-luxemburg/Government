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
  </div>
</template>

<script>
    import CarHeader from "./CarHeader";
    import { Cartesian, Line } from 'laue'
    import { mapState } from 'vuex';
    import moment from 'moment';

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
              return {name: moment(trip.startDate).format("DD MMM YYYY"), km: trip.distanceTraveledKm };
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