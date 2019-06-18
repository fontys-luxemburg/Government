<template>
  <div>
    <car-header />
    <div class="bg-white rounded p-8"> 
      <p>{{ date.month }}</p>
      <month-picker @change="showDate"></month-picker>
    </div>
    <div class="bg-white rounded p-8">      
      <la-cartesian autoresize :bound="[0]" :data="values">
        <la-line prop="km"></la-line>
        <la-y-axis></la-y-axis>
        <la-x-axis prop="name"></la-x-axis>
        <la-tooltip></la-tooltip>
      </la-cartesian>
    </div>
    <div class="bg-white rounded p-8">
      <div class="mb-4 flex justify-between items-center">
      <h2>List of trips</h2>
      </div>
      <b-table striped hover :items="values"></b-table>
    </div>
  </div>  
</template>

<script>
    import CarHeader from "./CarHeader";
    import { Cartesian, Line } from 'laue'
    import { mapState } from 'vuex';
    import moment from 'moment';
    import { MonthPicker } from 'vue-month-picker';

    export default {
      name: "Travels",
      data() {
        return {
          date: {
            from: null,
            to: null,
            month: null,
            year: null
            }
          }
      },
      components: {
        LaCartesian: Cartesian,
        LaLine: Line,
        CarHeader,
        MonthPicker
      },
      methods: {
        showDate (date) {
          this.date = date
          this.$store.dispatch("trackers/getTripsBetweenDates", [this.$route.params.license_number, date.from, date.to])
        }
      },

      computed: {
        ...mapState({
          trips: state => state.trackers.allTrips
        }),
        values: function() { 
            return this.trips.map(trip => {
              return {Date: moment(trip.startDate).format("DD MMM YYYY"), km: Math.round(trip.distanceTraveledKm * 100) / 100 };
            });
        }
      },

      created() {
      }
}
</script>

<style scoped>

</style>