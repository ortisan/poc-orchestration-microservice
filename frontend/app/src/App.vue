<template>
  <div>
    <router-view></router-view>    
    <Error />
    <!-- Error Component -->
  </div>
</template>

<script>
import Error from "./components/Error.vue"
export default {
  name: 'App',
  components: {Error},

}
</script>

<style>
*,
*::before,
*::after {
  box-sizing: border-box;
}

html {
  font-size: 100%;
}
</style>