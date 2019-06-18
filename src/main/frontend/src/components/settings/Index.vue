<template>
  <div class="bg-white rounded p-6">
    <h1>Update rates</h1>
    <div class="flex -mx-2">
      <rate-day v-for="i in 7" :key="i" :day="i"/>
    </div>
  </div>
</template>

<script>
  import RateDay from "./RateDay";

  export default {
    name: "Index",
    components: {RateDay}
  }
</script>

