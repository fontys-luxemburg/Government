<template>
  <div>
    <div v-if="selected" class="bg-white rounded p-6 mb-8">
      <div class="flex justify-between mb-4">
        <h1>Current Rate – #{{ selected.id }}</h1>
        <button class="text-white bg-blue py-4 px-6 rounded" @click="isOpen = true">New Rate</button>

        <modal v-if="isOpen" @close="isOpen = false" title="New Rate">
          <form @submit.prevent="submit">
            <label class="block mb-2">Car Rate (€ per km)</label>
            <input class="block bg-grey-lighter w-full p-4 rounded mb-2" type="number" min="0" step="any" placeholder="Car Rate" v-model="rate.carRate" />

            <label class="block mb-2">Bus Rate (€ per km)</label>
            <input class="block bg-grey-lighter w-full p-4 rounded mb-2" type="number" min="0" step="any" placeholder="Car Rate" v-model="rate.busRate" />

            <label class="block mb-2">Truck Rate (€ per km)</label>
            <input class="block bg-grey-lighter w-full p-4 rounded mb-6" type="number" min="0" step="any" placeholder="Car Rate" v-model="rate.truckRate" />

            <button type="submit" class="bg-blue rounded text-white block p-4 w-full">Save</button>
          </form>
        </modal>
      </div>
      <div class="bg-grey-lighter p-4 rounded mb-4">
        <span class="mr-4"><strong>Car:</strong> €{{selected.carRate}} per km</span>
        <span class="mr-4"><strong>Truck:</strong> €{{selected.truckRate}} per km</span>
        <span class="mr-4"><strong>Bus:</strong> €{{selected.busRate}} per km</span>
      </div>
      <div class="flex -mx-2">
        <rate-day v-for="i in 7" :key="i" :day="i"/>
      </div>
    </div>

    <div class="bg-white rounded p-6">
      <h1 class="mb-3">Former rates</h1>

      <div v-for="rate in all" class="border rounded p-4 text-md mb-2">
        {{ rate.createdAt | moment('dddd, MMMM Do YYYY HH:mm')}}
      </div>
    </div>
  </div>
</template>

<script>
  import RateDay from "./RateDay";
  import {mapState} from "vuex";
  import Modal from "../Modal";

  export default {
    name: "Index",

    components: { Modal, RateDay },

    data() {
      return {
        isOpen: false,
        rate: {
          carRate: 0.0,
          truckRate: 0.0,
          busRate: 0.0
        }
      }
    },

    computed: {
      ...mapState({
        all: state => state.rates.all,
        selected: state => state.rates.selected,
        status: state => state.rates.status
      })
    },

    methods: {
      submit() {
        this.$store.dispatch('rates/createRate', this.rate).then(() => {
          this.isOpen = false;
        });
      }
    },

    mounted() {
      this.$store.dispatch('rates/getRates');
    }
  }
</script>

