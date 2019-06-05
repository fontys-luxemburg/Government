<template>
  <div class="w-full">
    <input type="text" ref="input" v-on:keyup.enter="navigateToSearch" v-model="query" placeholder="Search for vehicles, users or trackers (Press '/' to focus)" class="bg-grey-lighter p-4 w-full rounded"/>
  </div>
</template>
<script>
  export default {
    name: 'search-bar',
    data() {
      return {
        query: null
      }
    },
    methods: {
      navigateToSearch() {
        this.$store.dispatch("search/search", this.query);

        this.$router.push({
          name: "search",
          query: { query: this.query }
        });
      }
    },

    mounted() {
      window.addEventListener('keyup', e => {
        if(e.key === '/') {
          this.$nextTick(() => this.$refs.input.focus())
        }
      });
    }
  }
</script>