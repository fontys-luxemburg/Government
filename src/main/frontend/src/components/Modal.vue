<template>
  <div class="modal-container">
    <div class="modal-wrapper shadow-lg rounded">
      <div class="flex justify-between items-center p-4 border-b">
        <span>Transfer Ownership</span>
        <button class="flex items-center text-grey hover:text-grey-dark" @click="$emit('close')">
          <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="w-5 h-5"><line x1="18" y1="6" x2="6" y2="18"></line><line x1="6" y1="6" x2="18" y2="18"></line></svg>
        </button>
      </div>
      <div class="p-4">
        <slot></slot>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "modal"
    }
</script>

<style scoped>
  .modal-container {
    position: fixed;
    background-color: rgba(0, 0, 0, 0.5);
    width: 100vw;
    height: 100vh;
    top: 0;
    left: 0;
    display: flex;
    align-items: center;
    justify-content: center;
  }

  .modal-wrapper {
    background-color: #ffffff;
    width: 460px;
  }
</style>
