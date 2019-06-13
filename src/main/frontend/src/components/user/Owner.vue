<template>
    <div>
        <user-header/>
        <div class="bg-white rounded p-8" v-if="ownership_status.loaded">


            <div class="flex justify-between items-center mb-4">
                <h2>Ownership history</h2>
            </div>
            <table class="w-full">
                <thead class="border-b-2 border-grey">
                <tr class="font-normal">
                    <td class="py-4">Registration id</td>
                    <td class="py-4">From</td>
                    <td class="py-4">Until</td>
                </tr>
                </thead>
                <tbody>
                <tr v-for="ownership in ownerships" v-bind:key="ownership.id">
                    <td class="py-4">{{ ownership.vehicleRegistrationID }}</td>
                    <td class="py-4">{{ ownership.createdAt | moment("MMMM Do YYYY") }}</td>
                    <td class="py-4">{{ ownership.endDate | moment("MMMM Do YYYY") }}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script>
    import UserHeader from "./UserHeader";
    import {mapState} from "vuex";

    export default {
        name: "Owner",

        components: {UserHeader},

        data: function() {
            return {
                modalOpen: false,
                options: []
            }
        },

        computed: {
            ...mapState({
                ownerships: state => state.ownerships.all,
                ownership_status: state => state.ownerships.status
            })
        },

        created() {
            this.$store.dispatch("ownerships/getOwnershipsByDriver", this.$route.params.driver_id );
        }
    }
</script>

