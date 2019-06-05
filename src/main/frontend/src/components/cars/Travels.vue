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
    import { Cartesian, Line } from 'laue';

    export default {
      name: "Travels",
      components: {
        LaCartesian: Cartesian,
        LaLine: Line,
        CarHeader
      },

      data: () => ({
        values: [
          { name: 'June 4', km: 20 },
          { name: 'June 5', km: 5 },
          { name: 'June 6', km: 51 },
          { name: 'June 7', km: 0 },
          { name: 'June 8', km: 25 },
          { name: 'June 9', km: 14 },
          { name: 'June 10', km: 22 }
        ]
      }),
}
</script>

<style scoped>

</style>