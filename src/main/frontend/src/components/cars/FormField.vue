<template>
  <div class="form-group">
    <label class="form-label">{{ name }}</label>
    <input type="text" ref="textField" class="form-input" :value="value" @input="update()"/>
  </div>
</template>
<script>
    export default {
        name: 'form-field',
        props: {
            value: String,
            name: String
        },

        methods: {
            update() {
                this.$emit('input', this.$refs.textField.value);
            }
        }
    }
</script>
<style scoped lang="postcss">

  .form-group {
    @apply flex -mx-4 items-center mb-2;
  }

  .form-label {
    @apply w-1/4 text-right mx-4;

  }

  .form-input {
    @apply bg-grey-lighter mx-4 w-full p-4 rounded;
  }

</style>