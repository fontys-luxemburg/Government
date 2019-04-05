<template>
  <div id="app">
    <div class="bg-white p-2 border-b border-grey-light mb-8">
      <router-link to="/">
        <img alt="Gouvernement du Grand-Duché de Luxembourg" src="./assets/gov-light-2x.png" class="h-12">
      </router-link>
    </div>
    <div class="container mx-auto px-4">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: 'app',
}
</script>