<template>
  <div>
    <car-header />
    <div class="bg-white rounded p-8" v-if="status.loaded">


      <div class="flex justify-between items-center mb-4">
        <h2>Ownership history</h2>
        <transfer-ownership-modal/>
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
    import {authHeader} from "../../helpers";
    import TransferOwnershipModal from "./TransferOwnershipModal";

    export default {
        name: "Owner",

        components: {TransferOwnershipModal, CarHeader},

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

        created() {
            this.$store.dispatch("ownerships/getOwnerships", this.$route.params.license_number );
        }
    }
</script>

