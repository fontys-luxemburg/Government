<template>
  <div class="max-w-sm mx-auto">
    <div class="bg-white rounded p-6 mb-8">
      <h1 class="text-center mb-8">Login</h1>
      <form @submit.prevent="handleSubmit">
        <div class="mb-4">
          <label class="block mb-2">Email</label>
          <input type="text" placeholder="Email" class="bg-grey-lightest p-4 block rounded w-full" v-model="email">
        </div>
        <div class="mb-8">
          <label class="block mb-2">Password</label>
          <input type="password" placeholder="Password" class="bg-grey-lightest p-4 block rounded w-full" v-model="password">
        </div>
        <button :disabled="loggingIn" class="w-full bg-blue p-4 rounded text-white">Log in</button>
      </form>
    </div>
  </div>
</template>

<script>
    export default {
        name: "login",
        data() {
            return {
                email: '',
                password: '',
                submitted: false,
            };
        },
        computed: {
            loggingIn () {
                return this.$store.state.auth.status.loggingIn;
            }
        },
        created() {
            this.$store.dispatch('auth/logout');
        },
        methods: {
            handleSubmit(e) {
                this.submitted = true;
                const { email, password } = this;
                const { dispatch } = this.$store;

                if (email && password) {
                    dispatch('auth/login', { email, password });
                }
            }
        }
    }
</script>

<style scoped>

</style>