<template>
  <div>
    <car-header />
    <div v-if="status.loaded" class="bg-white rounded p-8">
      <div class="flex justify-between align-center mb-8">
        <h2>Tracker History</h2>
        <tracker-modal />
      </div>

      <table class="w-full">
        <thead class="border-b-2 border-grey">
          <tr class="font-normal">
            <td class="py-4">Tracker ID</td>
            <td class="py-4">Installed on</td>
            <td class="py-4">Status</td>
          </tr>
        </thead>
        <tbody>
          <tr v-for="tracker in trackers" v-bind:key="tracker.trackerId">
            <td class="py-4">{{ tracker.trackerId }}</td>
            <td class="py-4">{{ tracker.createdAt }}</td>
            <td class="py-4">
              <div class="uppercase bg-green-lightest inline-block p-2 text-xs text-green-dark tracking-wide font-bold rounded" v-if="tracker.destroyedDate === null">active</div>
              <div class="uppercase bg-red-lightest inline-block p-2 text-xs text-red-dark tracking-wide font-bold rounded" v-else>inactive</div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
    import CarHeader from "./CarHeader";
    import {mapState} from "vuex";
    import TrackerModal from "./TrackerModal";

    export default {
        name: "Trackers",
        components: {TrackerModal, CarHeader },

        computed: {
            ...mapState({
              trackers: state => state.trackers.all,
              status: state => state.trackers.status
            })
        },

        created() {
          this.$store.dispatch("trackers/getTrackers", this.$route.params.license_number)
        }
    }
</script>

<style scoped>

</style>