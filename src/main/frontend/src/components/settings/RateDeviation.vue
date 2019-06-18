<template>
  <div class="bg-blue-lighter text-blue-darker font-normal py-1 px-2 rounded border border-blue-light">
    <span class="text-xs">{{ start }} - {{ end }}</span>
    <span class="text-sm font-semibold block mb-2">Rush hour</span>
    {{durationPercentage}}
  </div>
</template>
<script>
  import moment from 'vue-moment';

  export default {
    name: 'rate-deviation',
    props: {
      start: String,
      end: String
    },

    computed: {
      durationPercentage() {
        const startMoment = moment(this.start, 'HH:mm');
        const endMoment = moment(this.end, 'HH:mm');

        const ms = startMoment.diff(endMoment);
        console.log(moment.duration(ms));

        return moment.duration(ms);
      }
    }
  }
</script>