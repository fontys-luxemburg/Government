<template>
  <div>
    <car-header />
    <div class="bg-white rounded p-8">
      <h2 class="mb-8">Tracker History</h2>

      <table class="w-full">
        <thead class="border-b-2 border-grey">
          <tr class="font-normal">
            <td class="py-4">Tracker ID</td>
            <td class="py-4">Type</td>
            <td class="py-4">Installed on</td>
            <td class="py-4">Status</td>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td class="py-4">a28594b0-dc70-4745-9e54-b3b3fb61c437</td>
            <td class="py-4">Trax P1</td>
            <td class="py-4">27-03-2014</td>
            <td class="py-4">
              <div class="uppercase bg-green-lightest inline-block p-2 text-xs text-green-dark tracking-wide font-bold rounded">active</div>
            </td>
          </tr>

          <tr v-for="tracker in trackers" v-bind:key="tracker.UUID">
            <td class="py-4">{{ tracker.UUID }}</td>
            <td class="py-4">Trax P1</td>
            <td class="py-4">{{ tracker.createdAt }}</td>
            <td class="py-4">
              <div class="uppercase bg-green-lightest inline-block p-2 text-xs text-green-dark tracking-wide font-bold rounded" v-if="tracker.destroyedDate === null">active</div>
              <div class="uppercase bg-red-lightest inline-block p-2 text-xs text-green-dark tracking-wide font-bold rounded" v-else>inactive</div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
    import CarHeader from "./CarHeader";
    export default {
        name: "Trackers",
        components: { CarHeader },

        computed: {
            ...mapState({
              trackers: state => state.trackers.all,
              status: state => state.trackers.status
            })
        },

        created() {
          this.$store.dispatch("trackers/findTrackers", this.$route.params.license_number)
        }
    }
</script>

<style scoped>

</style>