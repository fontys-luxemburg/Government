<template>
  <div id="app">
    <notices/>
    <div class="bg-white p-2 border-b border-grey-light mb-8 flex justify-between items-center">
      <router-link to="/" class="flex-none mr-16">
        <img
          alt="Gouvernement du Grand-Duché de Luxembourg"
          src="./assets/gov-light-2x.png"
          class="h-12"
        >
      </router-link>

      <div class="w-full">
        <input type="text" placeholder="Search for vehicles, users or trackers" class="bg-grey-lighter p-4 w-full rounded"/>
      </div>

      <router-link
        v-if="loggedIn"
        to="/login"
        class="flex flex-none items-center pr-8 no-underline text-black ml-16"
      >
        <div>{{ user.name }}</div>
        <div
          class="bg-grey-light w-8 h-8 flex items-center justify-center rounded-full ml-4 text-sm"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            viewBox="0 0 24 24"
            fill="none"
            stroke="currentColor"
            stroke-width="2"
            stroke-linecap="round"
            stroke-linejoin="round"
            class="w-4 h-4 text-grey-dark"
          >
            <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path>
            <circle cx="12" cy="7" r="4"></circle>
          </svg>
        </div>
      </router-link>
    </div>
    <div class="container mx-auto px-4">
      <router-view/>
    </div>
    <div class="h-16"></div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import Notices from "./components/Notices";

export default {
  name: "app",
  computed: {
    ...mapState({
      loggedIn: state => state.auth.status.loggedIn,
      user: state => state.auth.user
    })
  },
  components: {
    Notices
  }
};
</script>
