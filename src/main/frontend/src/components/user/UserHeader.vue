<template>
    <div v-if="status.loaded">
        <div class="mb-2">
            <back-button to="/" />
        </div>
        <div class="bg-white rounded mb-8">
            <div class="p-8">
                <h1 class="mb-2">{{ driver.name }}</h1>
            </div>

            <div class="flex px-4">
                <router-link
                        class="no-underline px-6 py-4 block text-grey-dark hover:text-blue"
                        :to="{ name: 'drivers#show', params: { driver_id: driver.id }}"
                >Basic</router-link>
                <!--<router-link-->
                        <!--class="no-underline px-6 py-4 block text-grey-dark hover:text-blue"-->
                        <!--:to="{ name: 'user#trackers', params: { driver_id: driver.id }}"-->
                <!--&gt;Trackers</router-link>-->
                <router-link
                        class="no-underline px-6 py-4 block text-grey-dark hover:text-blue"
                        :to="{ name: 'drivers#owner', params: { driver_id: driver.id }}"
                >Vehicles</router-link>
                <!--<router-link-->
                        <!--class="no-underline px-6 py-4 block text-grey-dark hover:text-blue"-->
                        <!--:to="{ name: 'vehicles#travels', params: { driver_id: driver.id }}"-->
                <!--&gt;Travels</router-link>-->
            </div>
        </div>
    </div>
</template>

<script>
    import {mapState} from 'vuex';
    import BackButton from "../BackButton";

    export default {
        name: "user-header",
        components: {BackButton},
        computed: {
            ...mapState({
                status: state => state.drivers.status,
                driver: state => state.drivers.value
            })
        },

        created() {
            if (this.driver && this.driver.id === this.$route.params.driver_id) return;

            this.$store.dispatch("drivers/findDriver", this.$route.params.driver_id);
        }
    };
</script>


<style scoped>
    .router-link-exact-active {
        @apply bg-blue text-white rounded-t;
    }

    .router-link-exact-active:hover {
        @apply text-white;
    }
</style>
