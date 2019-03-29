<template>
  <div id="app">
    <div class="bg-white p-2 border-b border-grey-light">
      <img alt="Gouvernement du Grand-Duché de Luxembourg" src="./assets/gov-light-2x.png" class="h-12">
    </div>
    <div class="container mx-auto px-4">
      <div class="bg-white rounded mt-4 p-8">

        <img alt="Vue logo" src="./assets/logo.png">
        <router-view />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'app',
}
</script>