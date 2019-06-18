<template>
  <div class="w-1/7 mx-2">
    <span class="mb-2 block">{{ weekday }}</span>
    <div class="bg-grey-lighter rounded p-1 h-64 mb-2">
      <rate-deviation v-for="rushRate in rushRatesForDay" :deviation="rushRate" />
    </div>

    <button class="bg-grey-light w-full text-grey-darker p-2 rounded hover:bg-blue hover:text-white" @click="isOpen = true">Add Deviation</button>
    <modal v-if="isOpen" @close="isOpen = false" title="Add Deviation">
      <form @submit.prevent="submit">
        <div class="flex -mx-4 mb-2">

          <div class="mx-4">
            <label>Start Time</label>
            <input type="text" class="bg-grey-lighter p-4 rounded w-full" placeholder="00:00" v-model="rushRate.startTime" />
          </div>
          <div class="mx-4">
            <label>End Time</label>
            <input type="text" class="bg-grey-lighter p-4 rounded w-full" placeholder="00:00" v-model="rushRate.endTime" />
          </div>
        </div>

        <label>Multiplier</label>
        <input type="number" step="any" class="bg-grey-lighter p-4 rounded w-full mb-6" v-model="rushRate.multiplier" />

        <button class="bg-blue text-white rounded block w-full p-4">Save</button>
      </form>
    </modal>
  </div>

</template>
<script>
  import RateDeviation from "./RateDeviation";
  import {mapState} from "vuex";
  import Modal from "../Modal";

  let weekdays = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];

  export default {
    name: 'rate-day',
    components: {RateDeviation, Modal},
    props: {
      day: Number,
    },

    data() {
      return {
        isOpen: false,
        rushRate: {
          dayOfWeek: this.day,
          startTime: null,
          endTime: null,
          multiplier: null
        }
      }
    },

    computed: {
      ...mapState({
        selected: state => state.rates.selected
      }),

      weekday() {
        return weekdays[this.day - 1];
      },

      rushRatesForDay() {
        return this.selected.rushRates.filter((rushRate) => {
          return rushRate.dayOfWeek === this.day;
        })
      }
    },

    methods: {
      submit() {
        this.$store.dispatch('rates/createRushRate', { rushRate: this.rushRate, rateId: this.selected.id }).then(() => {
          this.isOpen = false;
        });
      }
    }
  }
</script>
