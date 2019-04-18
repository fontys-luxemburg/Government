<template>
  <div>
    <car-header />
    <div class="bg-white rounded p-8" v-if="status.loaded">

      <modal v-if="modalOpen" @close="modalOpen = false">
        <p class="bg-yellow-lighter p-4 rounded mb-6 text-yellow-darker">
          <strong>Warning!</strong> This action cannot be reversed.
        </p>
        <form>
          <div class="mb-4">
            <label class="block mb-2">New owner's name</label>
            <v-select @search="fetchOptions" :options="options" label="name" :filterable="false" />
          </div>

          <button class="p-4 bg-red hover:bg-red-dark text-white rounded text-center w-full">Transfer Ownership</button>
        </form>
      </modal>

      <div class="flex justify-between items-center mb-4">
        <h2>Ownership history</h2>
        <button class="bg-grey-lighter hover:bg-grey-light hover:text-grey-darkest text-grey-darker py-4 px-8 rounded"
                @click="modalOpen = true">
          Transfer Ownership
        </button>
      </div>
      <table class="w-full">
        <thead class="border-b-2 border-grey">
          <tr class="font-normal">
            <td class="py-4">Owner</td>
            <td class="py-4">From</td>
            <td class="py-4">Until</td>
          </tr>
        </thead>
        <tbody>
          <tr v-for="ownership in ownerships" v-bind:key="ownership.id">
            <td class="py-4">{{ ownership.userName }}</td>
            <td class="py-4">{{ ownership.createdAt | moment("MMMM Do YYYY") }}</td>
            <td class="py-4">{{ ownership.endDate | moment("MMMM Do YYYY") }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
    import CarHeader from "./CarHeader";
    import {mapState} from "vuex";
    import Modal from "../Modal";
    import {authHeader} from "../../helpers";
    export default {
        name: "Owner",

        components: {Modal, CarHeader},

        data: function() {
            return {
                modalOpen: false,
                options: []
            }
        },

        computed: {
            ...mapState({
                ownerships: state => state.ownerships.all,
                status: state => state.ownerships.status
            })
        },

        methods: {
            fetchOptions(search, loading, vm) {
                loading(true);

                const options = {
                    method: 'get',
                    headers: authHeader()
                }

                fetch(`/government/api/users?search=${escape(search)}`, options)
                    .then(res => res.json())
                    .then(results => {
                        loading(false);
                        this.options = results;
                    })

            }
        },

        created() {
            this.$store.dispatch("ownerships/getOwnerships", this.$route.params.license_number );
        }
    }
</script>

<style scoped>

</style>