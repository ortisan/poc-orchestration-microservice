<template>
  <UiSnackbarContainer ref="snackbar" :duration="6000" />
  <!-- <p v-if="errors.length">
      <b>Ops!</b>
      <ul>
        <li v-for="(error, index) in errors" :key="index" class="text-danger"> {{ error.message }}</li>
      </ul>
  </p> -->
</template>

<script>
import { UiSnackbarContainer } from 'keen-ui'
import { mapActions, mapState } from 'vuex'
export default {
  name: 'Error',
  components: { UiSnackbarContainer },
  methods: {
    ...mapActions
  },
  computed: {
    ...mapState({
      errors: state => state.common.errors,
      errors_messages: state => state.common.errors_messages
    })
  },
  watch: {
    errors(errors) {
      if (errors) {
        this.$refs.snackbar.createSnackbar({
          message: this.errors_messages
        })
      }
    }
  }
}
</script>
