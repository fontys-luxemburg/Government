<template>
    <div>
        <back-button class="mb-2" to="/" />
        <div class="bg-white rounded p-6">
            <h1 class="mb-8">Register a new driver</h1>
            <form @submit.prevent="submitForm">
                <div class="flex -mx-4 mb-8">
                    <div class="w-1/3 mx-4">
                        <h2 class="mb-2">General</h2>
                    </div>
                    <div class="w-2/3 mx-4">
                        <div class="mb-4">
                            <label class="mb-2 inline-block">
                                Name
                            </label>
                            <input type="text" v-model="driver.name" class="w-full bg-grey-lighter rounded p-4" placeholder="e.g. Henk Paulsen"/>
                        </div>
                        <div class="mb-4">
                            <label class="mb-2 inline-block">
                                E-mail
                            </label>
                            <input type="text" v-model="driver.email" class="w-full bg-grey-lighter rounded p-4" placeholder="e.g. HenkPaulsen@Hotmail.com"/>
                        </div>
                    </div>
                </div>

                <div class="flex -mx-4">
                        <button class="bg-blue text-white p-4 rounded">Register driver</button>
                </div>
            </form>
        </div>
    </div>
</template>

<script>
    import BackButton from "../BackButton";
    import {debounce} from 'lodash';
    import {authHeader} from "../../helpers";

    // import Select from "vue-select/src/components/Select";
    export default {
        name: "driver-new",
        components: {BackButton},
        data: function() {
            return {
                driver: {
                    id: null,
                    name: null,
                    email: null
                }
            };
        },

        methods: {
            submitForm() {
                this.$store.dispatch('drivers/saveDriver', this.driver);
            },
        }
    }
</script>
