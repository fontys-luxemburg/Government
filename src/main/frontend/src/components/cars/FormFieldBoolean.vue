<template>
  <div class="form-group">
    <div class="form-label"></div>
    <label class="w-full mx-4">
      <input type="checkbox" ref="checkbox" :checked="value" @change="update()"/>
      {{ name }}
    </label>
  </div>
</template>
<script>
    export default {
        name: 'form-field-boolean',
        props: {
            value: Boolean,
            name: String
        },

        methods: {
            update() {
                this.$emit('input', this.$refs.checkbox.checked);
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

</style>