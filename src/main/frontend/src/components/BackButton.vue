<template>
  <router-link
    :to="to"
    class="no-underline text-grey-dark inline-flex items-center hover:text-grey-darker"
  >
    <svg
      xmlns="http://www.w3.org/2000/svg"
      width="24"
      height="24"
      viewBox="0 0 24 24"
      fill="none"
      stroke="currentColor"
      stroke-width="2"
      stroke-linecap="round"
      stroke-linejoin="round"
      class="feather feather-chevron-left"
    >
      <polyline points="15 18 9 12 15 6"></polyline>
    </svg>
    Back
  </router-link>
</template>
<script>
    export default {
        name: 'back-button',
        props: {
            to: [String, Object]
        }
    }
</script>
