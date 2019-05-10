<template>
  <div>
    <button
      class="bg-grey-lighter hover:bg-grey-light hover:text-grey-darkest text-grey-darker py-4 px-8 rounded"
      @click="isOpen = true"
    >Transfer Ownership</button>

    <modal v-if="isOpen" @close="isOpen = false">
      <p class="bg-yellow-lighter p-4 rounded mb-6 text-yellow-darker">
        <strong>Warning!</strong> This action cannot be reversed.
      </p>
      <form @submit.prevent="didPressSubmit">
        <div class="mb-4">
          <label class="block mb-2 text-grey-dark">New owner's name</label>
          <v-select
            @search="fetchOptions"
            :options="options"
            :reduce="user => user.id"
            v-model="selected"
            label="name"
            :filterable="false"
          />
        </div>

        <button
          class="button p-4 bg-red hover:bg-red-dark text-white rounded text-center w-full"
          :disabled="!selected"
        >Transfer Ownership</button>
      </form>
    </modal>
  </div>
</template>
<script>
import Modal from "../Modal";
import { authHeader } from "../../helpers";
import { debounce } from "underscore";

export default {
  name: "transfer-ownership-modal",
  components: { Modal },

  data: function() {
    return {
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

    didPressSubmit() {
      if (this.selected) {
        const registrationID = this.$route.params.license_number;
        this.$store.dispatch("ownerships/transfer", {
          registrationID,
          userID: this.selected
        });
      }
    }
  }
};
</script>

<style>
.button:disabled,
.button[disabled] {
  @apply bg-red-light;
  cursor: not-allowed;
}

.button:disabled:hover,
.button[disabled]:hover {
  @apply bg-red-light;
  cursor: not-allowed;
}
</style>
