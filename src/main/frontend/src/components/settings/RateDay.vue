<template>
  <div class="w-1/7 mx-2">
    <span class="mb-2">{{ weekday }}</span>
    <div class="bg-grey-lighter rounded p-1 min-h-screen">
      <rate-deviation start="07:00" end="09:00" />
    </div>
  </div>

</template>
<script>
  import RateDeviation from "./RateDeviation";

  let weekdays = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];

  export default {
    name: 'rate-day',
    components: {RateDeviation},
    props: {
      day: Number,
    },
    computed: {
      weekday() {
        return weekdays[this.day - 1];
      }
    }
  }
</script>
