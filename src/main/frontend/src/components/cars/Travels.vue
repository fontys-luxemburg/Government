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

    export default {
      name: "Travels",
      components: {
        LaCartesian: Cartesian,
        LaLine: Line,
        CarHeader
      },

      data: () => ({
        values: [
          { name: 'Page A', km: 50 },
          { name: 'Page B', km: 23 },
          { name: 'Page C', km: 280 },
          { name: 'Page D', km: 4 },
          { name: 'Page E', km: 1 },
          { name: 'Page F', km: 94 },
          { name: 'Page G', km: 230 },
          { name: 'Page H', km: 13 },
          { name: 'Page I', km: 14 }
        ]
      })
}
</script>

<style scoped>

</style>