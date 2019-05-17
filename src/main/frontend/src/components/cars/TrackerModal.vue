<template>
  <div>
    <button
      class="bg-grey-lighter hover:bg-grey-light hover:text-grey-darkest text-grey-darker py-4 px-8 rounded"
      @click="isOpen = true"
    >Set tracker</button>

    <modal v-if="isOpen" @close="isOpen = false" title="Set Tracker">
      <p class="bg-yellow-lighter p-4 rounded mb-6 text-yellow-darker">
        <strong>Warning!</strong> This action cannot be reversed.
      </p>
      <form @submit.prevent="didPressSubmit">
        <div class="mb-4">
          <label class="block mb-2 text-grey-dark">Tracker ID</label>
          <input type="text" v-model="trackerID" class="w-full bg-grey-lighter rounded p-4" placeholder="Tracker ID"/>
        </div>

        <button
          class="button p-4 bg-red hover:bg-red-dark text-white rounded text-center w-full"
          :disabled="trackerID.length === 0"
        >Set Tracker</button>
      </form>
    </modal>
  </div>
  
</template>

<script>
    import Modal from "../Modal";

    export default {
        name: "tracker-modal",

        components: { Modal },

        data: function() {
            return {
                isOpen: false,
                trackerID: ""
            }
        },

        methods: {
            didPressSubmit() {
                const registrationID = this.$route.params.license_number;

                this.$store.dispatch("trackers/createTracker", registrationID).then(() => {
                    this.isOpen = false;
                });
            }
        }
    }
</script>

<style scoped>

</style>