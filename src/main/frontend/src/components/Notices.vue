<template>
  <div class="fixed w-full flex justify-center p-4 z-50">
    <transition name="fade">
      <div v-if="notice" class="bg-white shadow-lg inline-flex px-4 py-2 pl-2 rounded-full items-center">
        <div class="w-6 h-6 bg-green text-white flex justify-center items-center rounded-full mr-4">
          <svg
            class="w-4 h-4 stroke-current"
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="24"
            viewBox="0 0 24 24"
            fill="none"
            stroke="currentColor"
            stroke-width="2"
            stroke-linecap="round"
            stroke-linejoin="round"
          >
            <polyline points="20 6 9 17 4 12"></polyline>
          </svg>
        </div>
        {{ notice.message }}
      </div>
    </transition>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "notices",
  computed: {
    ...mapState({
      notice: state => state.notices.notice
    })
  }
};
</script>

<style scoped>
.fade-enter-active,
.fade-leave-active {
  transition: transform 0.3s ease-in-out;
}
.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  transform: translateY(-120%);
}
</style>
