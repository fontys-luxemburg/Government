<template>
    <div>
        <back-button class="mb-2" to="/" />
        <div class="bg-white rounded p-6">
            <h1 class="mb-8">Register a new driver</h1>
            <form @submit.prevent="submitForm">
                <div class="flex -mx-4 mb-8">
                    <div class="w-1/3 mx-4">
                        <h2 class="mb-2">General</h2>
                        <p class="w-3/4 leading-normal">Basic information about this user. Further details can be updated after registration.</p>
                    </div>
                    <div class="w-2/3 mx-4">
                        <div class="mb-4">
                            <label class="mb-2 inline-block">
                                E-Mail
                            </label>
                            <input type="text" v-model="driver.email" class="w-full bg-grey-lighter rounded p-4"/>
                        </div>
                        <div class="mb-4">
                            <label class="mb-2 inline-block">
                                Model
                            </label>
                            <input type="text" v-model="driver.model" class="w-full bg-grey-lighter rounded p-4" placeholder="e.g. i3, Model S, 308..."/>
                        </div>
                        <div class="mb-4">
                            <label class="mb-2 inline-block">
                                Body Type
                            </label>
                            <select v-model="vehicle.bodyType" class="block appearance-none w-full bg-grey-lighter rounded p-4">
                                <option value="car">Car</option>
                                <option value="truck">Truck</option>
                                <option value="bus">Bus</option>
                            </select>
                        </div>
                        <div class="mb-4">
                            <label class="mb-2 inline-block">
                                Registration ID
                            </label>
                            <input type="text" v-model="vehicle.registrationID" class="w-full mb-2 bg-grey-lighter rounded p-4"/>
                            <p class="mb-2">Registration ID follow strict <a class="text-blue" href="https://guichet.public.lu/en/citoyens/transports-mobilite/transports-individuels/vehicule-motorise/numero-immatriculation.html">guidelines</a> and are unique per vehicle.</p>
                            <button type="button" class="text-blue hover:text-blue-dark" @click="getRegistrationID">Generate a valid registration ID</button>
                        </div>
                    </div>
                </div>

                <div class="flex -mx-4">
                    <div class="w-1/3 mx-4">
                        <h2 class="mb-4">Ownership details</h2>
                        <p class="leading-normal w-3/4">The owner of the vehicle. Kilometer registrations are billed to this driver. This step can be skipped.</p>
                    </div>
                    <div class="w-2/3 mx-4">
                        <div class="mb-8">
                            <label class="inline-block mb-2">Vehicle owner</label>
                            <v-select class="select bg-grey-lighter mb-2 border-none p-4 rounded"
                                      @search="fetchOptions"
                                      :options="options"
                                      :reduce="user => user.id"
                                      v-model="selected"
                                      label="name"
                                      :filterable="false"
                            />
                            <button type="button" class="text-blue hover:text-blue-dark">Register a new driver</button>
                        </div>

                        <button class="bg-blue text-white p-4 rounded">Register Vehicle</button>
                    </div>
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
        name: "vehicles-new",
        components: {BackButton},
        data: function() {
            return {
                vehicle: {
                    brand: null,
                    model: null,
                    bodyType: "car",
                    registrationID: null
                },
                isOpen: false,
                options: [],
                selected: null
            };
        },

        methods: {
            fetchOptions(search, loading) {
                loading(true);

                this.search(search, loading, this);
            },

            search: debounce((search, loading, vm) => {
                const options = {
                    method: "get",
                    headers: authHeader()
                };

                fetch(`/government/api/users?search=${escape(search)}`, options)
                    .then(res => res.json())
                    .then(results => {
                        loading(false);
                        vm.options = results;
                    });
            }, 300),

            submitForm() {
                this.$store.dispatch('vehicles/saveVehicle', this.vehicle);
            },

            getRegistrationID() {
                const requestOptions = {
                    method: "GET",
                    headers: {
                        ...authHeader(),
                        'Content-Type': 'application/json'
                    }
                };

                fetch('/government/api/vehicles/registrationID', requestOptions).then(resp => resp.text()).then(text => {
                    this.vehicle.registrationID = text;
                })
            }
        }
    }
</script>

<style>
    .select .vs__dropdown-toggle {
        border: none;
        padding: 0;
    }

</style>
