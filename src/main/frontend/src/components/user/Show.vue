<template>
    <div>
        <div v-if="driverStatus.failed" class="flex items-center justify-center flex-col mt-32">
            <h1 class="mb-8">We couldn't find this driver</h1>
        </div>

        <div v-if="driverStatus.loaded">
            <user-header/>

            <div class="bg-white rounded p-8">
                <!--<div class="mb-4 flex justify-between items-center">-->
                    <!--<h2>Vehicle information</h2>-->
                    <!--<router-link-->
                            <!--:to="{ name: 'user#edit', params: { driver_id: user.id }}"-->
                            <!--class="no-underline bg-grey-lighter hover:bg-grey-light hover:text-grey-darkest text-grey-darker py-4 px-8 rounded"-->
                    <!--&gt;-->
                        <!--Edit Vehicle-->
                    <!--</router-link>-->
                <!--</div>-->
                <table class="w-full">

                    <tr class="border-b border-grey-lighter">
                        <td class="py-4">Name</td>
                        <td class="py-4 w-2/3">{{driver.name}}</td>
                    </tr>
                    <tr class="border-b border-grey-lighter">
                        <td class="py-4">E-mail</td>
                        <td class="py-4 w-2/3">{{driver.email}}</td>
                    </tr>
                </table>
            </div>
        </div>

    </div>
</template>

<script>
    import UserHeader from "./UserHeader";
    import { mapState } from "vuex";
    import MoonLoader from "vue-spinner/src/MoonLoader.vue";

    export default {
        name: "user-show",

        components: { UserHeader, MoonLoader },

        computed: {
            ...mapState({
                driver: state => state.drivers.value,
                driverStatus: state => state.drivers.status
            })
        },

        created() {
            if (this.driver && this.driver.id === this.$route.params.driver_id) return;
            this.$store.dispatch("drivers/findDriver", this.$route.params.driver_id);
        }
    }
</script>
