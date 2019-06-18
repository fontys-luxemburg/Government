<template>
    <div>
        <user-header/>
        <div class="bg-white rounded p-8" v-if="travels_status.loaded">


            <div class="flex justify-between items-center mb-4">
                <h2>Ownership history</h2>
            </div>
            <table class="w-full">
                <thead class="border-b-2 border-grey">
                <tr class="font-normal">
                    <td class="py-4">Registration id</td>
                    <td class="py-4">From</td>
                    <td class="py-4">Until</td>
                    <td class="py-4">Distance traveled in Km</td>
                </tr>
                </thead>
                <tbody>
                <tr v-for="travel in travels" v-bind:key="travel.id">
                    <td class="py-4">{{ travel.registrationID }}</td>
                    <td class="py-4">{{ travel.createdAt | moment("MMMM Do YYYY") }}</td>
                    <td class="py-4">{{ travel.endDate | moment("MMMM Do YYYY") }}</td>
                    <td class="py-4">{{ travel.distanceTraveledKm }}</td>
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
        name: "travels-driver",

        components: {UserHeader},

        data: function() {
            return {
                modalOpen: false,
                options: []
            }
        },

        computed: {
            ...mapState({
                travels: state => state.travels.all,
                travels_status: state => state.travels.status
            })
        },

        created() {
            this.$store.dispatch("trackers/getTripsOfDriver", this.$route.params.driver_id );
        }
    }
</script>

<style scoped>

</style>
